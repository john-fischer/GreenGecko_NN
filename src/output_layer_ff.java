
public class output_layer_ff extends feedforward {
			
	output_layer_ff(int output_dims, int input_dims, activation_function f) {
		super(output_dims, input_dims,f);
		
	}
	
	output_layer_ff(int output_dims, int input_dims) {
		super(output_dims, input_dims);
		initialize_weights(); 
		initialize_bias(); 
	}
	
	public void fp() {
		y = f.f(tensor.dot(weights, x));///.add(bias);
	}
	
	public void bp(matrix test, double learning_rate) {
		dz = tensor.sub(y,test);
		updateWeights(learning_rate);

	}
	
	public void dz(matrix test) {
		dz = tensor.sub(y,test);
	}
	
	
	void bp_adam(double learning_rate, int epoch_num, matrix test) {
		matrix dt = weights;
		vdw = tensor.add(tensor.scalar_mult(beta_1, vdw), matrix.scalar_mult((1.0-beta_1), dt));
		sdw = tensor.add(tensor.scalar_mult(beta_2, sdw), matrix.scalar_mult((1.0-beta_2), tensor.mult(dt, dt)));
		matrix vdw_corrected = tensor.scalar_mult((1/(1-Math.pow(beta_1, epoch_num))), vdw);
		matrix sdw_corrected = tensor.scalar_mult((1/(1-Math.pow(beta_2, epoch_num))), sdw);
		matrix m2 = tensor.divides(vdw_corrected,tensor.sub(tensor.sqrt(sdw_corrected), matrix.scalar_matrix(epsilon, sdw_corrected.rows, sdw_corrected.columns)));
		weights = tensor.sub(weights, tensor.scalar_mult(learning_rate, m2));
		
	}
	
	
	
}
