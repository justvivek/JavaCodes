
public class MergeSortedLL {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){this.data = data; next = null;}
	}
	
	public void mergeList(MergeSortedLL l1, MergeSortedLL l2) {
		Node cur1 = l1.head, cur2 = l2.head, cur3= new Node(0);
		if(cur1 == null && cur2 == null) {
			this.head= null;
			return;
		}
		if(cur1 == null) {
			this.head = l2.head;
			return;
		}
		if(cur2 == null) {
			this.head = l1.head;
			return;
		}
		this.head = cur3;
		while(cur1 != null && cur2 !=null) {
			if(cur1.data < cur2.data) {
				cur3.next = cur1;
				cur3 = cur3.next;
				cur1 = cur1.next;
			}
			else {
				cur3.next = cur2;
				cur3 = cur3.next;
				cur2 = cur2.next;
			}
		}
		if(cur1 == null && cur2 != null) {
			cur3.next = cur2;
		}
		if(cur1 != null && cur2 == null)
			cur3.next = cur1;
		this.head = this.head.next;	
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
		MergeSortedLL l1 = new MergeSortedLL();
		MergeSortedLL l2 = new MergeSortedLL();
		MergeSortedLL l3 = new MergeSortedLL();
		l2.addElement(10);
		l1.addElement(20);
		l1.addElement(30);
		l1.addElement(35);
		l1.addElement(40);
		l1.addElement(50);
		l1.addElement(60);
		l1.addElement(65);
		l1.addElement(70);
		l1.addElement(75);
		l1.addElement(90);
		l1.addElement(92);
		l1.addElement(96);
		l1.addElement(98);
		l1.printLL();
		l2.printLL();
		l3.mergeList(l1, l2);
		l3.printLL();
	}
}
