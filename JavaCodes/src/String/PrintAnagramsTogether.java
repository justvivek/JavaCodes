package String;
/*Given a sequence of words, print all anagrams together 
 * 
 * Given an array of words, print all anagrams together. 
 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, 
 * then output may be “cat tac act dog god”.
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintAnagramsTogether {
	static void printAnagrams(String[] arr) {
		HashMap<String, List<String>> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			String word = arr[i];
			char[] valC = word.toCharArray();
			Arrays.sort(valC);
			String newWord = new String(valC);
			
			if(map.containsKey(newWord)) {
				map.get(newWord).add(word);
			}
			else {
				List<String> words = new ArrayList<>();
				words.add(word);
				map.put(newWord, words);
			}
		}
		List<String> lst = new ArrayList<>();
		for(String key: map.keySet()) {
			List<String> lst1 = map.get(key);
				lst.addAll(lst1);
		}
//		lst.sort((s1,s2)-> s2.charAt(0)-s1.charAt(0));
//		lst.sort(Collections.reverseOrder());
		System.out.println(lst);
	}
	
	public static void main(String[] args) {
		String[] arr = {"cat", "dog", "tac", "god", "act", "talu", "ulta", "vivek"};
		printAnagrams(arr);
	}
}
