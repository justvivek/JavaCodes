package PatternProblems;

//Java program to sort an array of 0, 1 and 2
public class ClassSort012 {
	public void sort012(int[] arr, int arr_size) {
		int cnt0 =0, cnt1 =0, cnt2 =0;
		int i=0;
		while(i<arr_size) {
			switch(arr[i]) {
			case 0:
				cnt0++;	break;
			case 1:
				cnt1++;	break;
			case 2:
				cnt2++;	break;
			}
			i++;
		}
		i=0;
		while(cnt0>0) {	arr[i++]=0;	cnt0--;	}
		while(cnt1>0) {	arr[i++]=1;	cnt1--;	}
		while(cnt2>0) {	arr[i++]=2;	cnt2--;	}
	}
	
	public void printArr(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		ClassSort012 cs = new ClassSort012();
		int[] arr = {0, 1, 2, 1, 0, 1, 2, 1, 1, 0, 2, 0, 0, 1, 2, 1, 0};
		int size = arr.length;
		cs.printArr(arr, size);
		System.out.print("\n");
		cs.sort012(arr, size);
		cs.printArr(arr, size);
	}
}
