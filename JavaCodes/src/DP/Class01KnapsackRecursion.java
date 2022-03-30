package DP;

public class Class01KnapsackRecursion {
	public static int knapsackRecur(int Weight, int[] wt, int[] val, int items) {
		if(Weight ==0 || items< 0) return 0;
		if(Weight >= wt[items]) {
			return Math.max(val[items]+ knapsackRecur(Weight-wt[items], wt, val, items-1), knapsackRecur(Weight, wt, val, items-1));
		}else {
			return knapsackRecur(Weight, wt, val, items-1);
		}
		
	}
	
	public static void main(String[] args) {
		int[] wt = {1,2,3,4};
		int[] val = {20,3,5,40};
		int Weight = 6;
		int len = val.length;
		int max = knapsackRecur(Weight, wt, val, len-1);
		System.out.println("Maximum total value in knapsack would be "+ max);
	}
}
