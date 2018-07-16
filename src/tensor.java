import java.util.*;
public class tensor {
	double[] mat;
	int rows;
	int columns;

	tensor(int rows, int columns) {
		this.columns = columns;
		this.rows = rows;
	}
	tensor(){};

	int getrows() {
		return rows;
	}
	
	int getcolumns() {
		return columns;
	}
	public static matrix transpose(matrix m) {
		int r = m.getcolumns();
		int c = m.getrows();

		matrix t_mat = new matrix(r,c);
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				t_mat.mat[i*c + j] = m.mat[i + j*r];
			}
	}
		return t_mat;
	}
	
	public static void print_m(matrix m) {
		for (int i = 0; i < m.getrows(); ++i) {
			System.out.print("[ ");
			for (int j = 0; j < m.getcolumns(); ++j) {
			System.out.print(m.mat[i*m.getcolumns() + j] + " " );
		
		}System.out.println("]");}
		
		System.out.println();
		System.out.println();
	}
	
	public static void p(matrix m) {
		for (int i = 0; i < m.getcolumns() * m.getrows(); ++i) {
			System.out.print(m.mat[i] + " ");
		}
	}
	
// checking for exceptions
	 private static void checkdims(tensor m1, tensor m2) throws ArithmeticException{
		 if (m1.rows != m2.rows || m1.columns != m2.columns) {
				throw new ArithmeticException();
			}
	 }
// matrix
	public static matrix add(tensor m1, tensor m2) throws ArithmeticException {
		checkdims(m1,m2);
		int a = m1.rows;
		int b = m1.columns;
		matrix newmat = new matrix(a, b);
		for (int i = 0; i < a*b; ++i) {
				newmat.mat[i] = m1.mat[i] + m2.mat[i];
			}
		return newmat;
	}

	public static matrix mult(tensor m1, tensor m2) throws ArithmeticException {
		checkdims(m1,m2);
		int a = m1.rows;
		int b = m1.columns;
		matrix newmat = new matrix(a, b);
		for (int i = 0; i < a*b; ++i) {
				newmat.mat[i] = m1.mat[i] * m2.mat[i];
			}
		return newmat;
	}
	
	public static matrix sub(tensor m1, tensor m2) throws ArithmeticException {
		checkdims(m1,m2);
		int a = m1.rows;
		int b = m1.columns;
		matrix newmat = new matrix(a, b);
		for (int i = 0; i < a*b; ++i) {
				newmat.mat[i] = m1.mat[i] - m2.mat[i];
			}
		return newmat;
	}
	
	matrix divides(matrix m1) throws ArithmeticException {
		int a = m1.rows;
		int b = m1.columns;
		matrix newmat = new matrix(a, b);
		for (int i = 0; i < a*b; ++i) {
				newmat.mat[i] = m1.mat[i] / mat[i];
			}
		return newmat;
	}
	
	
	
	public static matrix divides(matrix m1, matrix m2) throws ArithmeticException {
		int a = m1.rows;
		int b = m1.columns;
		matrix newmat = new matrix(a, b);
		for (int i = 0; i < a*b; ++i) {
				newmat.mat[i] = m1.mat[i] / m2.mat[i];
			}
		return newmat;
	}
	
	public static matrix sqrt(matrix m1) {
		matrix newmat = new matrix(m1.rows, m1.columns);
		for(int i = 0 ; i < m1.rows*m1.columns; ++i) {
			newmat.mat[i] = Math.sqrt(m1.mat[i]);
		}
		return newmat;
	}

	public static matrix scalar_mult(double S, matrix m) {
		int a = m.getrows();
		int b = m.getcolumns();
		matrix newmat = new matrix(a, b);
		for (int i = 0; i < a*b; ++i) {
				newmat.mat[i] = m.mat[i] * S;
			}
		return newmat;
	}
	
	
	static matrix dot(matrix m1, matrix m2) throws ArithmeticException{
		int r = m1.getrows();
		int c = m2.getcolumns();
		int same = m1.getcolumns();
		matrix newmat = new matrix(r, c);
		for(int n_rows = 0; n_rows < r; n_rows++) {
			for(int n_cols = 0; n_cols < c; n_cols++) {
				double total = 0;
				for(int i = 0; i < same; ++i) {
					double a = m1.mat[n_rows*m1.columns + i];
					double b =  m2.mat[i*m2.columns + n_cols];
					total += a*b;
				}	
				newmat.mat[n_rows*c + n_cols] = total;
				
			}
		}
		return newmat;
	}
// Activation Function
	public double g(double z) {
		return (1/ (1+  Math.exp(-z)));
	}
	double g_prime(double z) {
		return (Math.exp(-z)/ (1+  Math.exp(-z)));
	}
	
	
	public static void initialize(matrix m, int min, int max) {
		Random rand = new Random();
		for(int i = 0 ; i < m.getrows()*m.getcolumns(); ++i) {
				m.mat[i] = (rand.nextDouble()*(max-min))+(min);
			}
		}
	}
	

