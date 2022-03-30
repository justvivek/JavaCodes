package Tree;

import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;

public class VerticalOrderOfTree {
	Node root;
	
	public void getVerticalOrder(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> mp) {
		if(root == null)
			return;
		
		//get Array list at hd (Horizontal Distance)
		ArrayList<Integer> al = mp.get(hd);
		if(al == null) {
			al = new ArrayList<>();
			al.add(root.key);
		}
		else
			al.add(root.key);
		mp.put(hd, al);
		
		// Store nodes in left subtree
		getVerticalOrder(root.left, hd-1, mp);
		
		// Store nodes in right subtree
		getVerticalOrder(root.right, hd+1, mp);
	}
	
	public void printVerticalOrder(Node root) {
		
		// Create a map and store vertical order in map using function getVerticalOrder()
		TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();
		int horizontal_distance =0;
		getVerticalOrder(root, horizontal_distance, mp);
		
		// Traverse the map and print nodes at every horizontal distance (hd)
		for(Map.Entry<Integer, ArrayList<Integer>> itr: mp.entrySet())
			System.out.println(itr.getValue());
	}
	
	public static void main(String[] args) {
		VerticalOrderOfTree tree = new VerticalOrderOfTree();
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
		System.out.println("Vertical Order traversal is");
        tree.printVerticalOrder(tree.root);
	}
	
}
