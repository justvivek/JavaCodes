
public class TrivialHashing {
	final static int MAX = 100;
	
	static boolean[][] hash = new boolean[MAX+1][2];
	
	static void insert(int a[], int len) {
		for(int i=0; i< len; i++) {
			if(a[i] >= 0) {
				hash[a[i]][0] = true;
			}else {
				int abs_i = Math.abs(a[i]);
				hash[abs_i][1] = true;
			}
		}
	}
	
	static boolean search(int key) {
		if(key >= 0) {
			if(hash[key][0])
				return true;
			else
				return false;
		}
		key = Math.abs(key);
		if(hash[key][1])
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
//		TrivialHashing h = new TrivialHashing();
		int[] a = {-1, 9, -5, -8, -5, -2};
		int n = a.length;
		insert(a, n);
		if(search(10)) {
			System.out.println("10 is present");
		}
		else
			System.out.println("10 is not present");
//		System.out.println("9 is present");
		if(search(-8)) {
			System.out.println("-8 is present");
		}
	}
}
