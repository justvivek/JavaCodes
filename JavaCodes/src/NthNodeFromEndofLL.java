
public class NthNodeFromEndofLL {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){this.data = data; next = null;}
	}
	
	public Node NthNodeFromEnd(int n){
		Node curr = head, nth_node = head;
		if(head == null || n<1 )
			return null;
		int i=1;
		while(i != n && nth_node != null) {
			nth_node = nth_node.next;
			i++;
		}
		if(nth_node == null) {
			return null;
		}
		while(nth_node.next !=null) {
			curr = curr.next;
			nth_node = nth_node.next;
		}
		return curr;
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
		NthNodeFromEndofLL ll = new NthNodeFromEndofLL();
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
		Node result = ll.NthNodeFromEnd(15);
		if(result != null)
			System.out.println("\n4th Node from End is "+ result.data);
		else
			System.out.println("\nThere is no node at this location");
	}
}
