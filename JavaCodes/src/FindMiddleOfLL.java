

public class FindMiddleOfLL {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){this.data = data; next = null;}
	}
	//USING CONCEPT OF SLOW PTR AND FAST PTR TO FIND CENTRE OF LINKED LIST
	public Node findMiddle(){
		Node slow_ptr = head, fast_ptr = head;
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		while(fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		return slow_ptr;
	}
	public void addElement(int d) {
		Node curr = head;
		if (head == null) {
			Node temp = new Node(d);
			head = temp;
			return;
		}
		while(curr.next != null)
			curr = curr.next;
		Node temp = new Node(d);
		curr.next = temp;
	}
	
	public void printLL() {
		Node curr =head;
		System.out.print("\n");
		while(curr != null) {
			System.out.print(curr.data+ "-->");
			curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		FindMiddleOfLL ll = new FindMiddleOfLL();
		ll.addElement(10);
		ll.addElement(20);
		ll.addElement(30);
		ll.addElement(35);
		ll.addElement(40);
		ll.addElement(50);
		ll.addElement(60);
		ll.addElement(65);
		ll.addElement(70);
		ll.addElement(72);
		ll.addElement(90);
		ll.addElement(92);
		ll.addElement(94);
		ll.addElement(96);
		ll.printLL();
		Node result = ll.findMiddle();
		if(result != null)
			System.out.println("\nMiddle element of Linked list is "+ result.data);
		else
			System.out.println("\nList is Empty");
	}
}
