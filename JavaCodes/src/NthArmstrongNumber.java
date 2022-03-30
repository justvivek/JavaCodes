import java.lang.Math;
public class NthArmstrongNumber {
	int findNthArmstrongNumber(int n) {
		int count =0;
		for(int i=1; i<Integer.MAX_VALUE; i++) {
			int num =i, sum=0, order=0, rem;
			
			order = (int)Math.log10(num) + 1;
			
			while(num != 0) {
				rem = num%10;
				sum = sum + (int)Math.pow(rem, order);
				num = num/10;
			}
			if(sum == i)
				System.out.println(++count + "   "+ i);
			if(count == n)
				return i;
		}
		return 0;
	}
	public static void main(String[] args) {
		NthArmstrongNumber obj = new NthArmstrongNumber();
		int i = 15;
		System.out.println("The "+i+ "th Armstrong Number is: " + obj.findNthArmstrongNumber(i));	
	}
}
