package Tree;
	
public class MaxPathSumClass {
	Node root;
	static int sum = 0;
	//compute max path sum without split
	static int dfs(Node node) {
		if(node == null)
			return 0;
		
		int leftMax = dfs(node.left);
		int rightMax = dfs(node.right);
		
		//
		leftMax = Math.max(leftMax, 0);
		rightMax = Math.max(rightMax, 0);
		
		//Compute max path sum without split
		sum = Math.max(sum, node.key+leftMax+rightMax);
		
		return node.key + Math.max(leftMax, rightMax);
	}
	
	static int maxPathSum(Node root) {
		dfs(root);
		return sum;
	}
	
	public static void main(String[] args) {
		MaxPathSumClass tree = new MaxPathSumClass();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(5);
        System.out.println("Maximum path sum is:- "+ maxPathSum(tree.root));
	}
}
