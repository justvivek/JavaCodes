package DP;

public class CoinChangeDP {
	public static int coinChange(int[] stack, int total_coins, int sum) {
//		int m= total_coins;
//		int n = sum;
		int[] dp = new int[sum+1];
		dp[0]=1;
		for(int i=0; i<total_coins; i++) {
			for(int j=stack[i]; j<=sum; j++) {
				dp[j] = dp[j] + dp[j-stack[i]];
			}
		}
		return dp[sum];
	}
	public static void main(String[] args) {
		int[] stack = {1,2,3};
		int sum= 4;
		int coins = stack.length;
		System.out.println("No of ways for sum 10 is "+ coinChange(stack, coins, sum));
	}
}
