import java.util.*;

public class myStack {
	
	public static void main(String[] args) {
		Stack s1 = new Stack();
		
		Stack<String> s2 = new Stack<String>();
		
		s1.push(9);
		s1.push("Nine");
		s1.push(10);
		s1.push("Ten");
		
		s2.push("Vitamins");
		s2.push("SUPP");
		s2.push("abc");
		s2.push("efg");
		s2.push("twinkle");
		
		// Displaying the Stack
		System.out.println("Stack S1: "+ s1);
		System.out.println("Stack S2: " + s2);
		
		// Fetching the element at the head of the Stack
		System.out.println("Top element of stack S1 is : "+ s1.peek());
		System.out.println("Top element of stack S2 is : "+ s2.peek());
		// Displaying the Stack after peek operation
		System.out.println("Stack S1: "+ s1);
		System.out.println("Stack S2: "+ s2);
		
		// Removing elements using pop() method
		System.out.println("Popped element from S1: "+ s1.pop());
		System.out.println("Popped element from S2: "+ s2.pop());
		// Displaying the Stack after pop operation
		System.out.println("Stack S1: "+ s1);
		System.out.println("Stack S2: "+ s2);
		
		s2.add(2,"little");
		System.out.println("Stack S2: "+ s2);
		System.out.println("Stack S2 size: "+ s2.size());
		int n= s2.search("efg");
		if (s2.search("efgh") > 0)
//		if (n> 0)
			System.out.println("Object found at: "+ n);
		else
			System.out.println("Object not found in stack");
		
		if (!s1.empty())
			System.out.println("S1 is not empty, s1 contains "+ s1);
		else
			System.out.println("S1 is an empty stack");
		
		//Implementation of Stack using ArrayDeque
		Deque<Character> s3 = new ArrayDeque<Character>();
		s3.push('Z');
		s3.push('I');
		s3.push('P');
		System.out.println("S3 peek "+ s3.peek());
		System.out.println("S3 pop "+ s3.pop());
	}

}
