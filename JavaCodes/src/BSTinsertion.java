import java.util.*;

//program to insert element in binary tree

public class BSTinsertion {
	static class Node{
		int key;
		Node left, right;
		Node(int data){
			key = data;
			left = right = null;
		}
	}
	static Node root;
	static Node temp = root;
	
	static void inorder(Node temp) {
		if (temp == null)
			return;
		inorder(temp.left);
		System.out.print(temp.key+ " ");
		inorder(temp.right);
	}
	static void insert(Node temp, int key) {
		if (temp == null) {
			root = new Node(key);
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);
		
		while(!q.isEmpty()) {
			temp = q.peek();
			q.remove();
			
			if(temp.left == null) {
				temp.left = new Node(key);
				return;
			}
			else
				q.add(temp.left);
			
			if(temp.right == null) {
				temp.right = new Node(key);
				return;
			}
			else
				q.add(temp.right);
		}
	}
	public static void main(String[] args) {
		root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20);
		root.left.left = new Node(3);
		root.right.right = new Node(29);
		root.right.left = new Node(25);
		System.out.println("Inorder Traversal of Binary tree ");
		inorder(root);
		insert(root, 12);
		System.out.println("\nInorder Traversal of Binary tree ");
		inorder(root);
	}
}
