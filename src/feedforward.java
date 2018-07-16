
public class feedforward extends layer {

	protected matrix x; // this is the input
	protected matrix weights;
	protected matrix bias;
	protected matrix dz;
	protected matrix y;
	protected matrix vdw;
	protected matrix sdw;
	protected double beta_1 = 0.9;
	protected double beta_2 = 0.999;
	protected double epsilon = Math.pow(10.0, -8);
	
	feedforward(int input_dims, int output_dims, activation_function f) {
		super(input_dims, output_dims, f);
		weights = new matrix(output_dims, input_dims);
		bias = new matrix(output_dims,1);
		initialize_weights(); 
		initialize_bias(); 
		///  stuff for adam optimizer
		vdw = new matrix(output_dims, input_dims); // should be initialized to zero
		sdw = new matrix(output_dims, input_dims); // should be initialized to zero
		

	}
	
	feedforward(int input_dims, int output_dims) {
		super(input_dims,output_dims);
		weights = new matrix(output_dims, input_dims);
		bias = new matrix(output_dims,1);
		initialize_weights(); 
		initialize_bias(); 
		///  stuff for adam optimizer

		vdw = new matrix(output_dims, input_dims); // should be initialized to zero
		sdw = new matrix(output_dims, input_dims);// should be initialized to zero
		
	}
	
	void initialize_weights() {
		tensor.initialize(weights, -3,3);
	}
	
	void initialize_bias() {
		tensor.initialize(bias,-3,3);
	}
	
	public void fp() {
		y = tensor.dot(weights, x);///.add(bias);
		feedInput(f.f(y));
	}
	
	public void bp(matrix test, double learning_rate) {
		dz();
		updateWeights(learning_rate);
	}
	

	public void bp(double learning_rate) {
		dz();
		updateWeights(learning_rate);
	}
	
	

	public void dz() {
		matrix w = w_next();
		matrix z = dz_next();
		matrix w_t = tensor.transpose(w);
		matrix m = tensor.dot(w_t, z);
		dz = tensor.mult(m, f.f_prime(y));
	}
	
	
	void updateWeights(double learning_rate) {
		weights = tensor.sub(weights, tensor.scalar_mult(learning_rate, dw()));
	}
	
	matrix dz_next(){
		return next.getDz();
	}
	
	matrix w_next(){
		return next.getWeights();
	}
	
	
	matrix dw() {
		return tensor.dot(dz,tensor.transpose(x));
	}
	
	void set_x(matrix m) {
		x = m;
	}
	
	void feedInput(matrix m) {
		next.set_x(m);
	}
	
	matrix getWeights() {
		return weights;
	}
	
	matrix getDz() {
		return dz;
	}
	
	layer next() {
		return next;
	}
	
	layer prev() {
		return prev;
	}
	
	void set_next(layer l) {
		next = l;
		
	}
	
	void set_prev(layer l) {
		prev = l;
		
	}
	
	matrix get_output() {
		return y;
	}
	
	public void dz(matrix test) {
		dz();
	}
	
	void bp_adam(double learning_rate, int epoch_num, matrix test) {
		matrix dt = dw();
		vdw = tensor.add(tensor.scalar_mult(beta_1, vdw), matrix.scalar_mult((1.0-beta_1), dt));
		sdw = tensor.add(tensor.scalar_mult(beta_2, sdw), matrix.scalar_mult((1.0-beta_2), tensor.mult(dt, dt)));
		matrix vdw_corrected = tensor.scalar_mult((1/(1-Math.pow(beta_1, epoch_num))), vdw);
		matrix sdw_corrected = tensor.scalar_mult((1/(1-Math.pow(beta_2, epoch_num))), sdw);
		matrix m2 = tensor.divides(vdw_corrected,tensor.sub(tensor.sqrt(sdw_corrected), matrix.scalar_matrix(epsilon, sdw_corrected.rows, sdw_corrected.columns)));
		weights = tensor.sub(weights, tensor.scalar_mult(learning_rate, m2));
		
	}

	@Override
	void bp_adam(double learning_rate, int epoch_num) {
		// TODO Auto-generated method stub
		
	}

	

//
	
}
