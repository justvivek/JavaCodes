package DP;

public class Fibbonacci {
	//Space optimized solution
	public static int fib(int n) {
		int a=0, b=1, c;
		if(n==0)
			return 0;
		for(int i=2; i<=n; i++) {
			c = a+b;
			a=b;
			b=c;
		}
		return b;
	}
	
	/*
	public static int fib(int n) {
		int[] f = new int[n+2];
		f[0] = 0;
		f[1] = 1;
		for(int i=2; i<=n; i++) {
			f[i]= f[i-1] + f[i-2];
		}
		
		return f[n];
	}
	*/
	public static void main(String[] args) {
		int i = 0;
		int res = fib(i);
		System.out.println("Fibonacci of "+i + " is "+ res );
	}
}
