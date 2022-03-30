package XORProblems;

public class TotalSetBits1ToN {
	//O(nlogn)
	/*
	static int totalSetBits(int n) {
		int count =0;
		for(int i=1; i<=n; i++) {
			count += setBitsCount(i);
		}
		return count;
	}
	
	static int setBitsCount(int i) {
		int c = 0;
		while(i>0) {
			i = i&(i-1);
			c++;
		}
		return c;
	}
	*/
	//Efficient Method
	
	/* Returns position of leftmost set bit.
	The rightmost position is considered
	as 0 */
	/*
	 *  0|0 0
		0|0 1
		0|1 0
		0|1 1
		-|---
		1|0 0
		1|0 1
		1|1 0
		1|1 1
	 * */
	static int getLeftMostBit(int n) {
		int m=0;
		while(n>1) {
			n = n>>1;
			m++;
		}
		return m;
	}
	
	static int getNextLeftMostBit(int n, int m) {
		int temp = 1<<m;
		System.out.println("Value of temp "+ temp + " Value of m "+ m + " Value of n "+ n);
		while(n < temp) {
			temp = temp>>1;
			m--;
		}
		return m;
	}
	
	static int totalSetBits(int n) {
		int m = getLeftMostBit(n);
		
		return countSetBits(n,m);
	}
	
	static int countSetBits(int n, int m) {
		// Base Case: if n is 0, then set bit
	    // count is 0
		if( n==0)
			return 0;
//		m = getNextLeftMostBit(n,m);
		
		// If n is of the form 2^x-1, i.e., if n
	    // is like 1, 3, 7, 15, 31, .. etc,
	    // then we are done.
	    // Since positions are considered starting
	    // from 0, 1 is added to m
		if(n == (1<<(m+1))-1)
			return (m+1)*(1<<m);
		
		// update n for next recursive call
		n = n-(1<<m);
		return (n+1)+ totalSetBits(n) + m*(1<<(m-1));	
	}
	public static void main(String[] args) {
		int n= 17;
		System.out.println("Set bits are:- "+ totalSetBits(n));
	}
}
