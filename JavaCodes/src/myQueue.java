//class Queue{
//	int front, rear, size;
//	int capacity;
//	int arr[];
//	
//	public Queue(int capacity) {
//		this.capacity = capacity;
//		front = this.size = 0;
//		rear = capacity-1;
//		arr = new int[this.capacity];
//	}
//	
//	boolean isFull(Queue q) {
//		return (q.size == q.capacity );
//	}
//	
//	boolean isEmpty(Queue q) {
//		return(q.size ==0);
//	}
//	

//	void enqueue(int item){
//		if(isFull(this))
//			return;
//		this.rear = (this.rear +1)% this.capacity;
//		this.arr[this.rear] = item;
//		this.size += 1;
//		System.out.println(item + " enqueued to queue");
//	}
//	
//	public int dequeue() {
//		if (isEmpty(this))
//			return Integer.MIN_VALUE;
//		int item = this.arr[this.front];
//		this.front = (this.front + 1)% this.capacity;
//		this.size -= 1;
//		return item;
//	}
//	
//	public int front() {
//		if (isEmpty(this))
//			return Integer.MIN_VALUE;
//		return this.arr[this.front];
//	}
//	public int rear() {
//		if (isEmpty(this))
//			return Integer.MIN_VALUE;
//		return this.arr[this.rear];
//	}
//}
//public class myQueue {
//	public static void main(String[] args) {
//		Queue q = new Queue(1000);
//		q.enqueue(10);
//		q.enqueue(17);
//		q.enqueue(25);
//		q.enqueue(43);
//		//Printing all elements of queue
//		while(q.front <= q.rear){
//			int n= q.dequeue();
//			System.out.print(n + " ");
//		}
//	}
//}
