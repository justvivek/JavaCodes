package DP;
/* Write a function canSum(target_sum, numbers) that takes in a target
 * sum and an array of numbers as arguments.The function should return
 * a boolean indicating whether or not it is possible to generate the 
 * target sum using numbers from the array.
 */
public class CanSum {
	static boolean isSubsetSum(int a[], int size, int sum) {
		boolean[][] subset = new boolean[size+1][sum+1];
		//0 sum possible by not taking any element
		for(int i=0; i<= size ; i++) {
			subset[i][0] = true;
		}
		//none of sum>=1 is possible with no elements
		for(int i=1; i<=sum ; i++) {
			subset[0][i] = false;
		}
		
		for(int i=1; i<= size; i++) {
			for(int j=1; j<=sum; j++) {
				subset[i][j] = subset[i-1][j];
				if(j >= a[i-1]) {
					subset[i][j] = subset[i][j] || subset[i-1][j- a[i-1]];
				}
			}
		}
		return subset[size][sum];
	}
	
	public static void main(String[] args) {
		int[] a = {3,4,5,2};
		int size = a.length;
		int sum = 14;
		System.out.println("IS SUM OF "+ sum + " is possible from set "+ a.toString() + " ?? "+ isSubsetSum(a, size, sum));
	}
}
