//Kadane's Algorithm 
/* Given an array Arr[] of N integers. Find the contiguous 
 * sub-array(containing at least one number) which has the
 * maximum sum and return its sum.
 */
public class maxSubArraySum {
	
	static int subArrayMaxSum(int a[]) {
		int max_sum = Integer.MIN_VALUE, max_end_here=0;
		int len = a.length;
		int start=0, s=0,end=0;
		for(int i=0; i< len;i++) {
			max_end_here += a[i];
			if(max_end_here > max_sum) {
				max_sum = max_end_here;
				start = s;
				end =i;
			}
			if(max_end_here < 0) {
				max_end_here =0;
				s= i+1;
			}
		}
		System.out.println("Starting Index "+ start + "\nEnding Index "+ end);
		return max_sum;
	}
	
	public static void main(String[] args) {
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(subArrayMaxSum(a) +" is Maximum contigous sum of subarray");
	}
}
