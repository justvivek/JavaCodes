package PatternProblems;

//Using divide and conquer based efficient solution to find
//median of two sorted arrays of same size.

public class MedianOfTwoSortedArrayEfficient {
	/* This function returns median of a[] and b[] Assumptions in this function:
        Both a[] and a[] are sorted arrays Both have n elements
    */
	public static int getMedian(int[] a, int[] b, int sa, int sb, int ea, int eb) {
		if(ea-sa ==1) {
			return (Math.max(a[sa], b[sb]) + Math.min(a[ea], b[eb]))/2;
		}
		int m1 = median(a, sa, ea);
		int m2 = median(b, sb, eb);
		
		if(m1 == m2)
			return m1;

        /* if m1 < m2 then median must exist in ar1[m1...end] and ar2[0...m2] 
        */
		else if(m1< m2) {
			return getMedian(a, b, (sa+ea+1)/2, sb, ea, (sb+eb+1)/2);
		}
		/* if m1 > m2 then median must exist in ar1[0...m1] and ar2[m2...end] 
	    */
		else {
			return getMedian(a,b,sa,(sb+eb+1)/2, (sa+ea+1)/2, eb );
		}
	}
	 /* Function to get median of a sorted array */
	public static int median(int[] arr, int s, int e) {
		int n = e-s+1;
		if((n)%2 == 0) {
			return (arr[s+n/2] + arr[s + (n/2 -1) ])/2;
		}
		else
			return arr[s + n/2];
	}
	public static void main(String[] args) {
		int[] a_arr = {1,2,3,6};
		int[] b_arr = {4,6,8,10};
		int n1 = a_arr.length;
		int n2 = b_arr.length;
		
		if(n1 != n2) {
			System.out.println("Not equal array");
		}
		else if(n1 == 0)
			System.out.println("Empty array");
		else if(n1 ==1)
			System.out.println("Median "+ (a_arr[0] + b_arr[0])/2);
		else
			System.out.println("Median "+ getMedian(a_arr, b_arr, 0, 0, n1-1, n2-1));
	}
}
