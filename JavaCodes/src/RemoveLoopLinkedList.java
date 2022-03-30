
public class RemoveLoopLinkedList {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){this.data = data; next= null;}
	}
	
	public void addElement(int d) {
		Node temp = new Node(d);
		if(head == null) {
			head = temp;
			return;
		}
		Node curr = head;
		while(curr.next != null) {
			curr= curr.next;
		}
		curr.next = temp;
	}
	
	public void findAndRemoveLoopinLL() {
		if(head == null || head.next == null)
			return;
		Node slow_ptr= head.next, fast_ptr= head.next.next;
		while(fast_ptr != null && fast_ptr.next != null) {
			if(slow_ptr == fast_ptr) {
				System.out.println("\nLoop Exist in LL");
				break;
			}
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		if(slow_ptr == fast_ptr) {
			slow_ptr = head;
			while(slow_ptr.next != fast_ptr.next) {
				slow_ptr = slow_ptr.next;
				fast_ptr = fast_ptr.next;
			}
			System.out.println("Removing Loop from LL between "+ fast_ptr.data + "-->"+ fast_ptr.next.data);
			fast_ptr.next = null;
			return;
		}
		System.out.println("\nNo loop in LL");
	}
	public void makeLoopInLL() {
		Node temp = head.next.next;
		Node curr = head;
		while(curr.next != null)
			curr = curr.next;
		curr.next = temp;
	}
	
	public void printLL() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data+ "-->");
			curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		RemoveLoopLinkedList ll = new RemoveLoopLinkedList();
		ll.addElement(10);
		ll.addElement(20);
		ll.addElement(30);
		ll.addElement(38);
		ll.addElement(40);
		ll.addElement(50);
		ll.addElement(60);
		ll.addElement(65);
		ll.addElement(70);
		ll.addElement(76);
		ll.addElement(90);
		ll.addElement(92);
		ll.addElement(94);
		ll.addElement(96);
		ll.printLL();
		ll.makeLoopInLL();
		ll.findAndRemoveLoopinLL();
		ll.printLL();
	}
}
