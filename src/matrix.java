import java.util.*;
public class matrix extends tensor {

	matrix(int rows, int columns){
		super(rows, columns);
		mat = new double[rows*columns];
	}
	
	matrix(int rows, int columns, ArrayList<Double> input){
		super(rows, columns);
		int w = 0;
		mat = new double[rows*columns];
		for(Double d : input) {
			mat[w] = d;
			w++;
			if(w >= rows*columns){
				break;
			}
		}
		}

	matrix(int rows, int columns, double[] input){
		super(rows, columns);
		int w = 0;
		mat = new double[rows*columns];
		for(Double d : input) {
			mat[w] = d;
			w++;
			if(w >= rows*columns){
				break;
			}
		}
		}
	
	
	matrix return_submatrix(int start, int end, int rows, int columns) {
		double[] ary = new double[end-start];
		int w = 0;
		for(int i = start; i < end; ++i) {
			ary[w] = mat[i];
			w++;
		}
		return new matrix(rows, columns, ary);
	}
	
	static matrix one(int rows, int columns) {
		matrix one = new matrix(rows, columns);
		for(int i = 0; i < rows*columns; ++i) {
			one.mat[i] = 1;
			
		}
		return one;
	}
	
	static matrix scalar_sub(double S, matrix m) {
		matrix newmat = new matrix(m.rows, m.columns);
		for(int i = 0; i < m.rows*m.columns; ++i) {
			newmat.mat[i] = m.mat[i] - S;
		}
		return newmat;
		
		
	}
	
	static matrix scalar_matrix(double S, int rows, int columns) {
		matrix newmat = new matrix(rows, columns);
		for(int i =0 ; i < rows*columns; ++i) {
			newmat.mat[i] = S;
			
		}
		return newmat;
		
		
	}
	
	
}

