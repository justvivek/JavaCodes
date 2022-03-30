package DP;

public class CatalnNumber {
	//Finding Cataln number using recursion
	/*
	static int cataln(int num) {
		int res =0;
		if(num<=1)
			return 1;
		for(int i=0; i<num; i++) {
			res += cataln(i)*cataln(num-i-1);
		}
		return res;
	}
	*/
	//Finding Cataln number using DP
	static long cataln(int num) {
		long[] cnum = new long[num+2];
		
		cnum[0] = 1;
		cnum[1] = 1;
		for(int i=2; i<=num; i++) {
			cnum[i]=0;
			for(int j=0; j<i; j++) {
				cnum[i] += cnum[j]*cnum[i-j-1];
			}
		}
		return cnum[num];
		
	}
	public static void main(String[] args) {
		for(int i=0; i<=30; i++) {
			System.out.println("Cataln number for n="+i+ " is "+ cataln(i) );
		}
	}
}

/*1. Number of possible Binary Search Trees with n keys.
 *2. Number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 *3. Number of ways a convex polygon of n+2 sides can split into triangles by connecting vertices
 *4. Number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
 *5. Number of different Unlabeled Binary Trees can be there with n nodes.
 *6. The number of paths with 2n steps on a rectangular grid from bottom left, i.e., (n-1, 0) to top right (0, n-1) that do not cross above the main diagonal.
 *7. Number of ways to insert n pairs of parentheses in a word of n+1 letters, e.g., for n=2 there are 2 ways: ((ab)c) or (a(bc)). For n=3 there are 5 ways, ((ab)(cd)), (((ab)c)d), ((a(bc))d), (a((bc)d)), (a(b(cd))).
 *8. Number of noncrossing partitions of the set {1, …, 2n} in which every block is of size 2. A partition is noncrossing if and only if in its planar diagram, the blocks are disjoint (i.e. don’t cross). For example,
 *   below two are crossing and non-crossing partitions of {1, 2, 3, 4, 5, 6, 7, 8, 9}.  The partition {{1, 5, 7},  {2, 3, 8}, {4, 6}, {9}} is crossing and partition {{1, 5, 7}, {2, 3}, {4}, {6}, {8, 9}} is non-crossing. 
 *9. Number of Dyck words of length 2n. A Dyck word is a string consisting of n X’s and n Y’s such that no initial segment of the string has more Y’s than X’s.  For example, the following are the Dyck words of length 6: XXXYYY     XYXXYY     XYXYXY     XXYYXY     XXYXYY.
 *10 Number of ways to tile a stairstep shape of height n with n rectangles. The following figure illustrates the case n = 4  
 *11 Number of ways to connect the points on a circle disjoint chords.  This is similar to point 3 above.
 *12 Number of ways to form a “mountain ranges” with n upstrokes and n down-strokes that all stay above the original line.The mountain range interpretation is that the mountains will never go below the horizon.
 *13 Number of stack-sortable permutations of {1, …, n}. A permutation w is called stack-sortable if S(w) = (1, …, n), where S(w) is defined recursively as follows: write w = unv where n is the largest element in w and u and v are shorter sequences, and set S(w) = S(u)S(v)n, with S being the identity for one-element sequences.
 *14 Number of permutations of {1, …, n} that avoid the pattern 123 (or any of the other patterns of length 3); that is, the number of permutations with no three-term increasing subsequence. For n = 3, these permutations are 132, 213, 231, 312 and 321. For n = 4, they are 1432, 2143, 2413, 2431, 3142, 3214, 3241, 3412, 3421, 4132, 4213, 4231, 4312 and 4321
 *   
*/