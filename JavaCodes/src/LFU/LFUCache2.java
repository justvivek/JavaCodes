package LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache2 {
	int capacity;
	int min = -1;
	//cache Key and Value
	HashMap<Integer, Integer> vals;
	//Key and Counter
	HashMap<Integer, Integer> counts;
	//Counters and item list
	HashMap<Integer, LinkedHashSet<Integer>> lists;
	
	LFUCache2(int capacity){
		this.capacity = capacity;
		vals = new HashMap<>();
		counts = new HashMap<>();
		lists = new HashMap<>();
		lists.put(1,  new LinkedHashSet<>());
	}
	
	public int get(int key) {
		if(!vals.containsKey(key))
			return -1;
		//get count from counts
		int count = counts.get(key);
		// increase the counter
		counts.put(key, count + 1);
		//remove the element from counter to linkedHashSet
		lists.get(count).remove(key);
		// when current min does not have any data, next one would be the min
		if(count == min && lists.get(count).size() == 0) {
			min++;
		}
		if(!lists.containsKey(count +1))
			lists.put(count+1, new LinkedHashSet<>());
		lists.get(count+1).add(key);
		return vals.get(key);
	}
	
	public void set(int key, int value) {
		if(capacity <= 0)
			return;
		// If key exist we are returning from here
		if(vals.containsKey(key)) {
			vals.put(key, value);
			get(key);
			return;
		}
		if(vals.size() >= capacity) {
			int evict = lists.get(min).iterator().next();
			lists.get(min).remove(evict);
			vals.remove(evict);
			counts.remove(evict);
		}
		// If the key is new, insert the value and current min should be 1 of course
		vals.put(key, value);
		counts.put(key, 1);
		min=1;
		lists.get(1).add(key);
	}
	
	public void display() {
		for(Map.Entry<Integer, LinkedHashSet<Integer>> itr: lists.entrySet()) {
			System.out.println("Frequency "+ itr.getKey() + " and Keys in it: "+ itr.getValue().toString());
		}
	}
	
	public static void main(String[] args) {
		LFUCache2 cache = new LFUCache2(3);
		cache.set(3, 4);
		cache.set(1, 2);
		cache.set(2, 2);
		cache.set(3, 2);
		cache.set(2, 2);
		cache.set(1, 2);
		cache.set(4, 6);
		cache.set(5, 6);
		cache.display();
		cache.get(1);
		cache.get(5);
		System.out.print("\n");
		cache.display();
		cache.set(6, 6);
		System.out.print("\n");
		cache.display();
		
	}
}
