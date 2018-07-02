
public abstract class layer {
	protected layer next;
	protected layer prev;
	protected activation_function f;

	
	layer(int input_dims, int output_dims, activation_function f) {
		this.f = f;
	}

	layer(int input_dims, int output_dims) {
		this.f = new sigmoid();
	}
	
	
	public abstract void fp();
	
	public abstract void bp(matrix test, double learning_rate);
	
	abstract void updateWeights(double learning_rate);
	
	abstract matrix dz_next();
	
	abstract matrix w_next();
	
	abstract matrix dw();
	
	abstract void set_x(matrix m);
	
	abstract void feedInput(matrix m);
	
	abstract matrix getWeights();
	
	abstract matrix getDz();
	
	abstract layer next();
	
	abstract layer prev();
	
	abstract void set_next(layer l);
	
	abstract void set_prev(layer l);
	
	abstract matrix get_output();
	
}

