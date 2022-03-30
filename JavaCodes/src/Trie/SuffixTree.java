package Trie;

import java.util.*;

class SuffixTreeNode{
	static final int MAX_CHAR = 256;
	SuffixTreeNode[] snode;
	List<Integer> indexes;
	SuffixTreeNode(){
		snode = new SuffixTreeNode[MAX_CHAR];
		indexes = new LinkedList<>();
	}
	
	public void insert(String key, int index) {
		indexes.add(index);
		if(key.length() >0) {
			if(snode[key.charAt(0)] == null) {
				snode[key.charAt(0)] = new SuffixTreeNode();
			}
			snode[key.charAt(0)].insert(key.substring(1), index+1);
		}
	}
	
	public List<Integer> search(String key){
		if(key.length() == 0) return indexes;
		if(snode[key.charAt(0)] != null) 
		{
			return snode[key.charAt(0)].search(key.substring(1));
		}
		else
			return null;
	}
}
public class SuffixTree {
	SuffixTreeNode root;
	SuffixTree(String txt){
		root = new SuffixTreeNode();
		for(int i=0; i<txt.length(); i++) {
			root.insert(txt.substring(i), i);
		}
	}
	
	public void searchTree(String key) {
		List<Integer> ind = root.search(key);
		if(ind != null) {

			for(int i: ind) {
				System.out.println(i - key.length());
			}
//			Using stream We can perform same operation easily 
//			ind.stream().map(i -> i-key.length()).forEach(System.out::println);
		}
		else {
			System.out.println(" Not found ");
		}
	}
	
	public static void main(String[] args) {
		String str = "bananarepublickhanamana";
		SuffixTree tree = new SuffixTree(str);
		System.out.println("We have text "+ str);
		System.out.println("Search for na");
		tree.searchTree("na");
		
	}
}
