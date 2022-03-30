
public class StackUsingLL {
	
	StackNode root;
	
	class StackNode{
		int data;
		StackNode next;
		
		StackNode(int data){
			this.data = data;
		}
	}
	
	public boolean isEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}
	
	public void push(int key) {
		StackNode new_node = new StackNode(key);
		if(root == null)
			root = new_node;
		else {
			new_node.next = root;
			root = new_node;
		}
	}
	public int peek() {
		if (root == null)
			return Integer.MIN_VALUE;
		else
			return root.data;
	}
	public int pop() {
		int popped = Integer.MIN_VALUE;
		if (root == null) {
			System.out.println("Stack is empty");
		}
		else {
			popped = root.data;
			root = root.next;
		}
		return popped;
	}
	
	public void printStack() {
		StackNode temp = root;
		if (temp == null) {
			System.out.println("Stack is Empty");
			return;
		}
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		StackUsingLL sll = new StackUsingLL();
		
		sll.push(13);
		sll.push(17);
		sll.push(24);
		sll.push(27);
		sll.push(32);
		sll.printStack();
		System.out.println("");
		System.out.println("Popped element is "+ sll.pop());
		sll.printStack();
		System.out.println("");
		System.out.println("Peeking at Stack "+ sll.peek());
		sll.printStack();
		System.out.println("");
		System.out.println("Popped element is "+ sll.pop());
		sll.printStack();
	}
}
