package zad1test;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Input {
	public static int[] data;
	public static void getRandomTree(int n) throws IOException{
		Random rand = new Random();
		 data= new int[n];
		PrintWriter out = new PrintWriter(new File("src/Input.txt"));
			out.println(Integer.toString(n+1));

			for(int i=0; i<n; i++){
				int j = rand.nextInt(1000+1);
				data[i]=j;
				out.println("insert "+Integer.toString(j));
			}
		out.close();
		
	}

	public static int[] getRandomData(int n){
		Random rand = new Random();
		int[] data = new int[n];
			for(int i=0; i<n; i++){
				int j = rand.nextInt(1000+1);
				data[i]=j;
			}
			return data;
	}
	
	public static int[] getInreasingData(int n){	
		int[] data= new int[n];;	
		for(int i=0; i<n; i++){
			data[i]=i;
		}
		return data;
	}
	

}
