package Zadanie1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T>{

	private ArrayList<T> heap;
	private Comparator<T> comparator;
	
	public PriorityQueue(Comparator<T> comparator){
		this.comparator = comparator;
        this.heap = new ArrayList<>();
	}
	
	public PriorityQueue(Collection<T> items, Comparator<T> comparator){
		this.comparator= comparator;
		this.heap= new ArrayList<>(items);
		
		for(int i = (this.heap.size()-1)/2; i >= 0; i--){
			shiftDown(i);
		}
	}
		
    private int parentIndex(int index) { return (index-1)/2 ; }
    private int leftIndex(int index) { return 2*index+1; }
    private int rightIndex(int index) { return 2*(index+1); }
    
	public void shiftDown(int index){
		int left = leftIndex(index);
		int right = rightIndex(index);
		int x = index;
		
        if(left < heap.size() && comparator.compare(heap.get(left), heap.get(x)) < 0) {
            x = left;
        }
        if(right < heap.size() && comparator.compare(heap.get(right), heap.get(x)) < 0) {
            x = right;
        }

        if(x != index) {
            T tmp = heap.get(index);
            heap.set(index, heap.get(x));
            heap.set(x, tmp);
            shiftDown(x);
        }
	}
	
	public void insert(T elem){
		int elemIdx = heap.size();
		heap.add(elem);
		
        while(elemIdx > 0 && comparator.compare(heap.get(elemIdx), heap.get(parentIndex(elemIdx))) < 0) {
            T tmp = heap.get(parentIndex(elemIdx));
            heap.set(parentIndex(elemIdx), heap.get(elemIdx));
            heap.set(elemIdx, tmp);
            elemIdx = parentIndex(elemIdx);
        }
	}

	public T extractMin(){
        T top =  heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        shiftDown(0);
        heap.remove(heap.size()-1);
        return top;
	}

	public void decreaseKey(int index, T key){
    	heap.set(index, key);
        while(index > 0 && comparator.compare(heap.get(parentIndex(index)), heap.get(index)) > 0) {
            T tmp = heap.get(index);
            heap.set(index, heap.get(parentIndex(index)));
            heap.set(parentIndex(index), tmp);
            index=parentIndex(index);
        }
	}

	public void findIndexAndDecreaseKey(T key, T newKey){
		decreaseKey((heap.indexOf(key))+1, newKey);
	}

	public void printHeap(){
    	int max = 0;
    	int n = heap.size();

    	for(int i=0;i<n+1;i++){
            for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<n+1;j++){
                if(j>max){
                    max=j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
    	
    	 for(int i=0;i<n+1;i++){
    	        for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<n+1;j++){
    	            for(int k=0;(k<2*max/((int)Math.pow(2, i)));k++){
    	                sb.append(" ");
    	            }
    	            sb.append(heap.get(j+(int)Math.pow(2,i)-1)+" ");
    	        }
    	        sb.append("\n");
    	    }
    	    System.out.println(sb.toString());

    }

	public List<T> getHeap(){
		return heap;
	}
	
	public boolean isEmpty(){
		return heap.size()==0;
	}

	public void delete(T elem){
		int idx= heap.indexOf(elem);
		heap.set(idx, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		//shiftDown(idx);
	}
	
	public int getIndex(T key){
		return heap.indexOf(key);
	}
}
