package CollectionsExamples;

import java.util.*;

public class MinMaxHeap {
	public static void main(String[] args) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		minHeap.offer(40);
		minHeap.offer(900);
		minHeap.offer(20);
		minHeap.offer(300);
//		minHeap.offer(600);
//		minHeap.offer(10);
		
		System.out.println(minHeap);
		System.out.println(minHeap.poll());
		System.out.println(minHeap);
		
		Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.offer(40);
		maxHeap.offer(900);
		maxHeap.offer(20);
		maxHeap.offer(300);
		System.out.println(maxHeap);
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap);
	}
}
