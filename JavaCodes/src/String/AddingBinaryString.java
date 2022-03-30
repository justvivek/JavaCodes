package String;

public class AddingBinaryString {
	static String addBitStrings(StringBuilder str1, StringBuilder str2) {
		int len = makeEqualLength(str1, str2);
		String result = "";
		String s1 = str1.toString();
		String s2 = str2.toString();
		 int carry = 0;
		for(int i= len-1; i>=0; i--) {
			int fb = s1.charAt(i) - '0';
			int sb = s2.charAt(i) - '0';
			
			int sum = (fb^sb^carry) + '0';
			System.out.println("fb sb sum " + fb +" "+ sb +" "+ sum);
			
			carry = fb & sb | sb & carry | fb & carry;
			
			result = String.valueOf((char)sum)+ result;
		}
		if(carry ==1) {
			result = "1"+ result;
		}
		return result;
	}
	static int makeEqualLength(StringBuilder str1, StringBuilder str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		if(l1>l2) {
			for(int i=0; i< l1-l2; i++)
				str2.insert(0, '0');
			return l1;
		}
		else {
			for(int i=0; i< l2-l1; i++)
				str1.insert(0, '0');
			return l2;
		}
	}
	
	public static void main(String[] args) {
		String str1 = "1100011";
		String str2 = "10";
		System.out.println("Sum is " + addBitStrings(new StringBuilder(str1), new StringBuilder(str2)) );
	}
}
