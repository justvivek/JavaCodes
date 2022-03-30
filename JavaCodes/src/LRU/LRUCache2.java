package LRU;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

//Java program to implement LRU cache
//using LinkedHashSet
public class LRUCache2 {
	private Set<Integer> lhs;
	private final int CACHE_SIZE;
	
	LRUCache2(int size){
		lhs = new LinkedHashSet<Integer>();
		CACHE_SIZE = size;
	}
	/* This function returns false if key is not
    * present in cache. Else it moves the key to
    * front by first removing it and then adding
    * it, and returns true.
	*/
	public boolean get(int key) {
		if(!lhs.contains(key))
			return false;
		lhs.remove(key);
		lhs.add(key);
		return true;
	}
	
	public void put(int key) {
		if(lhs.size() == CACHE_SIZE) {
			int firstKey = lhs.iterator().next();
			lhs.remove(firstKey);
		}
		lhs.add(key);
	}
	
	/* Refers key x with in the LRU cache */
	public void refer(int key) {
		if(get(key) == false)
			put(key);
	}
	
	/* Displays contents of cache in Reverse Order 
	*/
	public void display() {
		LinkedList<Integer> lst = new LinkedList<>(lhs);
		
//		Iterator<Integer> itr = lst.iterator();
		/* The descendingIterator() method of java.util.LinkedList
	    *  class is used to return an iterator over the elements
	    *  in this LinkedList in reverse sequential order
		*/
		Iterator<Integer> itr = lst.descendingIterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + "-->");
		}
	}
	
	public static void main(String[] args) {
		LRUCache2 cache = new LRUCache2(4);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		cache.refer(2);
		cache.refer(2);
		cache.refer(1);
//		cache.refer(1);
//		cache.refer(1);
		cache.display();
	}
	
	
}
