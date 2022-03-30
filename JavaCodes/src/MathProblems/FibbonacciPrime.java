package MathProblems;

import java.util.*;
public class FibbonacciPrime {
	public static void main(String[] args) {
		int n =50;
		long[] al = new long[n];

		long a =0, b=1;
		al[0]=a;
		al[1]=b;
		for(int i=2; i<n; i++) {
			long sum = a+b;
			a =b;
			b = sum;
			al[i]=b;
		}
		System.out.println(al.length);
		System.out.println(al);
		
		for(long i:al) {
			System.out.print(i+ " ");
		}
		//Sum of all numbers at prime position
		
		al[1] =0;
		for(int i=2; i*i<n; i++) {
			if(al[i] != 0) {
				for(int j =i*2; j<n; j +=i) {
					al[j]=0;
				}
			}
		}
		System.out.println();
		for(long i:al) {
			System.out.print(i+ " ");
		}
		
	}
}
