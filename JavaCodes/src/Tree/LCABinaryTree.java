package Tree;
//Lowest Common Ancestor in Binary Tree
public class LCABinaryTree {
	Node root;
	public static Node lcaBT(Node node, int a, int b) {
		if (node == null)
			return null;
		if(node.key == a || node.key == b)
			return node;
		Node left = lcaBT(node.left, a,b);
		Node right = lcaBT(node.right,a,b);
		if(left != null && right != null)
			return node;
		if(left == null && right == null)
			return null;
		return (left != null) ? left: right;
	}
	public static void main(String[] args) {
		LCABinaryTree tree = new LCABinaryTree();
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
//		tree.root.right.right.left = new Node(10);
//		tree.root.right.right.left.right = new Node(11);
//		tree.root.right.right.left.right.right = new Node(12);
//		tree.root.right.right.left.right.right.left = new Node(13);
//		tree.root.right.right.left.right.right.right = new Node(30);
//		System.out.print("LCA of Binary Tree is:- ");
        Node n = lcaBT(tree.root, 8,20);
        System.out.print("LCA of Binary Tree is:- " + n.key);
	}
}
