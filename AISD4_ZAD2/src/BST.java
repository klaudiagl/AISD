

public class BST {
	public Node root;
	public int counter=0;
	
	public void addNode(int x){
		Node newNode = new Node(x);	
		Node temp = root;			
		Node parrent = null;		
		
		//find the right place to add node
		while(temp != null){
			parrent = temp;
			if(newNode.key < temp.key){
				temp = temp.left;
				counter++;
			}
			else{
				temp = temp.right;
				counter++;
			}
			newNode.parrent = parrent;
			parrent.size++;
		}
		
		//case 1: tree is empty
		if(parrent == null){
			root = newNode;
		}
		//case 2: left child
		else if(newNode.key < parrent.key){
			parrent.left = newNode;
		}
		//case 3: right child
		else{
			parrent.right = newNode;
		}
	}
	
	
	public void printInorder(Node x){
		if(root == null){
			System.out.println("");
			return;
		}

		if(x != null){
			printInorder(x.left);
			System.out.print(x.key+" ");
			printInorder(x.right);
		}
	}
	
	public void printInorder(){
		printInorder(root);
		System.out.println();
	}
	
	
	public Node getNode(int k){
		Node x = root;
		
		while(x != null){
			if(k == x.key){
				counter++;
				return x;
			}
			else if(k < x.key){
				counter= counter+1;
				x = x.left;
			}
			else {
				x = x.right;
				counter= counter+1;
			}
		}
		
		return null;
	}
	
	
	public void find(int k){
		Node node = getNode(k);
		
		if(node == null)
			System.out.println(0);
		else
			System.out.println(1);
	}
	
	
	public void maximum(){
		if(root == null){
			System.out.println("");
			return;
		}
		Node x = root;
		while(x.right != null){
			x = x.right;
		}
		System.out.println(x.key);
	}
	
	
	public Node minimum(Node n){
		Node x = n;
		while(x.left != null){
			x = x.left;
		}
		return x;
	}
	
	
	public void minimum(){
				if(root == null){
			System.out.println("");
			return;
		}
		System.out.println(minimum(root).key);
	}
	
	
	public void delete(int k){
		Node node = getNode(k);
		if(node == null){
			return;
		}
		Node successor;
		Node temp;
		
		if(node.left == null || node.right == null)
			successor = node;
		else
			successor = successor(node.key);
		
		if(successor.left != null)
			temp = successor.left;
		else
			temp = successor.right;
		
		if(temp != null)
			temp.parrent = successor.parrent;
		
		if(successor.parrent == null)
			root = temp;
		else if(successor == successor.parrent.left)
			successor.parrent.left = temp;
		else
			successor.parrent.right = temp;
		
		if(successor != node){
			node.key = successor.key;
		}
		
		Node path = node;	
		while(path != null){
			path.size--;
			path = path.parrent;
		}
	}
	
	
	private Node successor(int x){
		Node node = getNode(x);
		Node focus;
		if(node.right != null){
			return minimum(node.right);
		}
		focus = node.parrent;
		while(focus != null && node == focus.right){
			node = focus;
			focus = focus.parrent;
		}
		
		return focus;
	}
}



