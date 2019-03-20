package Sorting;

import ProgramService.Sorting;

public class MergeSort extends Sorting{
	
	@Override
	public void sort(int[] data, boolean b) {
		comparisons= 0;
		swaps= 0;
		mergeSort(data, 0, data.length-1);
		
	}
	
	private void mergeSort(int[] A, int low, int high){
		if(low<high){
			int middle = low + (high - low)/2;
			
			mergeSort(A, low, middle);
			mergeSort(A, middle+1, high);
			merge(A, low, middle, high);
			
		}
	}

    private void merge(int[] A, int low, int middle, int high) {
    	int[] helper= new int[A.length];

    	for (int i = low; i <= high; i++) {
                helper[i] = A[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
      
        while (i <= middle && j <= high) {

                if (helper[i] <= helper[j]) {
                        A[k] = helper[i];
                        i++;
                } else {
                        A[k] = helper[j];
                        j++;
                }
                k++;
        }
        
        while (i <= middle) {
                A[k] = helper[i];
                k++;
                i++;
        }

    }
}

