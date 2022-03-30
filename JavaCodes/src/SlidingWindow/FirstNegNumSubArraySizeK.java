package SlidingWindow;

import java.util.LinkedList;
import java.util.List;

public class FirstNegNumSubArraySizeK {
	static int[] firstNegNum(int[] arr, int size, int n) {
		int[] res = new int[size-n+1];
		int i=0, j=0;
		int r =0;
		List<Integer> ll = new LinkedList<>();
		while(j<size) {
			//add negative number to list
			if(arr[j]<0)
				ll.add(arr[j]);
			//fixing the window size first
			if(j-i+1 < n)
				j++;
			//when we found our window size
			else if(j-i+1 == n){
				//when we don't have any negative number in list then we don't have any -ve number in that window
				if(ll.size() == 0)
					res[r++] = 0;
				else { //we will get first number from list
					res[r++] = ll.get(0);	
				//before sliding the window if first element of window is equal to first element of list then we'll remove that element from list.
				//as it can't be part of next window, so can't be negative number in that.
//					System.out.println("ll.get(0) == "+ ll.get(0));
					if(arr[i] == ll.get(0))
						ll.remove(0);
				}
				//keep our window intact till last
				i++;
				j++;
			}
		}
		return res;
	}
	
	public String toString(int[] res) {
		String s = "[";
		for(int x: res) {
			s += " "+ x;
		}
		s += " ]";
		return s;
	}
	public static void main(String[] args) {
		int[] arr = {10,-4,-6,8,-7,9,3,1};
		int size = arr.length;
		int window_size = 3;
		int[] first_neg_arr = firstNegNum(arr, size, window_size);
		System.out.println("The first negative arrays num of subarray of window size "+ window_size+ " is [");
		for(int x: first_neg_arr) {
			System.out.print(x + " ");
		}
		
	}
}
