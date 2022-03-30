package String;
//given a String like aaabbbcccaa need to return output like a3b3c3a2.
public class CountCharsInString {
	static String countString(String str) {
		if(str.isEmpty())
			return null;
		String compStr = "";
		char[] strC = str.toCharArray();
		char prev = strC[0];
		System.out.println(strC);
		int count =0;
		for(char ch : strC) {
			if(ch == prev) {
				count++;
			}
			else {
				compStr += prev + ""+count;
				count=1;
			}
			prev = ch;
		}
		compStr += prev+""+count;
		return compStr;
	}
	
	public static void main(String[] args) {
		String str = "aabbdccceeesss";
		System.out.println(countString(str));
	}
}
