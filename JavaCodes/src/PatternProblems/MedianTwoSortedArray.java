package PatternProblems;

//Median of two sorted arrays of different sizes

public class MedianTwoSortedArray {
	static int getMedian(int[] ar1, int[] ar2, int n, int m) {
		int count;
		int m1 = -1, m2 = -1;
		int i=0, j=0;
		
		// Since there are (n+m) elements,  
	    // There are following two cases  
	    // if n+m is odd then the middle  
	    //index is median i.e. (m+n)/2 
		if((m+n)%2 ==1) {
			for(count=0; count<=(m+n)/2; count++) {
				if(i != n && j != m) {
					m1 = (ar1[i] > ar2[j])? ar2[j++]:ar1[i++] ;
				}
				else if(i< n)
					m1 = ar1[i++];
				else
					m1 = ar2[j++];
			}
			return m1;
		}
		else {
			// median will be average of elements
		    // at index ((m+n)/2 - 1) and (m+n)/2
		    // in the array obtained after merging
		    // ar1 and ar2
			for(count=0; count<=(m+n)/2; count++) {
				m1 = m2;
				if(i != n && j != m) {
					m2 = (ar1[i] > ar2[j])? ar2[j++] : ar1[i++];
				}
				else if(i < n)
					m2 = ar1[i++];
				else
					m2 = ar2[j++];
			}
			return (m1+m2)/2;
		}
	}
	
	public static void main(String[] args) {
		int ar1[] = { 2, 3, 5, 8 };
	    int ar2[] = { 10, 12, 14, 16, 18, 20 };
	  
	    int n1 = ar1.length;
	    int n2 = ar2.length;
	  
	    System.out.println(getMedian(ar1, ar2, n1, n2));
	}
}
