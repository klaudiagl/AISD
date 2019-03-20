package Zadanie1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
    	List<Integer> nums = new ArrayList<>();
    	nums.add(12);
    	nums.add(3);
    	nums.add(2);
    	nums.add(15);
    	nums.add(7);
    	nums.add(5);
    	nums.add(4);
    	nums.add(8);
    	nums.add(39);
    	nums.add(1);
    	nums.add(16);
    	

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(nums, Comparator.naturalOrder());
        //q.decreaseKey(4,1);
        //q.findIndexAndDecreaseKey(5, 1);
        q.delete(5);
        int x= q.getIndex(16);
        System.out.println(x);
        q.shiftDown(x);
        q.printHeap();
        
        
    }
}
