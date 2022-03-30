package Sorting;

//Java program to test whether an array
//can be sorted by swapping adjacent
//elements using boolean array
public class SortSwappingAdjacent {
	
	static boolean sortedAfterSwap(int[] a, int[] b, int n) {
		for(int i=0; i< n-1; i++) {
			if(b[i] != 0) {
				if(a[i] != i+1) {
					int t = a[i];
					a[i] = a[i+1];
					a[i+1] = t;
				}
			}
		}
		for(int i=0; i<n;i++) {
			if(a[i] != i+1)
				return false;
		}
		return true;
	}
    public static void main(String[] args)
    {
        int[] a = { 1, 2, 5, 3, 4, 6 };
        int[] b = { 0, 1, 1, 1, 0 };
        int n = a.length;
     
        if (sortedAfterSwap(a,b,n))
            System.out.println("A can be sorted");
        else
            System.out.println("A can not be sorted");
    }
}
