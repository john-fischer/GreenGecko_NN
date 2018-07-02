
public class feedforward extends layer {

	protected matrix x; // this is the input
	protected matrix weights;
	protected matrix bias;
	protected matrix dz;
	protected matrix y;
	
	feedforward(int input_dims, int output_dims, activation_function f) {
		super(input_dims, output_dims, f);
		weights = new matrix(output_dims, input_dims);
		bias = new matrix(output_dims,1);
		initialize_weights(); 
		initialize_bias(); 
	}
	
	feedforward(int input_dims, int output_dims) {
		super(input_dims,output_dims);
		weights = new matrix(output_dims, input_dims);
		bias = new matrix(output_dims,1);
		initialize_weights(); 
		initialize_bias(); 
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
	

	void dz() {
		matrix w = w_next();
		matrix z = dz_next();
		matrix w_t = tensor.transpose(w);
		matrix m = tensor.dot(w_t, z);
		dz = tensor.mult(m, f.f_prime(y));
	}
	
	void updateWeights(double learning_rate) {
		weights = tensor.sub(weights, dw());
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
	

	

//
	
}
