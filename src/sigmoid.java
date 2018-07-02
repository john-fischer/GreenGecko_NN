
public class sigmoid extends activation_function {

	public matrix f(matrix a) {
		matrix m = new matrix(a.rows,a.columns);
		for(int i = 0; i < a.rows*a.columns; ++i) {
				m.mat[i] = g(a.mat[i]);
			}
		return m;
	}
	
	public matrix f_prime(matrix a) {
		matrix one = new matrix(a.rows, a.columns);
		for(int i = 0; i < a.rows*a.columns; ++i) {
			one.mat[i] = 1.0;
			}
		return tensor.mult(f(a),tensor.sub(one,f(a)));
	}
	
	
	public double g(double z) {
		return (1/ (1+  Math.exp(-z)));
	}
	
	

	
	
}
