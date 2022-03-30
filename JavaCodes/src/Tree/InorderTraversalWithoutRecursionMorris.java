package Tree;

//Morris Traversal

//Inorder and Preorder traversal

//Time Complexity O(n)
//Space Complexity O(1)

public class InorderTraversalWithoutRecursionMorris {
	Node root;
	
	static void inorder(Node root) {
		Node curr = root;
		while(curr != null) {
			//left is null then print the node and go to right
			if(curr.left == null) {
				System.out.print(curr.key+ " ");
				curr = curr.right;
			}
			else {
				//find the predecessor
				Node predc = curr.left;
				//Keep going right till right node is not null or right node is not current
				while(predc.right != curr && predc.right != null)
					predc = predc.right;
				//if right node is null then go left after establishing link from predecessor to current
				if(predc.right == null) {
					predc.right = curr;
					curr = curr.left;
				}
				else {
					//left is already visited. Go right after visiting current
					predc.right = null;
					System.out.print(curr.key+ " ");
					curr = curr.right;
				}
			}
		}
	}

	//Preorder Traversal
	static void preorder(Node root) {
		Node curr = root;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.key + " ");
				curr = curr.right;
			}
			else {
				Node predc = curr.left;
				while(predc.right != null && predc.right != curr)
					predc = predc.right;
				if(predc.right == null) {
					predc.right = curr;
					System.out.print(curr.key + " ");
					curr = curr.left;
				}
				else {
					predc.right = null;
					curr = curr.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		InorderTraversalWithoutRecursionMorris tree = new InorderTraversalWithoutRecursionMorris();
		tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(15);
        tree.root.right.left = new Node(12);
        tree.root.right.right.left = new Node(14);
        System.out.println("Inorder Traversal of Binary Tree:- "); inorder(tree.root);
        System.out.println("\nPreorder Traversal of Binary Tree:- "); preorder(tree.root);
        
	}
}
