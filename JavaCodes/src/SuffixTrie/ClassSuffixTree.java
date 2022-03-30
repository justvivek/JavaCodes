package SuffixTrie;

import java.util.LinkedList;
import java.util.List;

class SuffixTrieNode{
	static final int MAX_CHAR = 256;
	SuffixTrieNode[] ch = new SuffixTrieNode[MAX_CHAR];
	List<Integer> indexes;
	SuffixTrieNode() {
		indexes = new LinkedList<Integer>();
		for(int i=0; i<MAX_CHAR; i++) {
			ch[i] = null;
		}
	}
	
	void insertSuffix(String s, int index) {
		
		indexes.add(index);
		
		if(s.length()> 0) {
			char cIndex = s.charAt(0);
			if(ch[cIndex] == null)
				ch[cIndex] = new SuffixTrieNode();
			ch[cIndex].insertSuffix(s.substring(1), index+1);
		}
	}
	
	List<Integer> search(String s){
		if(s.length() == 0)
			return indexes;
		if(ch[s.charAt(0)] != null) {
			return ch[s.charAt(0)].search(s.substring(1));
		}
		else
			return null;
	}
}

public class ClassSuffixTree {
	SuffixTrieNode root= new SuffixTrieNode();
	
	ClassSuffixTree(String txt){
		for(int i=0; i<txt.length(); i++) {
			root.insertSuffix(txt.substring(i), i);
		}
	}
	
	void searchTree(String pat) {
		List<Integer> result = root.search(pat);
		if(result == null) {
			System.out.println("Pattern Not found");
		}
		else {
			int patLen = pat.length();
			for(Integer i: result)
				System.out.println("Pattern found at index "+ (i - patLen));
		}
	}
	
	public static void main(String[] args) {
		String txt = "bananarepublickhanamana";
		ClassSuffixTree obj = new ClassSuffixTree(txt);
		
		System.out.println("Search for na");
		obj.searchTree("na");
		
	}
	
}
