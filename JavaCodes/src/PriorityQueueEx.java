import java.util.*;
public class PriorityQueueEx {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(10);
		pq.add(30);
        pq.add(20);
        pq.add(400);
        System.out.println("Head value using peek function: " + pq.peek());
        Iterator<Integer> itr1 = pq.iterator();
        while(itr1.hasNext())
        	System.out.print(itr1.next()+ " ");
        pq.poll();
        System.out.println("\nAfter removing element using poll function");
        
        Iterator<Integer> itr2 = pq.iterator();
        while(itr2.hasNext())
        	System.out.print(itr2.next()+ " ");
        
        pq.remove(30);
        
        System.out.println("\nAfter removing element using remove function");
        	
        Iterator<Integer> itr3 = pq.iterator();
        while(itr3.hasNext())
        	System.out.print(itr3.next()+ " ");
        
        boolean b= pq.contains(20);
        if(b)
        	System.out.println("pQueue contains 20");
        else
        	System.out.println("pQueue doesn't contain 20");
        
        Object[] arr = pq.toArray();
        System.out.print("Values in Array: ");
        for(int i=0; i<arr.length ; i++)
        	System.out.print(arr[i].toString()+ " ");
	}
}
