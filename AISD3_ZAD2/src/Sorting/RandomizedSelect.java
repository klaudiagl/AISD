package Sorting;

import java.util.Arrays;

import ProgramService.Sorting;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSelect extends Sorting{
	
	int q;
	
	public void sort(int[] data, int p, boolean b) {
		swaps = 0;
		comparisons = 0;
		select(data, 0, data.length - 1, p, b);
	}

	private void select(int[] A, int l, int r, int i, boolean c){
		if(c){
			System.out.println(Arrays.toString(A));
		}
		int x = ThreadLocalRandom.current().nextInt(l, r + 1);
		int temp;
		temp = A[r];
		A[r] = A[x];
		A[x] = temp;
		swaps++;
		if(c){
			System.out.println(Arrays.toString(A));
		}
		q = partition(A, l, r, r);
		
		if(i<q){
				select(A, l, q - 1, i,c);
		}else if(i>q){
			select(A, q + 1, r, i,c);
			
		}else if(i==q){
			return;
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


