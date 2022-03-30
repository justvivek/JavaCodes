package LFU;

import java.util.Map;
import java.util.HashMap;

/*
 * 2 HashMap & 1 DoubleLinkedList approach 
 * 
 */
public class LFUCache {
	class Node{
		int key, value, cnt;
		Node next, prev;
		Node(int key, int value){
			this.key = key;
			this.value = value;
			cnt = 1;
		}
	}

	class DLList{
		Node head, tail;
		int size;
		DLList(){
			head = new Node(0,0);
			tail = new Node(0,0);
			head.next = tail;
			tail.prev = head;
		}
		@Override
		public String toString() {
			Node temp = head.next;
			int sz = size;
			String s = "";
			while(sz > 0) {
				s = s+ " "+ temp.key;
				temp = temp.next;
				sz--;
			}
			return s;
		}
		void add(Node node) {
			head.next.prev = node;
			node.next = head.next;
			node.prev = head;
			head.next = node;
			size++;
		}
		void remove(Node node) {
			node.next.prev = node.prev;
			node.prev.next = node.next;
			size--;
		}
		Node removeLast() {
			if(size>0) {
				Node node = tail.prev;
				remove(node);
				return node;
			}
			return null;
		}	
	}
	int capacity, leastFrequencyCount;
	// consists of keys vs nodes [with keys and values]
	Map<Integer, Node> nodeMap;
	/* consists of frequency vs doubly linked list of items
	*  if key 1, key 2 and key 3 are occuring only once then,  map would like below
	*  1 -> head -> node key1 -> node key2 -> node key3
	*  lets say with key 1 was updated again, then map would update as below
	*  1 -> head -> node key2 -> node key3 -> tail
	*  2 -> head -> node key1 -> tail
	*/
	Map<Integer, DLList> countMap;
	LFUCache(int capacity){
		this.capacity = capacity;
		nodeMap = new HashMap<>();
		countMap = new HashMap<>();
	}
	
	public int get(int key) {
		Node node = nodeMap.get(key);
		if(node == null) return -1;
		update(node);
		return node.value;
	}
	
	public void put(int key, int value) {
		if(capacity == 0) return ;
		Node node;
		// 1st Possibility if page is already present in Cache
		if(nodeMap.containsKey(key)) {
			// get current node status- use same node in count map doubly linkedlist
			node = nodeMap.get(key);
			node.value = value;
			/* if exists already then there will direct impact on frequency aka count map
			*  update count map. Move the node from old frequency key and associate it with new frequency key 
			*  new frequency key may or may not exists already
			*/
			update(node);
		}
		else { //2nd Possibility if there is no more space in CACHE then we have to evict Least frequently used page
			if(nodeMap.size() == capacity) {
				DLList lastList = countMap.get(leastFrequencyCount);
				nodeMap.remove(lastList.removeLast().key);
			}
			//3rd Possibility if we don't have page present in CACHE and there is space in CACHE also
			node = new Node(key, value);
			nodeMap.put(key, node);
			leastFrequencyCount = 1;
			DLList newList = countMap.getOrDefault(node.cnt, new DLList());
			newList.add(node);
			countMap.put(node.cnt, newList);
		}
	}
	
	/* consists of frequency vs doubly linked list of items
	*  if key 1, key 2 and key 3 are occuring only once then,  map would like below
	*  1 -> head -> node key1 -> node key2 -> node key3
	*  lets say with key 1 was updated again, then map would update as below
	*  1 -> head -> node key2 -> node key3 -> tail
	*  2 -> head -> node key1 -> tail
	*/
	private void update(Node node) {
		DLList oldList = countMap.get(node.cnt);
		oldList.remove(node);
		/* keep track of lowest frequency. One of the indicators of lowest frequency is, oldList size becoming zero
		*  it indicates that one count level has gone completely empty and lowest frequency count needs to be updated 
		*/
		if(node.cnt == leastFrequencyCount && oldList.size == 0)
			leastFrequencyCount++;
		node.cnt++;
		DLList newList = countMap.getOrDefault(node.cnt, new DLList());
		newList.add(node);
		countMap.put(node.cnt, newList);
	}
	
	public void display() {
		for(Map.Entry<Integer, DLList> itr: countMap.entrySet()) {
			System.out.println("Frequency "+ itr.getKey() + " and Keys in it " + itr.getValue().toString());
		}
//		int i=1;
//		while(countMap.containsKey(i)) {
//			DLList list = countMap.get(i);
//			System.out.print("List having frequency "+i+">>>>>");
//			Node temp = list.head.next;
//			int s= list.size;
//			while(s > 0) {
//				System.out.print(" "+temp.key+"-->"+temp.value+"||");
//				s--;
//				temp = temp.next;
//			}
//			i++;
//		}
	}
	
	public static void main(String[] args) {
		LFUCache cache = new LFUCache(3);
		cache.put(3, 4);
		cache.put(1, 2);
		cache.put(2, 2);
		cache.put(3, 2);
		cache.put(2, 2);
		cache.put(1, 2);
		cache.put(4, 6);
		cache.put(5, 6);
		cache.display();
		cache.get(1);
		cache.get(5);
		System.out.print("\n");
		cache.display();
		cache.put(6, 6);
		System.out.print("\n");
		cache.display();
	}
}
