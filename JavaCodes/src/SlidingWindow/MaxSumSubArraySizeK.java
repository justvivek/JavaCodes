package SlidingWindow;

public class MaxSumSubArraySizeK {
	static int maxSubArray(int[] arr, int size, int k) {
		int sum =0, max= Integer.MIN_VALUE;
		int i=0, j=0;
		while(j<size) {
			sum += arr[j];
			if(j-i+1 <k) {
				j++;
			}
			else if(j-i+1 == k) {
				max = Math.max(max, sum);
				sum = sum - arr[i];
				i++;
				j++;
			}
		}
		return max;
		
	}
	public static void main(String[] args) {
		int[] arr = {10,4,6,8,7,9,3,1};
		int size = arr.length;
		int window_size = 3;
		int max_sum = maxSubArray(arr, size, window_size);
		System.out.println("The maximum sum subarray of window size "+ window_size+ " is "+ max_sum);
	}
}
