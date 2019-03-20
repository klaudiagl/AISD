package zad1;


import java.util.Random;

public class OSBSTMain {

	public static void main(String[] args) {
		OSBST tree = new OSBST();
		Random rand = new Random();
		for(int i = 0; i < 25; i++){
			tree.addNode(rand.nextInt(100));
		}
		
		tree.printInorder();
		
		System.out.println(tree.os_select(3));
		System.out.println(tree.os_rank(10));
		System.out.println(tree.root.size);
		tree.delete(tree.os_select(24));
		System.out.println(tree.root.size);
	}

}
