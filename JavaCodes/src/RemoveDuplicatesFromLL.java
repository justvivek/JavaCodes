
public class RemoveDuplicatesFromLL {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){this.data = data; next = null;}
	}
	
	public void removeDuplicates(){
		Node curr = head;
		if(head == null || head.next == null)
			return;
		while(curr != null && curr.next != null) {
			if(curr.data == curr.next.data) {
				curr.next = curr.next.next;
			}
			else
				curr = curr.next;
		}
	}
	public void addElement(int d) {
		Node curr = head;
		if (head == null) {
			Node temp = new Node(d);
//			curr.data = d;
//			curr.next = null;
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
		RemoveDuplicatesFromLL ll = new RemoveDuplicatesFromLL();
		ll.addElement(10);
		ll.addElement(20);
		ll.addElement(30);
		ll.addElement(30);
		ll.addElement(40);
		ll.addElement(50);
		ll.addElement(60);
		ll.addElement(60);
		ll.addElement(70);
		ll.addElement(70);
		ll.addElement(90);
		ll.addElement(90);
		ll.addElement(90);
		ll.addElement(90);
		ll.printLL();
		ll.removeDuplicates();
		ll.printLL();
	}
}