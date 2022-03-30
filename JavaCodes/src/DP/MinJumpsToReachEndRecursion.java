package DP;

public class MinJumpsToReachEndRecursion {
	static int minJumps(int[] arr, int cur, int len) {
		if(cur == len)
			return 0;
		if(arr[cur] == 0)
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=cur+1; i<=len && i<=cur+arr[cur]; i++) {
			int jumps = minJumps(arr, i, len);
			if(jumps != Integer.MAX_VALUE && jumps+1<min)
				min = jumps+1;
		}
		return min;
	}
	// Driver code
    public static void main(String args[])
    {
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        
        System.out.print("Minimum number of jumps to reach end is "
                         + minJumps(arr, 0, n - 1));
    }
}
