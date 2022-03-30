package DP;

// Bell Numbers (Number of ways to Partition a Set)
// Given a set of n elements, find number of ways of partitioning it. 
public class BellNumbers {
	static int bellNumber(int n) {
		int[][] bell = new int[n+1][n+1];
		
		bell[0][0] = 1;
		for(int i=1; i<=n; i++) {
			// Then copy last entry of previous row
			// Note that i'th row has i entries
			bell[i][0] = bell[i-1][i-1];
			for(int j=1; j<=i; j++) {
				 // Then this element is sum of previous element 
				 // in current row and the element just above the
				 // previous element
				bell[i][j] = bell[i][j-1] + bell[i-1][j-1];
			}
		}
		
		return bell[n][0];
	}
	
	public static void main(String[] args) {
		int i=5;
		System.out.println("Bell number for n="+i+ " is "+ bellNumber(i) );
	}
}
