package myHashMap;

import java.util.Objects;
import java.util.ArrayList;

class hashNode<K, V>{
	K key;
	V value;
	final int hashCode;
	hashNode<K,V> next;
	hashNode(K key, V value, int hashCode){
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
	}
}

//Class to represent entire hash table
public class hashMap<K,V> {
	// bucketArray is used to store array of chains
	private ArrayList<hashNode<K, V>> bucketArray;
	
	// Current capacity of array list
	private int numBuckets;
	
	// Current size of array list
	private int size;
	
	// Constructor (Initializes capacity, size and
    // empty chains.
	hashMap(){
		bucketArray = new ArrayList<hashNode<K,V>>();
		numBuckets = 10;
		size = 0;
		// Create empty chains
		for(int i=0; i< numBuckets; i++)
			bucketArray.add(null);
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size() == 0;}
	
	private final int hashCode(K key) {
		return Objects.hashCode(key);
	}
	
	// This implements hash function to find index
    // for a key
	private int getBucketIndex(K key) {
		int hashCode = hashCode(key);
		int index = hashCode % numBuckets;
		
		index = index < 0 ? index* -1: index;
		return index;
	}
	
	 // Method to remove a given key
	public V remove(K key) {
		// Apply hash function to find index for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		// Get head of chain
		hashNode<K,V> head = bucketArray.get(bucketIndex);
		
		hashNode<K,V> prev = null;
		// Search for key in its chain
		while(head != null) {
			// If Key found
			if(head.key.equals(key) && head.hashCode == hashCode)
				break;
			// Else keep moving in chain
			prev = head;
			head = head.next;
		}
		// If key was not there
		if(head == null)
			return null;
		// Reduce size
		size--;
		// Remove Key
		if(prev != null) {
			prev.next = head.next;
		}
		else
			bucketArray.set(bucketIndex, head.next);
		return head.value;
	}
	
	 // Returns value for a key
	public V get(K key) {
		// Find head of chain for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		hashNode<K,V> head = bucketArray.get(bucketIndex);
		
		// Search key in chain
		while(head != null) {
			if(head.key.equals(key) && head.hashCode == hashCode)
				return head.value;
			head = head.next;
		}
		// If key not found
		return null;
	}
	
	// Adds a key value pair to hash
	public void add(K key, V value) {
		// Find head of chain for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		hashNode<K,V> head = bucketArray.get(bucketIndex);
		
		// Check if key is already present
		while(head != null) {
			if(head.key.equals(key) && head.hashCode == hashCode) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		// Insert key in chain
		size++;
		bucketIndex = getBucketIndex(key);
		head = bucketArray.get(bucketIndex);
		hashNode<K,V> newNode = new hashNode<K,V>(key, value, hashCode);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);
		
		// If load factor goes beyond threshold, then
        // double hash table size
		if((1.0 * size) / numBuckets > 0.7) {
			ArrayList<hashNode<K,V>> temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = 2*numBuckets;
			size = 0;
			for(int i=0; i<numBuckets; i++) {
				bucketArray.add(null);
			}
			
			for(hashNode<K,V> headNode : temp) {
				while(headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		hashMap<String, Integer> mp = new hashMap<>();
		mp.add("kasam", 3);
		mp.add("ki", 7);
		mp.add("kasam", 11);
		mp.add("hai", 19);
		mp.add("kasam", 17);
		mp.add("se", 2);
		System.out.println("Check whether empty or not ? "+ mp.isEmpty());
		System.out.println("Size of Map "+ mp.size());
		System.out.println("Get Value corresponding to key \"kasam\" "+ mp.get("kasam"));
		System.out.println("Remove key \"kasam\" from Map "+ mp.remove("kasam"));
		System.out.println("Size of Map "+ mp.size());
		System.out.println("Remove key \"kasam\" from Map "+ mp.remove("kasam"));
		System.out.println("Check whether empty or not ? "+ mp.isEmpty());
	}
}
