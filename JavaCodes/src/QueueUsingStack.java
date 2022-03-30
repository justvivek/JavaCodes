import java.util.*;
//Java program to implement Queue using
//two stacks with costly enQueue()
public class QueueUsingStack {
		static class m1Queue{
			static Stack<Integer> s1 = new Stack<Integer>();
			static Stack<Integer> s2 = new Stack<Integer>();
			//enQueue operation costly
			//time complexity will be O(n)
			static void enQueue(int x) {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
				s1.push(x);
				while(!s2.isEmpty()) {
					s1.push(s2.pop());
				}
			}
			//deQueue operation O(1)
			//time complexity will be O(1)
			static int deQueue() {
				if (s1.isEmpty()) {
					System.out.println("Q is empty");
//					System.exit(0);
					return Integer.MIN_VALUE;
				}
				return s1.pop();
			}
		}
		static class m2Queue{
			Stack<Integer> s1;
			Stack<Integer> s2;
		}
		
		static void push(Stack<Integer> s, int d) {
			s.push(d);
		}
		
		static int pop(Stack<Integer> s) {
			if(s.isEmpty()) {
				System.out.println("Stack is Underflow");
				System.exit(0);
			}
			return s.pop();
		}
		
		static void enQueue(m2Queue q, int d) {
			push(q.s1, d);
		}
		
		static int deQueue(m2Queue q) {
			int x;
			if (q.s1.isEmpty() && q.s2.isEmpty()) {
				System.out.println("Q is Empty");
				System.exit(0);
			}
			if(q.s2.isEmpty()) {
				while(!q.s1.isEmpty()) {
					x= pop(q.s1);
					push(q.s2, x);
//					push(q.s2, pop(q.s1));
				}
			}
			x= pop(q.s2);
			return x;
		}
		
		public static void main(String[] args) {
			m1Queue q = new m1Queue();
			q.enQueue(3);
			q.enQueue(6);
			q.enQueue(10);
//			q.enQueue(17);
			
			System.out.println(q.deQueue());
			System.out.println(q.deQueue());
			System.out.println(q.deQueue());
			System.out.println(q.deQueue());
			System.out.println("******************************");
			m2Queue q2= new m2Queue();
			q2.s1 = new Stack<>();
			q2.s2 = new Stack<>();
			enQueue(q2, 4);
			enQueue(q2, 7);
			enQueue(q2, 11);
			enQueue(q2, 18);
			System.out.print(deQueue(q2) + " ");
			System.out.print(deQueue(q2) + " ");
			System.out.print(deQueue(q2) + " ");
			System.out.print(deQueue(q2) + " ");
			System.out.print(deQueue(q2) + " ");
			
		}
}
