

public class network {
	layer head;
	layer tail;
	
	void add(layer l) {
		if(head == null) {
			head = l;
			tail = head;
		}
		else {
			tail.set_next(l);
			l.set_prev(tail);
			tail = l;
		}
	}
	
	void runn(matrix input, matrix test, optimizer o,int epoch_num) {
		head.set_x(input);
		layer curr =  head;
		while(curr != tail) {
			curr.fp();
			curr = curr.next();
		}
		curr.fp();
		while(curr != null) {
			o.bp(curr,test, epoch_num); 
			curr = curr.prev();
		}
	}
	
	
	void runn(int training_iters, matrix input, matrix test, optimizer o) {
		int epoch_num = 1;
		head.set_x(input);
		layer curr =  head;
		while(curr != tail) {
			curr.fp();
			curr = curr.next();
			
		}
		curr.fp();
		System.out.println("Prediction");
		tensor.print_m(curr.get_output());
		System.out.println("Actual");
		tensor.print_m(test);

		for(int i = 0; i < training_iters; ++i) {
			runn(input, test, o, epoch_num);
			System.out.println("Step :  " + epoch_num);
			epoch_num+=1;
		}
		
		head.set_x(input);
		 curr =  head;
		while(curr != tail) {
			curr.fp();
			curr = curr.next();
		}
		System.out.println("Prediction");
		tensor.print_m(curr.get_output());
		System.out.println("Actual");
		tensor.print_m(test);
	}
	
//	void runn_mult(int training_iters, matrix input, matrix test, double learning_rate) {
//		int m = input.columns;
//		for(int j = 0; j < training_iters; j++) {
//		for(int i = 0; i < m; i++) {
//		matrix in = input.get_column_vector(i);
//		matrix t = test.get_column_vector(i);
//		runn(in, t, learning_rate);
//		}
//		}
//		
//		for(int i = 0; i < m; i++) {
//		head.x = input.get_column_vector(i);
//		layer curr =  head;
//		while(curr != tail) {
//			curr.fp();
//			curr = curr.next;
//		}
//		System.out.println("HYPOTHESIS VALUE");
//		curr.y.print();
//		System.out.println("ACTUAL VALUE");
//		test.get_column_vector(i).print();
//		}
//	}
//	

}
	
	
	
	
