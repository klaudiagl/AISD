package Sorting;

import ProgramService.Sorting;

public class InsertionSort extends Sorting {

	@Override
	public void sort(int[] A) {
		comparisons= 0;
		swaps= 0;
		
		int n= A.length;
		int j;
		int key;
		
		for(int i=1; i<n; i++){
			key= A[i];
			j= i-1;
			
			while(j>=0 && A[j]>key){
				comparisons++;
				A[j+1]= A[j];
				swaps++;
				j=j-1;
			}
			A[j+1]= key;
			swaps++;
		}
	}
}
