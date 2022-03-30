//import java.util.HashSet;

/*Find the first repeating element
  in an array of integers*/

/*
// BRUTEFORCE APPROACH
public class FirstRepeatingElementArray {
	static void findElem(int[] arr) {
		int len = arr.length;
		for(int i=0; i<len; i++) {
			for(int j=i+1; j< len; j++) {
				if(arr[i] == arr[j]) { 
					System.out.println("Element is "+ arr[i]);
					return;
				}
			}
		}
		System.out.println("No Element is repeating");
	}
	
	public static void main(String[] args) {
		int[] a= {60, 100, -5, 40, 9, 120, 4, -5, 6, 10};
		findElem(a);
	}
}
 */

// USING HASHSET TO FIND THE DUPLICATE ELEMENT IN 
/*
public class FirstRepeatingElementArray {
	static int findElem(int[] arr) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int arr_len = arr.length;
		int index = -1;
		for(int i=arr_len-1; i>=0; i--) {
			if(!hs.add(arr[i])) {
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] arr= {6, 10, 5, 4, 9, 120, 4, 6, 10};
		int index = findElem(arr);
		if(index >=0) {
			System.out.println("Element is "+ arr[index]+ " at index "+ index);
		}
		else
			System.out.println("No Element is repeating");
	}
}
*/

//USING ADDITIONAL SPACE WITH MAX SIZE ARRAY
public class FirstRepeatingElementArray {
	static int findElem(int[] arr) {
		int max = 0;
		int min = 0;
		for(int elem: arr) {
			if(elem > max)
				max = elem;
			if(elem < min)
				min = elem;
		}
		// OFFSET IS USED IF OUR ARRAY CONTAINS THE NEGATIVE INTEGERS ALSO 
		int offset = Math.abs(min);
		int[] new_arr= new int[max+ offset +1];
		int arr_len = arr.length;
		for(int i=0; i<arr_len; i++) 
			new_arr[arr[i] + offset]++; 
		for(int i=0; i<arr_len; i++) {
			if(new_arr[arr[i] + offset] > 1) {
				return i;
			}
		}
		return -1;

	}
	
	public static void main(String[] args) {
		int[] arr= {6, -100, -5, 4, 9, 120, -5, 40, 6, -100};
		int index = findElem(arr);
		if(index >=0) {
			System.out.println("Element is "+ arr[index]+ " at index "+ index);
		}
		else
			System.out.println("No Element is repeating");
	}
}