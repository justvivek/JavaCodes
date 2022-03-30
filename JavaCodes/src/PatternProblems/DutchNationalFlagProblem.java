package PatternProblems;

public class DutchNationalFlagProblem {
	// Sort the input array, the array is assumed to
    // have values in {0, 1, 2}
	public void sort012(int[] arr, int a_size) {
		int lo = 0;
		int mid = 0;
		int hi = a_size-1;
		int temp=0;
		while(mid <= hi) {
			switch(arr[mid]) {
			case 0:
				temp = arr[lo];
				arr[lo]= arr[mid];
				arr[mid] = temp;
//				swap(arr[lo], arr[mid]);
				lo++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[mid];
				arr[mid]= arr[hi];
				arr[hi] = temp;
//				swap(arr[mid], arr[hi]);
				hi--;
				break;
			}
		}
	}

	public void swap(int a, int b) {
		int temp = a;
		a=b;
		b=temp;
	 }
	public void printArr(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		DutchNationalFlagProblem cs = new DutchNationalFlagProblem();
		int[] a = {0, 1, 2, 1, 0, 1, 2, 1, 1, 0, 2, 0, 0, 1, 2, 1, 0};
		int size = a.length;
		cs.printArr(a, size);
		System.out.print("\n");
		cs.sort012(a, size);
		cs.printArr(a, size);
	}
}
