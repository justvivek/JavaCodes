package DP;
//need to find max amount of gold in a given matrix, only allowed take steps up and right. Source point will be bottom-left

public class MaxGold {
	static int maxGold(int[][] arr, int row, int col) {
//		int i=arr.length-1, j=0;
		System.out.println("row "+row+ "col "+ col );
		if(row<0 || col>=arr[0].length)
			return 0;
//		if(i==0 && j== col-1) {
//			return arr[i][j];
//		}
//		else if(i==0 && j<col-1) {
//			return arr[i][j] + maxGold(arr, i, j+1);
//		}
//		else if(i>0 && j == col-1) {
//			return arr[i][j] + maxGold(arr, i-1, j);
//		}
//		else if(i>0 && j< col) {
//			return arr[i][j]+ Math.max(maxGold(arr, i-1, j), maxGold(arr,i, j+1));
//		}
//		return 1;
		return arr[row][col]+ Math.max(maxGold(arr, row-1, col), maxGold(arr,row, col+1));
	}
	
	public static void main(String[] args) {
		int gold[][]= { {1, 3, 1, 5},
                	  	{2, 2, 4, 1},
                	  	{5, 0, 2, 3},
                	  	{0, 6, 1, 2} };
		int rows = gold.length;
		int columns = gold[0].length;
		System.out.println("rows "+rows+ "cols "+ columns );
		System.out.println("Max Gold "+ maxGold(gold, rows-1, 0));
		
		
	}
}
