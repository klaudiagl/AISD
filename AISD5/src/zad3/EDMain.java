package zad3;

import java.util.Scanner;
public class EDMain {
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String data1 = reader.nextLine();
		String data2 = reader.nextLine();

		int result = EDAlgorithm.computeLevenshteinDistance((CharSequence) data1, (CharSequence) data2);
		System.out.println(result);
		reader.close();
	}



}
