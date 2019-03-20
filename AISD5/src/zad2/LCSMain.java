package zad2;


import java.util.Scanner;

public class LCSMain {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String data1 = reader.nextLine();
		String data2 = reader.nextLine();
		
		String result = LCSAlgorithm.findLCS(data1, data2);
		System.out.println(result);
		reader.close();
	}

}
