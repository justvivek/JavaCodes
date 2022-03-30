
public class MinHeap {
	int heap[];
	int size;
	int capacity;
	
	MinHeap(int capacity){
		this.capacity = capacity;
		this.size = 0;
		
		heap = new int[capacity];
	}
	int parent(int pos) {
		return (pos-1)/2;
	}
	
	int leftChild(int pos) {
		return (2*pos+1);
	}
	
	int rightChild(int pos) {
		return (2*pos+2);
	}
	
	void swap(int fpos, int rpos) {
		int temp = heap[fpos];
		heap[fpos] = heap[rpos];
		heap[rpos] = temp;
	}
	
	boolean isleaf(int pos) {
		if (pos > size/2 && pos <= size)
			return true;
		return false;
	}
	
	void minHeapify(int pos) {
		if(!isleaf(pos)) {
			if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
				if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				}
				else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}
	
	void insert(int element) {
		if(size>= capacity) {
			return;
		}
		heap[size++] = element;
		int current = size-1;
		while(heap[current]< heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	void decreaseKey(int pos, int new_val) {
		heap[pos] = new_val;
		int current = pos;
		while(current != 0 && heap[parent(current)] > heap[current]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	// Method to remove minimum element (or root) from min heap
	int extractMin() {
		if (size <= 0)
			return Integer.MAX_VALUE;
		if(size == 1) {
			size--;
			return heap[size];
		}
		int min = heap[0];
		heap[0]= heap[size-1];
		size--;
		minHeapify(0);
		return min;
	}
	
    public void print()
    {
        for (int i = 0; i < size/2; i++) {
 
            // Printing the parent and both childrens
        	if(2*i + 2 <size) {
            System.out.print(
                " PARENT : " + heap[i]
                + " LEFT CHILD : " + heap[2 * i + 1]
                + " RIGHT CHILD :" + heap[2 * i + 2]);
        	}
        	else if(2*i + 1 < size) {
        		System.out.print(
                        " PARENT : " + heap[i]
                        + " LEFT CHILD : " + heap[2 * i + 1]);
        	}
        	else {
        		System.out.print(
                        " PARENT : " + heap[i]);
        	}
            // By here new line is required
            System.out.println();
        }
    }
    
    public static void main(String[] arg)
    {
 
        // Display message
        System.out.println("The Min Heap is ");
 
        // Creating object opf class in main() methodn
        MinHeap mh = new MinHeap(15);
 
        // Inserting element to minHeap
        // using insert() method
 
        // Custom input entries
        mh.insert(5);
        mh.insert(3);
        mh.insert(17);
        mh.insert(10);
        mh.insert(84);
        mh.insert(19);
        mh.insert(6);
        mh.insert(22);
        mh.insert(9);
 
        // Print all elements of the heap
        mh.print();
 
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                           + mh.extractMin());
        mh.print();
    }
}
