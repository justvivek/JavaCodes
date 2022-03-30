package Tree;
//Lowest Common Ancestor in Binary Search Tree
public class LowestCommonAncestor {
	Node root;
	public static Node LCA(Node node, int a, int b) {
		if(node == null)
			return null;
//		if(node.key> a && node.key >b)
//			return LCA(node.left, a, b);
//		else if(node.key< a && node.key <b)
//			return LCA(node.right, a, b);
		if(node.key > Math.max(a, b))
			return LCA(node.left, a, b);
		else if(node.key < Math.min(a,b))
			return LCA(node.right, a, b);
		else
			return node;
	}
	public static void main(String[] args) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(10);
		tree.root.left = new Node(-10);
		tree.root.right = new Node(30);
		tree.root.left.right = new Node(8);
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.right = new Node(9);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(60);
		tree.root.right.left.right = new Node(28);
		tree.root.right.right.right = new Node(78);
		Node ans = LCA(tree.root, 60, 28);
		System.out.println(ans.key);
		
	}
}
