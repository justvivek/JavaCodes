//
//public class LinkedList {
//	static Node head, head1, head2;
//	
//	static class Node{
//		int data;
//		Node next;
//		Node(int d){
//			this.data = d;
//			next = null;
//		}
//	}
//	
//	//Print linked List
//	public void printlist() {
//		Node n = head;
//		while(n != null) {
//			System.out.print(n.data + " ");
//			n = n.next;
//		}
//	}
//	
//	//Split a Circular Linked List into two halves
//	public void splitlist() {
//		Node slow_ptr = head;
//		Node fast_ptr = head;
//		
//		if(head == null) {
//			return;
//		}
//		while(fast_ptr.next != head && fast_ptr.next.next != head) {
//			fast_ptr = fast_ptr.next.next;
//			slow_ptr = slow_ptr.next;
//		}
//		if(fast_ptr.next.next == head) {
//			fast_ptr = fast_ptr.next;
//		}
//		
//		head1= head;
//		
//		if(head1.next != head) {
//			head2 = slow_ptr.next;
//		}
//		fast_ptr.next = slow_ptr.next;
//		
//		slow_ptr.next = head;
//	}
//	
//	//Print Linked List
//	public void printLL(Node n) {
//		Node temp = n;
//		if (temp == null) {
//			System.out.println("Empty List");
//			return;
//		}
//		do {
//			System.out.print(temp.data + " ");
//			temp = temp.next;
//		}while(temp != null && temp != n);
//	}
////	public void deleteNodeRec(Node t, int key) {
//////		Node n = head;
////		if (t == null) {
////			return;
////		}
////		if (t.data == key) {
////			Node temp = t;
////			
////		}
////	}
//	
//	//Delete Node of Linked List
//	public void deleteNode(int key) {
//		Node n = head, prev_node = null;
//		if (n != null && n.data == key) {
//			head = head.next;
//			return;
//		}
//		while(n != null && n.data != key) {
//			prev_node = n;
//			n= n.next;
//		}
//		if(n == null) {
//			return;
//		}
//		prev_node.next = n.next;
//	}
//	
//	//Ad new Node to linked list at begining
//	public void push(int data) {
//		Node new_node = new Node(data);
//		new_node.next = head;
//		head = new_node;
//		
//	}
//	
//	//TO check whether list is Circular or not
//	public void isCircular() {
//		if (head == null) {
//			System.out.println("List is empty and Empty list is circular");
//			return;
//		}
//		Node temp = head.next;
//		while(temp != null && temp != head)
//			temp = temp.next;
//		if (temp == head)
//			System.out.println("list is circular");
//		else
//			System.out.println("List is not circular");
//	}
//	
//	//Covert Singly LL to Circular LL
//	public void sllToDll() {
//		if (head == null)
//			return;
//		Node prev = null;
//		Node temp = head.next;
//		while(temp != null && temp != head) {
//			prev = temp;
//			temp = temp.next;
//		}
//		if(temp == head)
//			System.out.println("List is already circular");
//		else {
//			prev.next = head;
//			System.out.println("List was not circular but now it is");
//		}
//	}
//	
//	//Insert Node in LL after given prev_node
//	public void insertAfter(Node prev_node, int data){
//		if (prev_node == null) {
//			System.out.println("Prev_node cannot be null");
//			return;
//		}
//		Node new_node = new Node(data);
//		
//		new_node.next = prev_node.next;
//		prev_node.next = new_node;
//	}
//	
//	//Append node to linked list
//	public void append(int data){
//		Node new_node = new Node(data);
//		new_node.next = null;
//		if(head == null) {
//			head = new_node;
//			return;
//		}
//		Node last = head;
//		while(last.next != null) {
//			last = last.next;
//		}
//		last.next = new_node;
//		return;
//	}
//	
//	public static void main(String[] args) {
//		LinkedList ll= new LinkedList();
//		
//		ll.head = new Node(5);
//		Node second = new Node(6);
//		Node third = new Node(10);
//		
//		ll.head.next = second;
//		second.next = third;
//		
//		ll.printlist();
//		ll.push(4);
//		ll.append(13);
//		System.out.println("");
//		ll.printlist();
//		ll.insertAfter(ll.head.next.next, 9);
//		System.out.println("");
//		System.out.println("After Insertion");
//		ll.printlist();
//		ll.printLL(head);
//		System.out.println("");
//		ll.isCircular();
//		ll.printlist();
//		ll.sllToDll();
//		ll.isCircular();
//		ll.sllToDll();
//		ll.splitlist();
//		System.out.println("");
//		ll.printLL(head);
//		System.out.println("");
//		ll.printLL(head1);
//		System.out.println("");
//		ll.printLL(head2);
////		ll.deleteNode(9);
////		System.out.println("");
////		System.out.println("After Deletion 9");
////		ll.printlist();
////		ll.deleteNode(4);
////		System.out.println("");
////		System.out.println("After Deletion 4");
////		ll.printlist();
////		ll.deleteNode(13);
////		System.out.println("");
////		System.out.println("After Deletion 13");
////		ll.printlist();
////		ll.deleteNode(4);
////		System.out.println("");
////		System.out.println("After Deletion 4");
////		ll.printlist();
//	}
//
//}
