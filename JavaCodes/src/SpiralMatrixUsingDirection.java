
public class SpiralMatrixUsingDirection {
	//Function to set new direction on turning right
	public static String turnright(String c_direction) {
		switch(c_direction) {
		case "east":
			return "south";
		case "south":
			return "west";
		case "west":
			return "north";
		case "north":
			return "east";
		}
		return "";
	}
	
	public static int[] next(int i, int j, String c_direction) {
		switch(c_direction) {
		case "east":
			j++;
			break;
		case "south":
			i++;
			break;
		case "west":
			j--;
			break;
		case "north":
			i--;
			break;
		}
		int[] arr = {i,j};
		return arr;
	}
	
	public static boolean isValid(int i, int j, int r, int c) {
		if(i>=0 && i<r && j>=0 && j<c)
			return true;
		return false;
	}
	
	public static boolean isAlreadyVisited(int i, int j, int mini, int maxi, int minj, int maxj) {
		if(i>=mini && i<=maxi && j>=minj && j<=maxj)
			return false;
		return true;
	}
	public static int[] updateNewMatrix(int mini, int maxi, int minj, int maxj, String c_direction) {
		switch(c_direction) {
		case "east":
			mini++;
			break;
		case "west":
			maxi--;
			break;
		case "north":
			minj++;
			break;
		case "south":
			maxj--;
			break;
		}
		int[] arr = {mini, minj, maxi, maxj};
		return arr;
	}
	
	public static void printSpiral(int[][] a, int R, int C) {
		int count =0;
		
		String current_direc = "east";
		
		int mini=0, minj=0, maxi = R-1, maxj=C-1;
		int i=0, j=0;
		while(count < R*C) {
			System.out.print(a[i][j]+ " ");
			count++;
			int[] p = next(i, j, current_direc);
			
			if(!isValid(p[0], p[1], R, C) || isAlreadyVisited(p[0], p[1], mini, maxi, minj, maxj)) {
				if(!isAlreadyVisited(i, j, mini, maxi, minj, maxj)) {
					int[] store = updateNewMatrix(mini, maxi, minj, maxj, current_direc);
					mini= store[0];
					minj= store[1];
					maxi= store[2];
					maxj= store[3];
				}
				current_direc = turnright(current_direc);
				p = next(i, j, current_direc);
			}
			i= p[0];
			j= p[1];
		}
	}
	public static void main(String[] args) {
		int[][] a = {{1,2,3,4,5},
					{6,7,8,9,10},
					{11,12,13,14,15},
					{16,17,18,19,20},
					{21,22,23,24,25}
					};
		int r= a.length;
		int c= a[0].length;
		
		printSpiral(a,r,c);
	}
}
