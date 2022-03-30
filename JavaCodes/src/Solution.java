import java.util.*;
public class Solution {
	public static int[] demo() {
		return new int[]{1,2};
	}
	public static void main(String[] args) {
//		List<Deque<Integer>> l = new ArrayList<>();
//		l.add(new ArrayDeque<>());
//		l.get(0).push(10);
		Deque<int[]> dq = new ArrayDeque<>();
		int index =0;
		int[] asteriods = {-1,4,2,-5};
		for(int i: asteriods) {
			if(i>0) {
				int[] e = {i, index};
				dq.push(e);
			}
			else {
				while(!dq.isEmpty() && dq.peek()[0] > 0 && dq.peek()[0]< Math.abs(i)) {
					dq.pop();
				}
				if(dq.isEmpty() || dq.peek()[0]<0) {
					int e[] = {i, index};
					dq.push(e);
				}
				else if(i + dq.peek()[0] == 0)
					dq.pop();
			}
			index++;
		}
		
		class Node{
			Node a;
			int data;
		}
		Node ab = new Node();
		Node ac = new Node();
		Node[] narr = {ab, ac};
		int len = narr.length;
//		Map<int, char> mp1 = new HashMap<>(); //Invalid declaration
		Map<int[], char[]> mp = new HashMap<>();
		
		String str5 = "vivek";
		str5.charAt(4);
		char ch = 'a';
		String ds = null;
		str5 += ds;
		str5 +=ch;
		int[] res = new int[dq.size()];
		for(int i=res.length-1; i>=0; i--) {
			res[i]= dq.pop()[1];
		}
		for(int i : res) {
			System.out.print(i + "    ");
		}
		char[] arr = {'a', 'b','c'};
		arr[1] = 'd';
		System.out.println(arr);
		String str = "abc";
		char[] ch = str.toCharArray();
		System.out.println(ch);
		
		
		List<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(5);
//		int[] arr1= al.toArray(new int[al.size()]);
		
		List<List<Integer>> result1= new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		int[] a = {1,2};
		l.add(a[0]);
		l.add(a[1]);
		result1.add(l);
//		
		
//		Deque<> inr = new ArrayDeque<>();
		Deque<Character> d1 = new ArrayDeque<>();
//		String str = "abacbdebaghccciajbklb";
//		int[] arr = new int[26];
//		System.out.println(arr);
//		for(int i=0; i< str.length(); i++) {
//			System.out.print(arr[str.charAt(i) -'a']++ + " ");
//		}
//		System.out.print("\n");
//		for(int i=0; i< 26; i++) {
//			System.out.print(arr[i]+" ");
//		}
////		int a[] = {2,5,7,9,2,6,8};
////		for (int x: a) {
////			System.out.println("Iterating over Value " + x);
////		}
//		int[] crs = {1,2,3,4,5};
//		List<Integer> al = new ArrayList<>();
//		int[][] db = {{1,2},{0,2},{1,2}};
//		Set<Integer> set = new HashSet<>();
//		Map<Integer, List<Integer>> hm = new HashMap<>();
//		for(int i : crs) {
//			hm.put(i,  new ArrayList<>());
//		}
//		for(int[] p: db) {
//			List<Integer> l = hm.get(p[0]);
//			l.add(p[1]);
//			hm.put(p[0], l);
//		}
//		int b =(int)Math.pow(2,4);

	}
}
