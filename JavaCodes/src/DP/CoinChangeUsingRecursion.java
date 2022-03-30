package DP;

public class CoinChangeUsingRecursion {
	public static int coinChange(int stack[], int total_coin, int sum) {
		if(sum==0)
			return 1;
		if(sum<0 || (total_coin==0 && sum>=1))
			return 0;
		return coinChange(stack, total_coin-1, sum)+ coinChange(stack, total_coin , sum-stack[total_coin-1]);
	}
	public static void main(String[] args) {
		int[] stack = {2,3,5,6,4,1};
		int sum= 5;
		int coins = stack.length;
		System.out.println("No of ways for sum 10 is "+ coinChange(stack, coins, sum));
	}
}
