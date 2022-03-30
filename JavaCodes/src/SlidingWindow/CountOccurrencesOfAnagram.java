package SlidingWindow;

import java.util.Arrays;

public class CountOccurrencesOfAnagram {
	static int countAnagram(String str, String pat) {
		int len = str.length();
		int ws = pat.length();
		int i=0, j=0;
		int count =0;
		int[] strChar = new int[26];
		int[] patChar = new int[26];

		patChar[pat.charAt(j) - 'a']++;
		
		while(j<len) {
			//do our calculation here
			strChar[str.charAt(j) - 'a']++;
			if(j-i+1 < ws) {
				j++;
				patChar[pat.charAt(j) - 'a']++;
			}
			else if(j-i+1 == ws) {
				//get answer from calculation here then slide the window
				if(Arrays.equals(strChar, patChar))
					count +=1;
				strChar[str.charAt(i)-'a']--;
				i++;
				j++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		String str = "forxxorfxdofr";
		String pat = "for";
		
		int res = countAnagram(str, pat);
		System.out.println("Total count of "+ pat + " Anagrams in String "+ str + " is: "+ res);
	}
}
