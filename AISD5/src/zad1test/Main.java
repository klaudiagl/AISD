package zad1test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;

import bst.BST;
import zad1.OSBST;

public class Main {
	
	public static void main(String[] args) throws IOException {
		randomElementInRandomSelect();
		//randomKeyInRandomOSBST();
		//randomElementInRandomOSBST();
		System.out.println("Done!");
	}
	
	
	public static void randomElementInRandomSelect() throws IOException{
		Sorting sort;
		PrintWriter out = new PrintWriter(new File("src/zad1test/Output.txt"));
		
		double totalcounter = 0;
		int tests= 100;
		
		String pattern = "######.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		for(int i=100; i<=10000; i+=100){	
			totalcounter=0;
			for(int j=0; j<tests; j++){
				sort = new RandomizedSelect();
				int[] data= Input.getInreasingData(i);
				Random rand = new Random();
				int x = rand.nextInt(i-1);
				sort.sort(data, x, false);
				
				if((sort.comparisons+sort.swaps)>totalcounter)
				totalcounter= sort.comparisons+sort.swaps;
				
			}
			
			String format = decimalFormat.format(totalcounter);
			
			out.println(format);

		}
		out.close();
		System.out.print("Done!");
	}


	
	public static void randomElementInRandomOSBST() throws IOException{
		OSBST tree;
		PrintWriter out = new PrintWriter(new File("src/zad1test/Output.txt"));
		
		double totalcounter = 0;
		int tests= 10;
		
		String pattern = "######.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		for(int i=100; i<=10000; i+=100){	
			totalcounter=0;
			for(int j=0; j<tests; j++){
				int[] data= Input.getInreasingData(i);
				Random rand = new Random();
				int x = rand.nextInt(i-1);
	
				tree= new OSBST();
				
				for(int k=0; k<i; k++){
					 tree.addNode(data[k]); 
				}
				
				tree.os_select(x+1);
				totalcounter= totalcounter+tree.counter;
				
			}
			totalcounter= totalcounter/tests;
			String format = decimalFormat.format(totalcounter);
			
			out.println(Integer.toString(i)+" "+ format);

		}
		out.close();
		System.out.print("Done!");
	}


	public static void randomKeyInRandomOSBST() throws IOException{
		OSBST tree;
		PrintWriter out = new PrintWriter(new File("src/zad1test/Output.txt"));
		
		double totalcounter = 0;
		int tests= 10;
		
		String pattern = "######.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		for(int i=100; i<=10000; i+=100){	
			totalcounter=0;
			for(int j=0; j<tests; j++){
				int[] data= Input.getInreasingData(i);
				Random rand = new Random();
				int x = rand.nextInt(i-1);
	
				tree= new OSBST();
				
				for(int k=0; k<i; k++){
					 tree.addNode(data[k]); 
				}
				
				tree.os_rank(data[x]);
				totalcounter= totalcounter+tree.counter;
				
			}
			totalcounter= totalcounter/tests;
			String format = decimalFormat.format(totalcounter);
			
			out.println(Integer.toString(i)+" "+ format);

		}
		out.close();
		System.out.print("Done!");
	}



}
