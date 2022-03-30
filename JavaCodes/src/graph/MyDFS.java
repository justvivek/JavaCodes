package graph;
import java.util.Iterator;
import java.util.LinkedList;
public class MyDFS {
	
	private int V;
	private LinkedList<Integer> adjV[];
	private int wasVisited[];
	
	MyDFS(int v){
		V = v;
		adjV = new LinkedList[v];
		wasVisited = new int[v];
		for(int i=0; i<v; i++) {
			adjV[i] = new LinkedList();
			wasVisited[i] = 0;
		}	
	}
	
	void addEdge(int a, int b) {
		adjV[a].add(b);
	}
	
	void doDFS(int v) {
		wasVisited[v] = 1;
		System.out.print(v + " ");
		
		Iterator<Integer> itr = adjV[v].listIterator();
		while (itr.hasNext()) {
			int n = itr.next();
			if(wasVisited[n] == 0) {
				doDFS(n);
			}
		}
	}
	
	public static void main(String[] args) {
		MyDFS g1 = new MyDFS(4);
		
		g1.addEdge(0,1);
		g1.addEdge(0,2);
		g1.addEdge(1,2);
		g1.addEdge(2,0);
		g1.addEdge(2,3);
		g1.addEdge(2,2);
		g1.addEdge(3,3);
		g1.addEdge(3,2);
		
		System.out.println("Following is Depth First Traversal "
	            + "(starting from vertex 3)");
		
		g1.doDFS(3);
	}
	

}
