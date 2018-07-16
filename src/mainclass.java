import java.io.IOException;
import java.util.*;
public class mainclass {

	public static void main(String[] args) throws IOException {
		
		parser p = new parser();
		String mnist_path = "/Users/jackfischer/Downloads/mnist_test.csv";
		ArrayList<Double> mnist_input = p.parse(mnist_path,1,785);
		ArrayList<Double> mnist_test = p.parse(mnist_path,0);
		network NN = new network();
		NN.add(new feedforward(784,512, new sigmoid()));
		NN.add(new output_layer_ff(512,10, new sigmoid()));
		mnist_test = p.one_hot_mnist(mnist_test);
		matrix input = new matrix(10, 784, mnist_input);
		input = tensor.scalar_mult(.004, input);
		matrix test = new matrix(10, 10, mnist_test);
		//matrix hi = new matrix(28,28,input.mat);
//		matrix input = new matrix();
		//mnist_tester mt = new mnist_tester();
		//mt.print_num(hi);
		
//		matrix test = new matrix(1,4);
//		
//		test.mat = new double[] {0,1,1,0};
//
//		
//		matrix input = new matrix(2,4);
//		
//		input.mat = new double[] {1, 0, 1, 0, 1, 1, 0, 0};
		
		
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


		NN.runn(10000, tensor.transpose(input), tensor.transpose(test), new gradient_descent(.003));
	
		
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
