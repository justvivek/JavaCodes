package String;
import java.util.*;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;

public class CheckStringsAnagram {
	/* To check whether given Strings are
	 * Anagram or not
	 */
	/*
	static boolean checkAnangram(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		char[] str1C = str1.toCharArray();
		char[] str2C = str2.toCharArray();
		
		System.out.println(str1C);
		
		Arrays.sort(str1C);
		Arrays.sort(str2C);

		str1 = new String(str1C);
		str2 = new String(str2C);

		if(!str1.equals(str2))
			return false;
		return true;
	}
	*/
	/* To check whether given character array Strings are
	 * Anagram or not
	 */
	/*
	static boolean checkAnangram(char[] str1, char[] str2) {
		if(str1.length != str2.length)
			return false;
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		for(int i=0; i<str1.length; i++) {
			if(str1[i] != str2[i])
				return false;
		}
		return true;
	}
	*/
	
	/* To check whether given character array Strings are
	 * Anagram or not using HashMap
	 */
	static boolean checkAnangram(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		Map<Character, Integer> hm = new HashMap<>();
		for(int i=0; i<str1.length(); i++) {
			if(hm.containsKey(str1.charAt(i))) {
				hm.put(str1.charAt(i), hm.get(str1.charAt(i))+1);
			}
			else
				hm.put(str1.charAt(i), 1);
		}
		for(int i=0; i<str2.length(); i++) {
			if(hm.containsKey(str2.charAt(i))) {
				hm.put(str2.charAt(i), hm.get(str2.charAt(i))-1);
			}
		}
		Set<Character> s = hm.keySet();
		for(Character ch: s) {
			if(hm.get(ch) != 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String str1 = "AAE";
		String str2 = "BBC";
//		char[] str1 = {'t', 'e', 's', 't'};
//		char[] str2 = {'t', 't', 'e', 's'};
//		System.out.println(new String(str1) + " and " + new String(str2) + " are " + (checkAnangram(str1, str2)  ? "Anagrams" : "not Anangrams"));
		System.out.println(str1 + " and " + str2 + " are " + (checkAnangram(str1, str2)  ? "Anagrams" : "not Anangrams"));
	}
}
