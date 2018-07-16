
public abstract class optimizer {
	double learning_rate;
	int epoch_number;
	optimizer(double learning_rate){
		this.learning_rate = learning_rate;
	}
	
	abstract void bp(layer l);
	abstract void bp(layer l, matrix test,int epoch_number);


}
