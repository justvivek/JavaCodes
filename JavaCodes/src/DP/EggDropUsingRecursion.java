package DP;

public class EggDropUsingRecursion {
	/* Function to get minimum number of 
    trials needed in worst case with n 
    eggs and k floors */
	static int eggDrop(int n, int k) {
		/* If there are no floors, then no trials needed. OR if there is one floor, one trial needed */
		if(k==0 || k==1)
			return k;
		/* We need k trials for one egg and k floors */
		if(n==1)
			return k;
		
		int min = Integer.MAX_VALUE;
		int res;
		
		/*Consider all droppings from
        1st floor to kth floor and
        return the minimum of these
        values plus 1. */
		
		for(int i=1; i<=k; i++) {
			res = Math.max(eggDrop(n-1, i-1), eggDrop(n, k-i));
			if(res < min)
				min = res;
		}
		return min+1;
	}
	
	public static void main(String[] args) {
		System.out.println(eggDrop(2,5));
		System.out.println(eggDrop(2,6));
		System.out.println(eggDrop(2,7));
		System.out.println(eggDrop(2,8));
		System.out.println(eggDrop(2,9));
		System.out.println(eggDrop(2,10));
	}
}
