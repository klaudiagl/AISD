package ProgramService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import ProgramService.OutputGenerator;
import ProgramService.OutputPanel;
import Sorting.RadixSort;

public class Main {
	
	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		System.out.println("Type in data size you want: ");
		int dataSize= reader.nextInt();
		
		System.out.println("Choose 's' for decreasing sorted data or 'r' for random data: ");
		String sortingType= reader.next();

		reader.close();
		
		int[] data= new int[dataSize];
		if(sortingType.equals("r")){
			data = Input.getRandomData(dataSize);
		}else if(sortingType.equals("s")){
			data = Input.getDecreasingData(dataSize);
		}else{
			data = null;
		}
		
		Sorting sort = new RadixSort(); 
		
		System.out.println("Before: " + Arrays.toString(data) +"\nSteps:");
		sort.sort(data, true);
		System.out.println("\nAfter:  " + Arrays.toString(data));
		System.out.println("Swaps: " + sort.swaps + "\nComparisons: " + sort.comparisons);
		
		int[] data2;
		double totalComp = 0;
		double totalSwaps = 0;
		List<Double> swaps = new ArrayList<>();
		List<Double> comp = new ArrayList<>();
		for(int i=100; i<=10000; i+=100){
			data2 = new int[i];
			totalComp = 0;
			totalSwaps = 0;

			
			for(int j=0; j<10; j++){
				Random r = new Random();
				int x= r.nextInt(i);
				data2 = Input.getRandomData(i);
				sort.sort(data2, false);
				totalComp += sort.comparisons;
				totalSwaps += sort.swaps;
			}

			totalComp = totalComp/10;
			totalSwaps = totalSwaps/10;
			
			swaps.add(totalSwaps);
			comp.add(totalComp);
		}
		OutputGenerator.DisplayChart(comp, swaps);		
		
	}
}
