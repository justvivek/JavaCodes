package DP;


public class Class01Kanpsack {
	static int max(int a, int b) {
		return a>b?a:b;
	}
	/* This solution is having space complexity of O(len+1* W+1) 
	 * 
	static int knapsack(int W, int[] wt, int[] val, int len) {
		int[][] K = new int[len+1][W+1];
		for(int i=0; i<=len; i++) {
			for(int w=0; w<=W; w++) {
				if(i==0 || w==0)
					K[i][w] = 0;
				else if(wt[i-1] <= w) {
					K[i][w] = max(K[i-1][w] , val[i-1]+ K[i-1][w-wt[i-1]]);
				}
				else
					K[i][w] = K[i-1][w];
			}
		}
		return K[len][W];
	}
	*/
	
	//This solution is having space complexity of O(2*W+1)
	static int knapsack1(int W, int[] wt, int[] val, int len) {
		int[][] K = new int[2][W+1];
		// We know we are always using the the current row or
	    // the previous row of the array/vector . Thereby we can
	    // improve it further by using a 2D array but with only
	    // 2 rows i%2 will be giving the index inside the bounds
	    // of 2d array K
		for(int i=0; i<=len; i++) {
			for(int w=0; w<=W; w++) {
				if(i==0 || w==0) {
					K[i%2][w] = 0;
				}
				else if(wt[i-1] <= w) {
					K[i%2][w] = Math.max(K[(i-1)%2][w], val[i-1]+K[(i-1)%2][w-wt[i-1]]);
				}
				else
					K[i%2][w] = K[(i-1)%2][w];
			}
		}
		return K[len%2][W];
	}
	
	//This soln is having space complexity of O(W)
	static int knapsack(int W, int[] wt, int[] val, int len) {
		int[] dp = new int[W+1];
		
		// taking first i elements
		for(int i=1; i<=len; i++) {
			/* Starting from back,so that we also have data of
            *  previous computation when taking i-1 items
			*/
			for(int w=W; w>=0; w--) {
				if(wt[i-1] <= w) {
					dp[w] = Math.max(dp[w], val[i-1]+ dp[w-wt[i-1]]);
				}
			}
		}
		return dp[W];
	}
	public static void main(String[] args) {
		int[] wt = {1,2,3};
		int[] val = {10,15,40};
		int Weight = 5;
		int len = val.length;
		int max = knapsack1(Weight, wt, val, len);
		System.out.println("Maximum total value in knapsack would be "+ max);
	}
}
