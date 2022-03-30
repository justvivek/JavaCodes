package PatternProblems;

import java.util.Arrays;

/*Sort even-placed elements in increasing and odd-placed in decreasing order
 * The modified array should contain all sorted even-placed numbers
 * followed by reverse sorted odd-placed numbers.
 * */
public class ClassEvenOddPlacedSorting {
	public void bitonicGenerator(int[] arr, int arr_size) {
		int count_even = (arr_size+1)/2;
		int odd_pos =1, even_pos = (arr_size-1)%2 == 0 ? arr_size-1: arr_size-2;
		while(odd_pos < even_pos) {
			int temp = arr[odd_pos];arr[odd_pos] = arr[even_pos];	arr[even_pos] = temp;odd_pos += 2;	even_pos -= 2;
		}
		// Make all odd numbers negative
		for(int i=0; i<count_even; i++) {arr[i] = -arr[i];	}
		//Sort the Array
		Arrays.sort(arr);
		// Retaining original array
		for(int i=0; i< count_even; i++) {arr[i] = -arr[i];	}
	}
	public void printArr(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		ClassEvenOddPlacedSorting cs = new ClassEvenOddPlacedSorting();
		int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 10, 13, 11, 21, 15, 100, 201};
		int size = a.length;
		cs.printArr(a, size);
		System.out.print("\n");
		cs.bitonicGenerator(a, size);
		cs.printArr(a, size);
	}
}
