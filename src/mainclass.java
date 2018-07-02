public class mainclass {

	public static void main(String[] args) {
		
	
		network NN = new network();
		NN.add(new feedforward(2,3, new sigmoid()));
		NN.add(new feedforward(3,3, new sigmoid()));
		NN.add(new output_layer_ff(3,1, new sigmoid()));
				
		matrix test = new matrix(1,4);
		
		test.mat = new double[] {0,1,1,0};

		
		matrix input = new matrix(2,4);
		
		input.mat = new double[] {1, 0, 1, 0, 1, 1, 0, 0};
		
		
//		matrix input = new matrix(5,3);
//		input.mat[0][0] = 1.0;
//		input.mat[1][0] = 1.0;
//		input.mat[2][0] = 1.0;
//		input.mat[3][0] = 0.0;
//		input.mat[4][0] = 0.0;
//		
//		input.mat[0][1] = 0.0;
//		input.mat[1][1] = 1.0;
//		input.mat[2][1] = 1.0;
//		input.mat[3][1] = 1.0;
//		input.mat[4][1] = 0.0;
//		
//		input.mat[0][2] = 0.0;
//		input.mat[1][2] = 0.0;
//		input.mat[2][2] = 1.0;
//		input.mat[3][2] = 1.0;
//		input.mat[4][2] = 1.0;
//		
//		matrix test = new matrix(3,3);
//		test.mat =  new double[][] {{1,0,0}, {0,1,0}, {0,0,1}};
//		
//		
//		NN.add(new feedforward(4,5));
//		// 4x3
//		
//		NN.add(new output_layer(3,4));

		System.out.println("blah");

 	NN.runn(100000, input, test, .01);
	
		
//		matrix m1 = new matrix(4,2);
//		matrix m2 = new matrix (2,3);
//		m1.mat = new double[] {1,2,3,-1,-2,1.5,2,3};
//		m2.mat = new double[] {2,3,4,2,3,4};
//		tensor.print_m(tensor.dot(m1, m2));
//		sigmoid s = new sigmoid();
//		tensor.print_m(s.f_prime(tensor.dot(m1, m2)));
//
//		tensor.print_m(tensor.transpose(tensor.dot(m1, m2)));
		

	
		
	}
}
