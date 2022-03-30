package Tree;

class Node{
	int key;
	Node left, right;
	Node(int key){
		this.key = key;
		left = right = null;
	}
}
public class BinaryTree {
	Node root;
	
	BinaryTree(int d){
		root = new Node(d);
	}
	BinaryTree(){
		root = null;
	}
	
	void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.key + " " );
			printInorder(root.right);
		}
	}
	
	void printPostorder(Node root) {
		if (root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(root.key + " " );
		}
	}
	
	void printPreorder(Node root) {
		if (root != null) {
			System.out.print(root.key + " " );
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(5);
		bt.root.right = new Node(20);
		
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(7);
		System.out.println("Preorder");
		bt.printPreorder(bt.root);
		System.out.println("\nInorder");
		bt.printInorder(bt.root);
		System.out.println("\nPostorder");
		bt.printPostorder(bt.root);
	}

}
