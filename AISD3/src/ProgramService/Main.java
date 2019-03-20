package ProgramService;

import java.util.Arrays;
import java.util.Scanner;

import Sorting.RadixSort;

public class Main {
	
	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		System.out.println("Type in data size you want: ");
		int dataSize= reader.nextInt();
		
		System.out.println("Choose 's' for decreasing sorted data or 'r' for random data: ");
		String sortingType= reader.next();
		
		System.out.println("Type in number to choose algorithm:\n"+
		"1- Radix Sort\n"+
		"2- Randomized Select\n"+
		"2- Select\n");
		int algorithmType= reader.nextInt();
		reader.close();
		
		int[] data= new int[dataSize];
		if(sortingType.equals("r")){
			data = Input.getRandomData(dataSize);
		}else if(sortingType.equals("s")){
			data = Input.getDecreasingData(dataSize);
		}else{
			data = null;
		}
		
		Sorting sort; 
		switch(algorithmType){
		case 1: sort = new RadixSort(); break;
		default: sort = null;
		}
		
		System.out.println("Before: " + Arrays.toString(data) +"\nSteps:");
		if(sort!=null)
			sort.sort(data);
		System.out.println("\nAfter:  " + Arrays.toString(data));
		System.out.println("Swaps: " + sort.swaps + "\nComparisons: " + sort.comparisons);
			
	}
}
