package DP;

public class minCoinDP {
	static int minCoin(int[] stack, int m, int sum) {
		int[] mincoins = new int[sum+1];
		mincoins[0] =0;
		
		for(int i=1; i<=sum; i++ )
			mincoins[i] = Integer.MAX_VALUE;
		
		for(int i=1; i<=sum; i++) {
			for(int j=0; j<m; j++) {
				if(stack[j] <= i) {
					int sub_res = mincoins[i-stack[j]];
					if(sub_res != Integer.MAX_VALUE && sub_res+1 < mincoins[i])
						mincoins[i] = sub_res+1;
				}
			}
		}
		if(mincoins[sum] == Integer.MAX_VALUE) return -1;
		return mincoins[sum];
	}
	
	public static void main(String[] args) {
		int[] stack = {4,3,5,6,1};
		int sum= 23;
		int coins = stack.length;
		System.out.println("Min Coin required to get sum "+ sum+ " is "+ minCoin(stack, coins, sum));
	}
}
