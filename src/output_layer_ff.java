
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

	
	
	
}
