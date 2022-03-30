package DP;
/* Say that you are a traveler on a grid. 
 * You begin in the top-left corner and your goal is to travel to 
 * the bottom-right corner.You may only move down or right. 
 * In how many ways can you travel to the goal on a grid
 * with dimension m * n
 * */
public class GridTraveller {
	public static int grid_travel(int m, int n) {
		int [][] grid = new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0)
					grid[i][j] = 0;
				else if(i== 1 && j==1)
					grid[i][j] = 1;
				else
					grid[i][j] = grid[i-1][j] + grid[i][j-1];
			}
		}
		return grid[m][n];
		
	}
	public static void main(String[] args) {
		int res = grid_travel(5,5);
		System.out.println(res);
	}
}
