
public class gradient_descent extends optimizer{

	gradient_descent(double learning_rate){
		super(learning_rate);
	}
	
	void bp(layer l) {
		l.bp(learning_rate);
	}
	
	void bp(layer l, matrix test, int epoch_number) {
		l.bp(test, learning_rate);
	}
	

}
