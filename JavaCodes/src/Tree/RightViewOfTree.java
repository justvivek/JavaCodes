package Tree;

public class RightViewOfTree {
	Node root;
	static int visited_level =0;
	
	public void rightView(Node node, int level) {
		if(node == null)
			return;
		if(level > visited_level) {
			System.out.print(node.key+ " ");
			visited_level = level;
		}
		rightView(node.right, level+1);
		rightView(node.left, level+1);
	}
	
	public void rView() {
		rightView(root, 1);
	}
	
	public static void main(String[] args) {
		RightViewOfTree tree = new RightViewOfTree();
		tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(15);
        tree.root.right.left = new Node(12);
        tree.root.right.right.left = new Node(14);
//        tree.leftView(tree.root, 1);
        tree.rView();
	}
}
