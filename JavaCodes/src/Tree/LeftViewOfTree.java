package Tree;

/*// Class Node there in package Tree
 * class Node{
	int key;
	Node left, right;
	Node(int key){
		this.key = key;
		left = right = null;
	}
	}
*/
public class LeftViewOfTree {
	Node root;
	static int level_visited = 0;
	public void leftView(Node node, int level) {
		if(node == null)
			return;
		if(level > level_visited) {
			System.out.print(node.key + " ");
			level_visited = level;
		}
		leftView(node.left, level+1);
		leftView(node.right, level+1);
	}
	
	public void lview() {
		leftView(root,1);
	}
	
	public static void main(String[] args) {
		LeftViewOfTree tree = new LeftViewOfTree();
		tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(15);
        tree.root.right.left = new Node(12);
        tree.root.right.right.left = new Node(14);
        tree.leftView(tree.root, 1);
//        tree.lview();
	}
}
