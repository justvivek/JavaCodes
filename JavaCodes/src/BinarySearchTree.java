
public class BinarySearchTree {

	class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	Node root;
	BinarySearchTree(){
		root = null;
	}
	
	void insert(int key) {
		root = insertRec(root, key);
	}
	
	Node insertRec(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}
		if(data < root.key) {
			root.left = insertRec(root.left, data);
		}
		else if(data >root.key) {
			root.right = insertRec(root.right, data);
		}
		return root;
	}
	
	void delete(int key) {
		root = deleteRec(root, key);
	}
	
	Node deleteRec(Node root, int key) {
		if (root == null)
			return root;
		if(key < root.key) {
			root.left = deleteRec(root.left, key);
		}else if(key > root.key) {
			root.right = deleteRec(root.right, key);
		}
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			root.key = inOrderSuccessor(root.right);
			root.right = deleteRec(root.right, root.key);
		}
		return root;
	}
	
	int inOrderSuccessor(Node root) {
		int min = root.key;
		while(root.left != null) {
			min = root.left.key;
			root = root.left;
		}
		return min;
	}
	
	void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(5);
		bst.insert(15);
		bst.insert(40);
		bst.insert(25);
		System.out.println("Inorder Traversal of BST	");
		bst.inorder(bst.root);
		bst.delete(15);
		System.out.println("\nInorder Traversal of BST	");
		bst.inorder(bst.root);
		
	}
}
