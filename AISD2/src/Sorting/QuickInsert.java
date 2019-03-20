package Sorting;

import ProgramService.Sorting;

public class QuickInsert extends Sorting{

	@Override
	public void sort(int[] data) {
		swaps = 0;
		comparisons = 0;
		quickSort(data, 0, data.length - 1);
	}
	
	int q;
	
	private void quickSort(int[] A, int l, int r){
		if(l < r){
			if(r - l <= 17){
				is(A, l, r);
			}else{
				q = partition(A, l, r);
				quickSort(A, l, q - 1);
				quickSort(A, q + 1, r);
			}
		}
	}
	
	private int partition(int[] A, int l, int r){
		int piv = A[r];
		int i = l;
		
		for(int j = l; j < r ; j++){
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

	public void is(int[] data, int l, int r) {
		int j;
		int curr;
		for(int i = l; i <= r; i++){
			curr = data[i];
			j = i;
			
			while(j > 0 && data[j - 1] > curr){
				data[j] = data[j - 1];
				j--;
				comparisons++;
				swaps++;
			}
			data[j] = curr;
			swaps++;
		}
	}

	
}
