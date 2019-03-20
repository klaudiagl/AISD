package Sorting;

import ProgramService.Sorting;

public class QuickSort extends Sorting{

	@Override
	public void sort(int[] data) {
		swaps = 0;
		comparisons = 0;
		quickSort(data, 0, data.length - 1);
	}
	
	int q;
	
	private void quickSort(int[] A, int l, int r){
		if(l < r){
			q = partition(A, l, r, r);
			quickSort(A, l, q - 1);
			quickSort(A, q + 1, r);
		}
	}
	
	public int partition(int[] A, int l, int r, int p){
		int piv = A[p];
		int i = 0; //wall
		
		for(int j = 0; j < r ; j++){
			if(A[j] <= piv){
				int temp;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;

				if(i!=j){
					swaps++;
				}
				i++;
			}
			comparisons++;
		}
		
		int temp = A[i];
		A[i] = A[r];
		A[r] = temp;
			if(i!=r){
				swaps++;
			}
		return i;
	}
	
}

