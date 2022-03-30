package LRU;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* We can use Java inbuilt Deque as a double ended queue to store the cache keys, with
* the descending time of reference from front to back and a set container to check presence
* of a key. But remove a key from the Deque using remove(), it takes O(N) time. This can be
* optimized by storing a reference (iterator) to each key in a hash map. 
*/
public class LRUCache {
	private Deque<Integer> dq;
	private HashSet<Integer> hs;
	private final int CACHE_SIZE;
	
	LRUCache(int size){
		dq = new LinkedList<Integer>();
		hs = new HashSet<Integer>();
		CACHE_SIZE = size;
	}
	
	/* Refer the page within the LRU cache */
	public void refer(int page) {
		if(!hs.contains(page)) {
			if(dq.size() == CACHE_SIZE) {
				int last = dq.removeLast();
				hs.remove(last);
			}
		}
		/* The found page may not be always the last element, even if it's an
        intermediate element that needs to be removed and added to the start
        of the Queue */
		else
			dq.remove(page);
		dq.push(page); //Pushes an element onto the stack represented by this deque (in otherwords, at the head of this deque)
//		dq.add(page); //Inserts the specified element into the queue represented by this deque(in other words, at the tail of this deque) 
		hs.add(page);
	}
	
	public void display() {
		Iterator<Integer> itr = dq.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+ "-->");
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
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
