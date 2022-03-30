package Tree;

//Given a binary tree and a sum, find if there is a path from root to leaf which sums to this sum.

import java.util.ArrayList;
public class RootToLeafSum {
	Node root;
	 static boolean isRootToLeafSum(Node root, int sum, ArrayList<Integer> al) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null) {
			if(root.key == sum) {
				al.add(root.key);
				return true;
			}
			else
				return false;
		}
		if(isRootToLeafSum(root.left, sum-root.key, al)) {
			al.add(root.key);
			return true;
		}
		if(isRootToLeafSum(root.right, sum - root.key, al)) {
			al.add(root.key);
			return true;
		}
		return false;
	 }
	 static int sumLeafNode =0;
	 static void leafSum(Node root) {
		 if(root == null)
			 return;
		 if(root.left == null && root.right == null) {
			 sumLeafNode += root.key;
			 return;
		 }
		 if(root.left != null) leafSum(root.left);
		 if(root.right != null) leafSum(root.right);
	 }
	public static void main(String[] args) {
		RootToLeafSum tree = new RootToLeafSum();
		tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(15);
        tree.root.right.left = new Node(12);
        tree.root.right.right.left = new Node(14);
        int sum = 42;
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("Sum "+ sum +" is posible in Binary Tree:- "+  ((isRootToLeafSum(tree.root, sum, al)) ? al.toString(): " false"));
        leafSum(tree.root);
        System.out.println("Leaf Node Sum is:- "+ sumLeafNode);
        
	}
}
