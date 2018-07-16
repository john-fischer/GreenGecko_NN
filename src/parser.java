

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class parser {
	Double[] zero = new Double[] {1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	Double[] one = new Double[] {0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	Double[] two = new Double[] {0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	Double[] three = new Double[] {0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0};
	Double[] four = new Double[] {0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0};
	Double[] five = new Double[] {0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0};
	Double[] six = new Double[] {0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0};
	Double[] seven = new Double[] {0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0};
	Double[] eight = new Double[] {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0};
	Double[] nine = new Double[] {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0};

	ArrayList<Double> parse(String path, int column_number) throws IOException{
		File file = new File(path);
		Scanner sc = new Scanner(new FileInputStream(file));
		ArrayList<Double> Column_Collector = new ArrayList<Double>();
		int column_pointer = 0;
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] row = line.split(",");
			for(String s : row) {
				if(column_pointer == column_number) {
					Column_Collector.add(Double.parseDouble(s));
					column_pointer = 0;
					break;
				}
				else {
					column_pointer++;
				}
			}
			
	}
		sc.close();
		return Column_Collector;
	}
	
	ArrayList<Double> parse(String path, int c_start, int c_end) throws IOException{
		File file = new File(path);
		Scanner sc = new Scanner(new FileInputStream(file));
		ArrayList<Double> Column_Collector = new ArrayList<Double>();
		int column_pointer = 0;
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] row = line.split(",");
			for(String s : row) {
				if(column_pointer< c_start) {
					column_pointer++;
				}
				else if(column_pointer > c_end) {
					break;
					
				}
				else {
					Column_Collector.add(Double.parseDouble(s));
					
				}
			}
			
	}
		sc.close();
		return Column_Collector;
	}
	
	ArrayList<Double> parse(String path) throws IOException{
		File file = new File(path);
		Scanner sc = new Scanner(new FileInputStream(file));
		ArrayList<Double> CSV_COLLECTOR = new ArrayList<Double>();
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] row = line.split(",");
			for(String s : row) {
				Double m = Double.parseDouble(s);				
					CSV_COLLECTOR.add(m);

			}
			
	}
		sc.close();
		return CSV_COLLECTOR;
	}
	
	ArrayList<Double> one_hot_mnist(String path) throws IOException{
		File file = new File(path);
		Scanner sc = new Scanner(new FileInputStream(file));
		ArrayList<Double> one_hot_collection = new ArrayList<Double>();
		parser p = new parser();
		ArrayList<Double> pre_hot = p.parse(path, 0);
		for(Double ints : pre_hot) {
			if(ints == 0.0) {
				one_hot_collection.addAll(Arrays.asList(zero));
		}
			else if(ints == 1.0) {
				one_hot_collection.addAll(Arrays.asList(one));
			}
			else if(ints == 2.0) {
				one_hot_collection.addAll(Arrays.asList(two));
			}
			else if(ints == 3.0) {
				one_hot_collection.addAll(Arrays.asList(three));
		}
			else if(ints == 4.0) {
				one_hot_collection.addAll(Arrays.asList(four));
				}
			else if(ints == 5.0) {
				one_hot_collection.addAll(Arrays.asList(five));
		}
			else if(ints == 6.0) {
				one_hot_collection.addAll(Arrays.asList(six));
			}
			else if(ints == 7.0) {
				one_hot_collection.addAll(Arrays.asList(seven));
			}
			else if(ints == 8.0) {
				one_hot_collection.addAll(Arrays.asList(eight));
			}
			else if(ints == 9.0) {
				one_hot_collection.addAll(Arrays.asList(nine));
			}
			}
		sc.close();
		return one_hot_collection;
	}
		
	ArrayList<Double> one_hot_mnist(ArrayList<Double> old_ary) throws IOException{
		
		ArrayList<Double> one_hot_collection = new ArrayList<Double>();
		
		for(Double ints : old_ary) {
			if(ints == 0.0) {
				one_hot_collection.addAll(Arrays.asList(zero));
		}
			else if(ints == 1.0) {
				one_hot_collection.addAll(Arrays.asList(one));
			}
			else if(ints == 2.0) {
				one_hot_collection.addAll(Arrays.asList(two));
			}
			else if(ints == 3.0) {
				one_hot_collection.addAll(Arrays.asList(three));
		}
			else if(ints == 4.0) {
				one_hot_collection.addAll(Arrays.asList(four));
				}
			else if(ints == 5.0) {
				one_hot_collection.addAll(Arrays.asList(five));
		}
			else if(ints == 6.0) {
				one_hot_collection.addAll(Arrays.asList(six));
			}
			else if(ints == 7.0) {
				one_hot_collection.addAll(Arrays.asList(seven));
			}
			else if(ints == 8.0) {
				one_hot_collection.addAll(Arrays.asList(eight));
			}
			else if(ints == 9.0) {
				one_hot_collection.addAll(Arrays.asList(nine));
			}
			}
		return one_hot_collection;
	}
		
		
		
	
}
