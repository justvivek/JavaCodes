package DP;
/*
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons.
 * Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) 
 * that is from a given cell,the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right.
 * Find out maximum amount of gold he can collect. 
 */
public class GoldMineProblem {
	static int maxGold(int[][] gold, int rows, int cols) {
		int max = 0;
		int[][] goldTable = new int[rows][cols];
		
		for(int j= cols-1; j>= 0; j--) {
			for(int i=0; i<rows; i++) {
				// Gold collected on going to the cell on the right(->)
				int right = (j == cols-1) ? 0 : goldTable[i][j+1];
				// Gold collected on going to the cell to right up (/)
				int right_up = (i==0 || j == cols-1) ? 0 : goldTable[i-1][j+1];
				// Gold collected on going to the cell to right down (\)
				int right_down = (i==rows-1 ||j== cols-1) ? 0 : goldTable[i+1][j+1];
				// Max gold collected from taking either of the
	            // above 3 paths
				goldTable[i][j] = gold[i][j] + Math.max(right, Math.max(right_up, right_down));
			}
		}
		max = goldTable[0][0];
		// The max amount of gold collected will be the max
	    // value in first column of all rows
		for(int i=1;i<rows; i++ ) {
			if(goldTable[i][0] > max)
				max = goldTable[i][0];
		}
		return max;
	}
	public static void main(String[] args) {
		int gold[][]= { {1, 3, 1, 5},
                		{2, 2, 4, 1},
                		{5, 0, 2, 3},
                		{0, 6, 1, 2} };
		int rows = gold.length;
		int cols = gold[0].length;
		System.out.println("Max Gold "+ maxGold(gold, rows, cols));
	}
}
