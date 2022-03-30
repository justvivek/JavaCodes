
public class CheckPalindromeNumber {
	static int reverse(int num, int temp) {
		//base condition
		if(num == 0)
			return temp;
		 temp = temp*10 + num%10;
		 return reverse(num/10, temp);
	}
	
	public static void main(String[] args) {
		int num= 12321;
		int rev = reverse(num, 0);
		if(num == rev) {
			System.out.println(num +" is Palindrome");
		}
		else
			System.out.println(num +" is not Palindrome");
	}
}
