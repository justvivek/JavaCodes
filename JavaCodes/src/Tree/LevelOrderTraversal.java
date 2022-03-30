package Tree;
import java.util.*;
public class LevelOrderTraversal {
	Node root;
	public void levelOrderTraversal(Node node) {
		if(node == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()) {
			Node n= q.poll();
			System.out.print(n.key+ " ");
			if(n.left != null)
				q.add(n.left);
			if(n.right != null)
				q.add(n.right);
		}
		
//		Stack<Integer> s = new Stack<>();
//		s.add(1);
//		s.add(2);
//		System.out.println("\n" + s.peek());
//		HashSet<Integer> hs = new HashSet<>();
//		hs.add(1);
//		hs.add(10);
//		hs.add(11);
//		hs.add(12);
//		hs.add(13);
//		hs.add(14);
//		for(int i: hs)
//			System.out.println(i);
//		Map<Integer, String> mp = new HashMap<>();
//		mp.put(1, "ab");
//		mp.put(2,"dc");
//		mp.put(3,"bc");
//		mp.put(4,"cc");
//		mp.put(5,"ec");
//		Set<Integer> set = mp.keySet();
//		for(int i : set) {
//			System.out.print(i+ "   ");
//		}
//		Collection<String> str = mp.values();
//		String[] sa = str.toArray(new String[0]);
//		System.out.print("\n");
//		for(String st: sa) {
//			System.out.print(st+ " ");
//		}
//		System.out.println("\n"+str);
		
		
	}
	
	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.right.right = new Node(20);
		tree.root.right.right.left = new Node(10);
		tree.root.right.right.left.right = new Node(11);
		tree.root.right.right.left.right.right = new Node(12);
		tree.root.right.right.left.right.right.left = new Node(13);
		tree.root.right.right.left.right.right.right = new Node(30);
		System.out.println("Level Order traversal is");
        tree.levelOrderTraversal(tree.root);
	}
	
}
