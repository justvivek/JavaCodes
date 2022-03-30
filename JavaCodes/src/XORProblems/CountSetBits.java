package XORProblems;

public class CountSetBits {
	//Normal mehtod
	/*
	static int setBitsCount(int n) {
		int count =0;
		while(n>0) {
//			count += n&1;
			if((n&1) != 0)
				count++;
			n = n>>1;
		}
		return count;
	}
	*/
	
	//Using Recursion
	/*
	static int setBitsCount(int n) {
		if(n == 0)
			return 0;
		else
			return (n&1) + setBitsCount(n>>1);
	}
	*/
	
	/* Brian Kernighan’s Algorithm
	* So if we subtract a number by 1 and do it bitwise & with itself (n & (n-1)),
	* we unset the rightmost set bit. If we do n & (n-1) in a loop and count the number 
	* of times the loop executes, we get the set bit count. 
	*/
	
	static int setBitsCount(int n) {
		int count =0;
		while(n>0) {
			n = n&(n-1);
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int  n= 7;
		System.out.println("Set bits are:- "+ setBitsCount(n));
	}
}
