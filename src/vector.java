
public class vector extends matrix {
	int rows;
	double[][] mat;
	vector(int rows) {
		super(rows, 1);
	}

	vector g_() {
		vector m = new vector(rows);
		for(int i = 0; i < rows; ++i) {
				m.mat[i][0] = g(mat[i][0]);
			}
		return m;
	
	}
}
