package PatternProblems;

//Variant of Dutch National Flag Problem
//Program to segregate even and odd elements of array
public class ClassSegregateEvenOdd {
	public void segregateOddEven(int[] arr, int arr_size) {
		int odd_pos = 0;
		int even_pos = arr_size-1;
		int temp=0;
		while(odd_pos <= even_pos) {
			switch(arr[odd_pos]%2) {
			case 0:
				temp = arr[odd_pos];
				arr[odd_pos] = arr[even_pos];
				arr[even_pos] = temp;
				even_pos--;
				break;
			case 1:
				odd_pos++;
				break;
			}
		}
	}
	public void printArr(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		ClassSegregateEvenOdd cs = new ClassSegregateEvenOdd();
		int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 10, 13, 11, 21, 13, 100};
		int size = a.length;
		cs.printArr(a, size);
		System.out.print("\n");
		cs.segregateOddEven(a, size);
		cs.printArr(a, size);
	}
}
