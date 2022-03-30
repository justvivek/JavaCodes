import java.util.*;
public class DLL {
	Node head;
	
	class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public void printlist(Node n) {
		Node temp = n;
		if (n == null) {
			System.out.println("List is empty");
		}
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}while(temp != null);
	}
	
	public void push(int key) {
		Node new_node = new Node(key);
		new_node.next = head;
//		new_node.prev = null;
		
		if(head != null) {
			head.prev = new_node;
		}
		head = new_node;
	}
	
	public void append(int key) {
		Node new_node = new Node(key);
		
		Node temp = head;
		if (head == null) {
			head = new_node;
			return;
		}
		while(temp.next != null) {
				temp = temp.next;
		}
		temp.next = new_node;
		new_node.prev = temp;
		
	}
	
	/* Given a node as prev_node, insert
    a new node after the given node */
	public void insetAfter(Node prev_node, int key) {
		if(prev_node == null) {
			System.out.println("Prev Node cannot be Null");
			return;
		}
		Node new_node = new Node(key);
		new_node.next = prev_node.next;
		new_node.prev = prev_node;
		prev_node.next = new_node;
		
		if(new_node.next !=null)
			new_node.next.prev = new_node;
	}
	
	public void delete(Node del) {
		if(head == null || del == null) {
			System.out.print("\nNode is null");
			return;
		}
		if (head == del)
			head = del.next;
		// Change prev only if node to be deleted
        // is NOT the first node	
		if (del.prev != null)
			del.prev.next = del.next;
		// Change next only if node to be deleted
        // is NOT the last node
		if (del.next != null)
			del.next.prev = del.prev;
		return;
	}
	
	/* Function to reverse a Doubly Linked List */
	public void reverse() {
		Node temp =null;
		Node current = head;
		while(current != null){
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if (temp != null) {
			head = temp.prev;
		}	
	}
	
	/* Function to reverse a Doubly Linked List using Stacks
     */
	public void reverseS() {
		Stack stack = new Stack();
		Node temp = head;
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		
		temp = head;
		while(temp != null) {
			temp.data = stack.pop();
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		DLL dll = new DLL();
		dll.append(1);
		dll.push(5);
		dll.push(9);
		dll.push(27);
		dll.append(56);
		dll.push(86);
		dll.push(93);
		dll.printlist(dll.head);
		dll.append(100);
		System.out.println("");
		dll.printlist(dll.head);
		dll.insetAfter(dll.head.next.next, 49);
		System.out.println("");
		dll.printlist(dll.head);
		dll.insetAfter(dll.head.next.next.next.next.next.next.next, 102);
		System.out.println("");
		dll.printlist(dll.head);
		dll.delete(dll.head);
		System.out.println("\nhead deleted");
		dll.printlist(dll.head);
		dll.delete(dll.head.next.next);
		System.out.println("\n49 Node deleted");
		dll.printlist(dll.head);
		dll.delete(dll.head.next.next.next.next.next.next.next);
		System.out.println("\nlast node deleted");
		dll.printlist(dll.head);
		dll.delete(dll.head.next.next.next.next.next.next.next);
		System.out.println("\nnull node deleted");
		dll.printlist(dll.head);
		dll.reverse();
		System.out.println("\nReversed Linked List");
		dll.printlist(dll.head);
		dll.reverseS();
		System.out.println("\nReversed Linked List");
		dll.printlist(dll.head);
	}

}
