package Sorting;

import ProgramService.Sorting;

public class MergeInsert extends Sorting{
	
	@Override
	public void sort(int[] data) {
		comparisons= 0;
		swaps= 0;
		mergeSort(data, 0, data.length-1);
		
	}
	
	private void mergeSort(int[] A, int low, int high){
		if(low<high){
			if(high - low <=17){
				int middle = low + (high - low)/2;
				isort(A,low,middle-1);
			}else{
				
				int middle = low + (high - low)/2;
				
				mergeSort(A, low, middle);
				mergeSort(A, middle+1, high);
				merge(A, low, middle, high);
			}	
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
        	comparisons++;
                if (helper[i] <= helper[j]) {
                        A[k] = helper[i];
                        i++;
                } else {
                        A[k] = helper[j];
                        j++;
                        swaps++;
                }
                k++;
        }
        
        while (i <= middle) {
                A[k] = helper[i];
                k++;
                i++;
        }
    }
    
    public void isort(int[] A, int low, int high) {
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

