package Trie;
import java.util.*;

/*Most frequent word in an array of strings
 * 
 */
public class ClassFindMostFrequentWord {
	// Function returns word with highest frequency
	static String findWord(String[] arr) {
		
		// Create HashMap to store word and it's frequency
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i=0; i<arr.length; i++) {
			// If word already exist in HashMap then increase it's count by 1
			if(hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i])+1);
			}
			// Otherwise add word to HashMap
			else {
				hm.put(arr[i], 1);
			}
		}
		
		// Create set to iterate over HashMap
		Set<Map.Entry<String, Integer>> set = hm.entrySet();
		String key = "";
		int val=0;
		for(Map.Entry<String, Integer> me: set) {
			// Check for word having highest frequency
			if(me.getValue() > val) {
				val = me.getValue();
				key = me.getKey();
			}
		}
		return key;
	}
	
	public static void main(String[] args) {

        String arr[] = { "greeks", "formid", "greeks", "a",
                         "portal", "to", "learn", "can", "be",
                         "computer", "science", "zoom", "yup",
                         "fire", "in", "be", "data", "greeks" };
        String key = findWord(arr);
        System.out.print("Most frequentword is "+ key);
	}
}
