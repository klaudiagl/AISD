import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.Random;


public class Main {

	public static void main(String[] args) throws IOException {
		//biggestElementInIncreasingData();
		//randomElementInRandomTree();
		randomElementInOneTree();
		System.out.println("Done!");
		
		

	}
	
	
	public static void randomElementInOneTree() throws IOException{
		BST tree;
		
		PrintWriter out = new PrintWriter(new File("src/Output.txt"));
		double totalcounter=0;
		int tests= 100;
		
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		for(int i=100; i<=10000; i+=100){	
			Input.getRandomTree(i);
			
			for(int j=0; j<tests; j++){	
				totalcounter=0;

				copyText(i);
				appendText(Input.data, i);
				tree= new BST();
				try {
					BufferedReader br = new BufferedReader(new FileReader(new File("src/InputWorking.txt")));
					String cmd;
					String[] cmdArgs;
					int count = Integer.parseInt(br.readLine());
					for(int k=0; k<count; k++){
						cmd = br.readLine();
						cmdArgs = cmd.split(" ");
						switch(cmdArgs[0]){
						case "insert": tree.addNode(Integer.parseInt(cmdArgs[1])); break;
						case "find": tree.find(Integer.parseInt(cmdArgs[1])); break;
						default: break;
						}
		
					}
					br.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
				totalcounter= totalcounter + tree.counter;

			}
			totalcounter= totalcounter/tests;
			String format = decimalFormat.format(totalcounter);
			
			out.println(Integer.toString(i)+" "+ format);

		}
		out.close();
		System.out.print("Done!");
	}

	public static void appendText(int[] t, int n){
		Random rand = new Random();
		int x= rand.nextInt(n-1);
		String number= Integer.toString(t[x]);
		String text= "find "+ number;
		try {
		    Files.write(Paths.get("src/InputWorking.txt"), text.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		}
	}

	public static void copyText(int n){
		try {
			PrintWriter out3 = new PrintWriter(new File("src/InputWorking.txt"));
			out3.print("");
			out3.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		

		String[] cmdArgs = new String[n+1];
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/Input.txt")));
			String cmd;
			for(int k=0; k<n+1; k++){
				cmd = br.readLine();
				cmdArgs[k]=cmd;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		try {
			PrintWriter outp = new PrintWriter(new File("src/InputWorking.txt"));
			for(int i = 0; i<n+1;i++){
				outp.println(cmdArgs[i]);
			}
			outp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void biggestElementInIncreasingData() throws IOException{
		BST tree;
		
		PrintWriter out = new PrintWriter(new File("src/Output.txt"));
		int totalcounter;
		int tests= 1;
		
		for(int i=100; i<=10000; i+=100){	
			totalcounter=0;
			
			for(int j=0; j<tests; j++){
				Input.getInreasingData(i);
				tree= new BST();
				try {
					BufferedReader br = new BufferedReader(new FileReader(new File("src/Input.txt")));
					String cmd;
					String[] cmdArgs;
					int count = Integer.parseInt(br.readLine());
					for(int k=0; k<count; k++){
						cmd = br.readLine();
						cmdArgs = cmd.split(" ");
						switch(cmdArgs[0]){
						case "insert": tree.addNode(Integer.parseInt(cmdArgs[1])); break;
						case "find": tree.find(Integer.parseInt(cmdArgs[1])); break;
						default: break;
						}
		
					}
					br.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
				System.out.println(tree.counter);
				
				totalcounter= totalcounter + tree.counter;
			}

			out.println(Integer.toString(i)+" "+ totalcounter);

		}
		out.close();
		System.out.print("Done!");
	}

	

	
	
	
	
	public static void randomElementInRandomTree() throws IOException{
		BST tree;
		
		PrintWriter out = new PrintWriter(new File("src/Output.txt"));
		double totalcounter;
		int tests= 100;
		
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		for(int i=100; i<=10000; i+=100){	
			totalcounter=10000;
			
			for(int j=0; j<tests; j++){
				Input.getRandomData(i);
				tree= new BST();
				try {
					BufferedReader br = new BufferedReader(new FileReader(new File("src/Input.txt")));
					String cmd;
					String[] cmdArgs;
					int count = Integer.parseInt(br.readLine());
					for(int k=0; k<count; k++){
						cmd = br.readLine();
						cmdArgs = cmd.split(" ");
						switch(cmdArgs[0]){
						case "insert": tree.addNode(Integer.parseInt(cmdArgs[1])); break;
						case "find": tree.find(Integer.parseInt(cmdArgs[1])); break;
						default: break;
						}
		
					}
					br.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
				if(tree.counter<totalcounter){
					totalcounter=tree.counter;
				}
			}
			String format = decimalFormat.format(totalcounter);
			
			out.println(Integer.toString(i)+" "+ format);

		}
		out.close();
		System.out.print("Done!");
	}
}
