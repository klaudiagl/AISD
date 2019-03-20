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

	public static void getRandomData(int n) throws IOException{
		Random rand = new Random();
		int[] data = new int[n];
		PrintWriter out = new PrintWriter(new File("src/Input.txt"));
			out.println(Integer.toString(n+1));

			for(int i=0; i<n; i++){
				int j = rand.nextInt(1000+1);
				data[i]=j;
				out.println("insert "+Integer.toString(j));
			}
		int k= rand.nextInt(n-1);
		out.write("find " + data[k]);	
		out.close();
		
	}
	
	public static void getInreasingData(int n) throws IOException{

			PrintWriter out = new PrintWriter(new File("src/Input.txt"));
			out.println(Integer.toString(n+1));			
			for(int i=1; i<n+1; i++){
			    out.println("insert "+Integer.toString(i));
			}
		
		out.write("find " + n);		
		out.close();
	}
	
	public static int[] getRandom(int n){
		int[] A = new int[n];
		Random rand = new Random();
		
		for(int i=0; i<n; i++){
			A[i]= rand.nextInt(100+1);
		}
		return A;
	}
}
