package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProgramService.Sorting;

public class RadixSort extends Sorting{

	private int findMax(int[] data){
		int max = 0;
		for(int i=0; i<data.length; i++){
			if(data[i] > max){
				max = data[i];
			}
		}
		return max;
	}
	
	private int countDigits(int max){
		int c = 0;
		while(max>0){
			max=max/10;
			c++;
		}
		
		return c;
	}
	
	@Override
	public void sort(int[] data) {
	
		int max = findMax(data);
		int d = countDigits(max);
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<10;i++){
			list.add(new ArrayList<Integer>());
		}
		
		int degree=1;
		int currentDigit;
		List<Integer> out;
	
		for(int i=0; i<d; i++){
			out = new ArrayList<Integer>();

			for(int j=0; j<data.length; j++){
				currentDigit = ((data[j] % (10*degree))/degree);
				list.get(currentDigit).add(data[j]);
				swaps++;
			}
			
			for(int j=0; j<list.size(); j++){
				for(int entry : list.get(j)){
					out.add(entry);
				}
				list.get(j).clear();
			}
		
			degree*=10;
			
			for(int j=0; j<data.length; j++){
				data[j] = out.get(j);
			}
			
			System.out.println(Arrays.toString(data));
		}
	}

}
