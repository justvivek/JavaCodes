
/*To check a String is palindrome or not
 *  without using any extra space*/

public class CheckPalindrome {
	static boolean isPalindromeS(String str) {
		int len = str.length();
		for(int i=0; i<len/2; i++) {
			if(str.charAt(i) != str.charAt(len-i-1))
				return false;
		}
		return true;
	}
	
	static boolean isPalindrome(String str) {
		StringBuffer sb = new StringBuffer(str);
		String str2 = sb.reverse().toString();
		return str2.equals(str);
	}
	
	public static void main(String[] args) {
		String s = "abcbaa";
		if(isPalindrome(s) == true)
			System.out.println(s + " is Palindrome");
		else
			System.out.println(s + " is not Palindrome");
	}
}
