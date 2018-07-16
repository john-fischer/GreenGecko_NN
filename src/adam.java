
public class adam extends optimizer {
	
	adam(double learning_rate){
		super(learning_rate);
	}
	
	@Override
	void bp(layer l) {
		
		l.bp_adam(learning_rate, 1); // learning_rate
	}

	void bp(layer l, matrix test, int epoch_number) {
		l.dz(test);
		l.bp_adam(learning_rate, epoch_number); // learning_rate
	}
}
