package ProgramService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import Sorting.InsertionSort;
import Sorting.MergeInsert;
import Sorting.MergeSort;
import Sorting.QuickInsert;
import Sorting.QuickSort;

public class Main {

	public static void main(String[] args) {

		Scanner reader= new Scanner(System.in);
		System.out.println("Type in data size you want: ");
		int n= reader.nextInt();
		System.out.println("Choose 's' for decreasing sorted data or 'r' for random data: ");
		String sortingType= reader.next();
		System.out.println("Type in number to choose algorithm:\n"+
		"1- Insertion Sort\n"+
		"2- Merge Sort\n"+
		"3- Quicksort\n"+
		"4- Merge Sort + Insert Sort\n"+
		"5- Quickort + Insert Sort");
		
		int algorithmType= reader.nextInt();
		reader.close();
		
		int[] data= new int[n];
		if(sortingType.equals("r")){
			data = Input.getRandomData(n);
		}else if(sortingType.equals("s")){
			data = Input.getDecreasingData(n);
		}else{
			data = null;
		}
		
		Sorting sort; 
		switch(algorithmType){
		case 1: sort = new InsertionSort(); break;
		case 2: sort = new MergeSort(); break;
		case 3: sort = new QuickSort(); break;
		case 4: sort = new MergeInsert(); break;
		case 5: sort = new QuickInsert(); break;
		default: sort = null;
		}
		
		System.out.println("Before: " + Arrays.toString(data));
		if(sort!=null)
			sort.sort(data);
		System.out.println("After:  " + Arrays.toString(data));
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
			
			for(int j=0; j<3; j++){
				data2 = Input.getRandomData(i);
				sort.sort(data2);
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
