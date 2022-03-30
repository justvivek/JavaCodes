 package Tree;

public class CheckBinaryTreeIsBST {
	Node root;
	static boolean isBST(Node root, int max, int min) {
		if(root == null)
			return true;
		if(root.key > max || root.key <= min)
			return false;
		
		return isBST(root.left, root.key, min) && isBST(root.right, max, root.key);
	}
	
	public static void main(String[] args) {
		CheckBinaryTreeIsBST tree = new CheckBinaryTreeIsBST();
		tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(25);
        tree.root.right.left = new Node(15);
        tree.root.right.right.left = new Node(22);
        System.out.println("Binary Tree is BST "+ isBST(tree.root, Integer.MAX_VALUE, Integer.MIN_VALUE));
	}
}
