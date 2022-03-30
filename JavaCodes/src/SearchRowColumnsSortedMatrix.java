/*Search a number in a row wise
  and column wise sorted matrix*/

public class SearchRowColumnsSortedMatrix {
	static boolean search(int[][] mat, int n, int num) {
		int i=0, j=n-1;
		while(i<n && j>=0) {
			if(num == mat[i][j]) {
				System.out.print("At Index (" + i + ","+ j +") "+ num);
				return true;
			}
			else if(num < mat[i][j])
				j--;
			else
				i++;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] a = {{10, 20, 30, 40},
					 {15, 25, 35, 45},
					 {27, 29, 37, 48},
					 {32, 33, 39, 50}};
		System.out.println(search(a, 4, 32)? " Found" : "Not Found"); 
	}
}
