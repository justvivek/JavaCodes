package DP;

public class MinCoinRequiredRecursion {
	//Infinite supply of each coin
	static int minCoinChange(int[] stack, int coins, int sum) {
		if(sum == 0) return 0;
		int res = Integer.MAX_VALUE;
		for(int i=0; i<coins; i++) {
			if(sum >= stack[i]) {
				int sub_res = minCoinChange(stack, coins, sum-stack[i]);
				if(sub_res  != Integer.MAX_VALUE && sub_res + 1<res)
					res = sub_res +1;
			}
		}
		return res;
	}
	
	////Limited supply of each coin
	static int minCoinChangeLimitedSupply(int[] stack, int start, int coins, int sum) {
		if(sum == 0) return 0;
		int res = Integer.MAX_VALUE;
		for(int i=start; i<coins; i++) {
			if(sum >= stack[i]) {
				int sub_res = minCoinChangeLimitedSupply(stack, i+1, coins, sum-stack[i]);
				if(sub_res  != Integer.MAX_VALUE && sub_res + 1<res)
					res = sub_res +1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] stack = {4,3,5,6,1};
		int sum= 20;
		int coins = stack.length;
		System.out.println("Min Coin required to get sum "+ sum+ " is "+ minCoinChangeLimitedSupply(stack,0, coins, sum));
	}

}
