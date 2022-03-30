package PatternProblems;

import java.util.Arrays;
//import java.util.Collections;

/* Program to segregate even and odd elements of array and then
 * Sort all even numbers in ascending order 
 * and then sort all odd numbers in descending order
 */
public class ClassEvenAscOddDesc {
	public void segregateOddDescEvenAsc(int[] arr, int arr_size) {
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
			else {	odd_pos++;	count_odd++; }
		}
		// Make all odd numbers negative
		for(int i=0; i< count_odd; i++) { arr[i] = -arr[i]; }
		
		//Sort the Array
		Arrays.sort(arr);
		
		// Retaining original array
		for(int i=0; i< count_odd; i++) { arr[i] = -arr[i];	}
	}
	public void printArr(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		ClassEvenAscOddDesc cs = new ClassEvenAscOddDesc();
		int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 10, 13, 11, 21, 13, 100};
		int size = a.length;
		cs.printArr(a, size);
		System.out.print("\n");
		cs.segregateOddDescEvenAsc(a, size);
		cs.printArr(a, size);
	}
}
