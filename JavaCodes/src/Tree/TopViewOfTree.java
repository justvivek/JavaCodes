package Tree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/*
class Node{
	int key;
	Node left, right;
	Node(int key){
		this.key = key;
		left = right = null;
	}
}
*/
/*The idea is to do something similar to vertical Order Traversal. Like vertical Order Traversal, 
 * we need to put nodes of same horizontal distance together. We do a level order traversal so that
 * the topmost node at a horizontal node is visited before any other node of same horizontal distance
 * below it. Hashing is used to check if a node at given horizontal distance is seen or not. 
 * */

public class TopViewOfTree {
	Node root;
	public void topView(Node root) {
		class QueueObj{
			Node node;
			int hd;
			QueueObj(Node node, int hd){
				this.node = node;
				this.hd = hd;
			}
		}
		
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		q.add(new QueueObj(root, 0));
		//topViewMap tvm
		Map<Integer, Node> tvm = new TreeMap<Integer, Node>();
		
		while(!q.isEmpty()) {
			QueueObj tmp = q.poll();
			if(!tvm.containsKey(tmp.hd)) {
				tvm.put(tmp.hd, tmp.node);
			}
			if(tmp.node.left != null) {
				q.add(new QueueObj(tmp.node.left, tmp.hd -1));
			}
			if(tmp.node.right != null) {
				q.add(new QueueObj(tmp.node.right, tmp.hd +1));
			}
		}
		
		for(Map.Entry<Integer, Node> entry: tvm.entrySet()) {
			System.out.print(entry.getValue().key + " ");
		}
	}
	
	public static void main(String[] args) {
		TopViewOfTree tree = new TopViewOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.topView(tree.root);
	}
	
}
