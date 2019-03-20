package ProgramService;
import java.util.Random;

public class InputGenerator {
	static final int MAX_VALUE = 100;
	static final Random rand = new Random();
	
	public static int[] getRandomArray(int n){
		int[] tab = new int[n];
		for(int i=0; i<n; i++){
			tab[i] = rand.nextInt(MAX_VALUE + 1);
		}
		
		return tab;
 	}
	
	public static int[] getPermutation(int n){
		int[] perm = new int[n];
		for(int i=0; i<n;i++){
			perm[i] = 101;
		}
		
		for(int i=0; i<n; i++){
			int index = rand.nextInt(n);
			while(perm[index] != 101){
				index = rand.nextInt(n);
			}
			perm[index] = i;
		}
		
		return perm;
	}
}
