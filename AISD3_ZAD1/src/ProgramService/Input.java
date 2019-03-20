package ProgramService;

import java.util.Random;
import Sorting.MergeSort;

public class Input {

	
	public static int[] getRandomData(int n){
		int[] A = new int[n];
		Random rand = new Random();
		
		for(int i=0; i<n; i++){
			A[i]= rand.nextInt(1000+1);
		}
		return A;
	}
	
	public static int[] getDecreasingData(int n){
		int[] temp= new int[n];
		int[] A= new int[n];
		temp= getRandomData(n);
		MergeSort sort = new MergeSort();
		sort.sort(temp, false);
		
		for(int i=0; i<temp.length; i++){
			A[i]= temp[temp.length-1-i]; 
		}
		return A;
	}
}
