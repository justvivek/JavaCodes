
//Circular Linked List
public class DoublyLinkedList {
	
	static class Node{
		int data;
		Node next;
	}
	
	static Node push(Node head_ref, int data){
		Node new_node = new Node();
		Node tmp = head_ref;
		new_node.data = data;
		new_node.next = head_ref;
		
		if(head_ref != null) {
			while(tmp.next != head_ref) {
				tmp = tmp.next;
			}
			tmp.next = new_node;
		}
		else
			new_node.next = new_node;
		head_ref = new_node;
		return head_ref;
	}
	
	static void printlist(Node head) {
		Node temp = head;
		if(temp != null) {
			do {
				System.out.print(temp.data + " " );
				temp = temp.next;
			}while (temp != head);
		}
	}
	
	
	/*This function returns true if given linked
	list is circular, else false. */
	static boolean isCircular(Node head) {
		if (head == null)
				return true;
		Node n = head.next;
		
		// This loop would stop in both cases (1) If
	    // Circular (2) Not circular
		while(n != null && n != head){
			n= n.next;
		}
		return(n == head);
	}
	//Count number of nodes in Circular LL
	static int countNodes(Node head) {
		if (head == null)
			return 0;
		int count = 0;
		Node n = head;
		do{
			n= n.next;
			count++;
		}while(n != head);
		return count;
	}
	
	//Sum of a nodes ofa Circular LL
	static int sumOfNodes(Node head) {
		if (head == null)
			return 0;
		int sum = 0;
		Node n = head;
		do {
			sum += n.data;
			n = n.next;
		}while(n != head);
		return sum;
	}
	
	public static void main(String[] args) {
		Node head = null;
		
		head = push(head, 4);
		head = push(head, 10);
		head = push(head, 16);
		head = push(head, 21);
		
		printlist(head);
		System.out.println(isCircular(head)? "Yes it's Circular linked list" : "It Not Circular linked list");
		System.out.println("No of nodes in this list is " + countNodes(head));
		System.out.println("Sum of nodes in this list is " + sumOfNodes(head));
	}

}
