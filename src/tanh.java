
public class tanh extends activation_function{

	@Override
	public matrix f(matrix m) {
	matrix newmat = new matrix(m.rows, m.columns);
	for(int i = 0; i < m.rows*m.columns; i++) {
			newmat.mat[i] = th(m.mat[i]);
	}
	return newmat;
	}

	@Override
	public matrix f_prime(matrix a) {
		matrix one = new matrix(a.rows, a.columns);
		for(int i = 0; i < a.rows*a.columns; ++i) {
				one.mat[i] = 1.0;
		}
		return tensor.sub(one,f_squared(a));
	}

	public double th(double m) {
		return (Math.exp(m) - Math.exp(-m))/(Math.exp(m) + Math.exp(-m));
		
	}
	
	public matrix f_squared(matrix m) {
		matrix newmat = new matrix(m.rows, m.columns);
		for(int i = 0; i < m.rows; i++) {
				newmat.mat[i] = th(m.mat[i]) * th(m.mat[i]);
			
		}
		return newmat;
	}
}

