////Implementing Stack using Arrays
// class Stack{
//	static int MAX = 1000;
//	static int top;
//	int a[] = new int[MAX];
//	Stack() {
//		top =-1;
//	}
//	
//	boolean isEmpty() {
//		return (top < 0);
//	}
//	
//	boolean push(int x) {
//		if (top >= (MAX-1)) {
//			System.out.println("STACK OVERFLOW");
//			return false;
//		}
//		else {
//			a[++top] = x;
//			System.out.println(x + " Pushed into stack");
//			return true;
//		}
//	}
//	
//	int pop() {
//		if (isEmpty()) {
//			System.out.println("STACK UNDERFLOW");
//			return Integer.MIN_VALUE;
//		}
//		else {
//			int x = a[top--];
//			return x;
//		}
//	}
//	
//	int peek() {
//		if (isEmpty()) {
//			System.out.println("STACK UNDERFLOW");
//			return Integer.MIN_VALUE;
//		}
//		else {
//			int x = a[top];
//			return x;
//		}
//	}
//	
//	void printStack() {
//		if (isEmpty()) {
//			System.out.println("Stack is Empty");
//		}
//		else {
//			for(int i =top; i>=0; i--)
//				System.out.print(a[i]+ " ");
//		}
//	}
//}
//public class StackUsingArray {
//	public static void main(String[] args) {
//		Stack s1 = new Stack();
//		s1.push(7);
//		s1.push(13);
//		s1.push(24);
//		s1.push(35);
//		System.out.println(s1.peek() + " is Top element ");
//		System.out.println(s1.pop() +" Popped from stack ");
//		s1.printStack();
//	}
//}
