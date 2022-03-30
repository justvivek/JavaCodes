package PatternProblems;

import java.util.Arrays;
import java.util.Collections;

/* Program to segregate even and odd elements of array and then
 * Sort all even numbers in ascending order 
 * and then sort all odd numbers in descending order
 */
public class ClassTwoWaySort {
	static void twoWaySort(Integer[] arr, int arr_size) {
		int odd_pos = 0;
		int even_pos = arr_size-1;
		int temp=0;
		int count_odd =0;
		while(odd_pos <= even_pos) {
			if(arr[odd_pos]%2 == 0) {
				temp = arr[odd_pos];
				arr[odd_pos] = arr[even_pos];
				arr[even_pos] = temp;
				even_pos--;
			}
			else {
				odd_pos++;
				count_odd++;
			}
		}
		Arrays.sort(arr, 0, count_odd, Collections.reverseOrder());
		Arrays.sort(arr, count_odd, arr_size);
	}
	public void printArr(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		//Integer class array
		Integer[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 10, 13, 11, 21, 13, 100};
		int size = a.length;
		System.out.println(Arrays.toString(a));
		twoWaySort(a, size);
		System.out.println(Arrays.toString(a));
	}
}
