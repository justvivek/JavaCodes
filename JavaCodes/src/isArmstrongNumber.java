import java.util.*;
public class isArmstrongNumber {
	public void isArmstrong(String n) {
		Map<Integer, Integer> tm = new TreeMap<>();
		tm.put(1,2);
		tm.put(4,5);
		tm.put(6,92);
		ArrayList<Integer> res = (ArrayList)tm.values();
		System.out.println(res.toString());
		
		System.out.println("-----------------------");
		char[] charr = n.toCharArray();
		int size = charr.length;
		int sum = 0;
		for(char c : charr) {
			int temp =1;
//			int i= Integer.valueOf(c);
//			System.out.println(i);
			int i = Integer.parseInt(Character.toString(c));
			for(int j=0; j<size; j++) {
				temp = temp*i;
			}
			sum = sum + temp;
			System.out.println(sum);
		}
		if(sum == Integer.parseInt(n))
			System.out.println(n +" is Armstrong Number");
		else
			System.out.println(n +" is not Armstrong Number");
	}
	
	public static void main(String[] args) {
		isArmstrongNumber am = new isArmstrongNumber();
		am.isArmstrong("8");
		am.isArmstrong("371");
		am.isArmstrong("372");
	}
}
