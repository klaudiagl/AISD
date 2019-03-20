package zad1;
import bst.BST;
import bst.Node;

public class OSBST extends BST{
	
	
	public int os_select(int k, int i){
		Node x = getNode(k);
		int r;
		if(x == null || x.right == null){
			//x=x.parrent;
			r = 1;
		}
		else
			r = x.left.size + 1;
		
		if(i == r)
			return x.key;
		else if(i < r){
			counter++;		
			return os_select(x.left.key, i);
		}
		else 
			counter++;
			return os_select(x.right.key, i - r);
	}
	
	
	public int os_select(int i){
		int result = -1;
		try{
			result = os_select(root.key, i);
		}
		catch(NullPointerException e){
			System.out.println("Nieprawidlowy index");
		}
		return result;
	}
	
	
	public int os_rank(int xv){
		Node x = getNode(xv);
		if(x == null){
			System.out.println("Nie znaleziono takiej wartosci");
			return -1;
		}
		int r;
		
		if(x.left == null)
			r = 1;
		else
			r = x.left.size + 1;
		
		
		Node y = x;
		
		while(y != root){
			if(y == y.parrent.right){
				if(y.parrent.left == null)
					r += 1;
				else
					r += y.parrent.left.size + 1;
			}
			y = y.parrent;
			counter++;
		}
		return r;
	}
}
