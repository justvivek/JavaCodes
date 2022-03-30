package String;
/*Count of total anagram substrings
* Given a string of lower alphabet characters, count total substring of this string which are anagram to each other.
* Input  : str = “xyyx”
* Output : 4
* Total substrings of this string which
* are anagram to each other are 4 which 
* can be enumerated as,
* {“x”, “x”}, {"y", "y"}, {“xy”, “yx”}, 
* {“xyy”, “yyx”}
*/

import java.util.Arrays;
import java.util.HashMap;

public class AnagramPairCount {
	static int substringAnagramPairCount(String str) {
		HashMap<String, Integer> map = new HashMap<>();
		int len = str.length();
		for(int i=0; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				char[] valC= str.substring(i,j+1).toCharArray();
				Arrays.sort(valC);
				String val = new String(valC);
				if(map.containsKey(val))
					map.put(val, map.get(val)+1);
				else
					map.put(val,1);
			}
		}
		int anagramPairCount =0;
		for(String key: map.keySet()) {
			int n = map.get(key);
			anagramPairCount += (n*(n-1))/2; 
		}
		return anagramPairCount;
	}
	public static void main(String[] args) {
		String str = "nitin";
		System.out.println("Total count of Anagrams substrings in String "+ str + " is: "+ substringAnagramPairCount(str) );
	}
}
