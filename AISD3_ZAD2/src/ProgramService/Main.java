package ProgramService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Sorting.QuickSort;
import Sorting.RandomizedSelect;

public class Main {
	
	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		System.out.println("Type in data size you want: ");
		int dataSize= reader.nextInt();
		
		System.out.println("Choose 'r' for random data or 'p' for permutated data: ");
		String sortingType= reader.next();
		
		System.out.println("Choose i for ith smallest element: ");
		int seek= reader.nextInt();

		reader.close();
		
		int[] data= new int[dataSize];
		if(sortingType.equals("r")){
			data = InputGenerator.getRandomArray(dataSize);
		}else if(sortingType.equals("p")){
			data = InputGenerator.getPermutation(dataSize);
		}else{
			data = null;
		}
		
		Sorting sort = new RandomizedSelect();
		Sorting sortTest = new QuickSort();
		System.out.println("Before: " + Arrays.toString(data) +"\nSteps:");
		sort.sort(data, seek, true);
		System.out.println("\nAfter:  " + Arrays.toString(data));
		System.out.println("\nElement number "+seek+": " + data[seek]);
		System.out.println("Swaps: " + sort.swaps + "\nComparisons: " + sort.comparisons);
		sortTest.sort(data, seek, false);
		System.out.println("\nTest:  " + Arrays.toString(data));
		
		
		int[] data2;
		double totalComp = 0;
		double totalSwaps = 0;
		List<Double> swaps = new ArrayList<>();
		List<Double> comp = new ArrayList<>();
		for(int i=100; i<=10000; i+=100){
			data2 = new int[i];
			totalComp = 0;
			totalSwaps = 0;

			
			for(int j=0; j<200; j++){
				Random r = new Random();
				int x= r.nextInt(i);
				data2 = InputGenerator.getPermutation(i);
				sort.sort(data2, x, false);
				totalComp += sort.comparisons;
				totalSwaps += sort.swaps;
			}

			totalComp = totalComp/200;
			totalSwaps = totalSwaps/200;
			
			swaps.add(totalSwaps);
			comp.add(totalComp);
		}
		OutputGenerator.DisplayChart(comp, swaps);		
		
	}
}
