package DP;

public class EggDropUsingDP {
	static int eggDrop(int n, int k) {
	/* A 2D table where entry trial[i][j] 
	 will represent minimum number of trials 
	needed for i eggs and j floors. */
		int trial[][] = new int[n+1][k+1];
		
		// We need one trial for one floor and
        // 0 trials for 0 floors
		for(int i=1; i<=n; i++) {
			trial[i][1] = 1;
			trial[i][0] = 0;
		}
		
		// We always need j trials(worst case) for one egg
        // and j floors.
		for(int j=1; j<=k; j++) {
			trial[1][j] = j;
		}
		
		for(int i =2; i<=n; i++) {
			for(int j=2; j<=k; j++) {
				trial[i][j] = Integer.MAX_VALUE;
				for(int t=1; t<=j;t++) {
					int res = 1+ Math.max(trial[i-1][t-1], trial[i][j-t]);
					if(res < trial[i][j])
						trial[i][j] = res;
				}
			}
		}
		return trial[n][k];
	}


	public static void main(String[] args) {
		System.out.println(eggDrop(2,5));
	}
}
