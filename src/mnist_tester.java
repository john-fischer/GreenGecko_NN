
public class mnist_tester {

	void print_num(matrix m) {
		for(int i = 0; i < 28; i++) {
			System.out.print("||");
			for(int j = 0; j < 28; j++) {
				String formatted = Double.toString(m.mat[i*28+j]);
				while(formatted.length() < 5) {
					formatted = formatted + "0";
				}
				System.out.print(formatted + " ");
			}
			System.out.print("||");
			System.out.print("\n");
		}
	}
	
	void stark_print(matrix m) {
		for(int i = 0; i < 28; i++) {
		
			for(int j = 0; j < 28; j++) {
				if(m.mat[i*28 + j] > 8) {
				System.out.print(m.mat[i*28+j] + " ");}
				else {
					System.out.print("  ");}

				}
			System.out.print("\n");

			}
		}
	}
	

