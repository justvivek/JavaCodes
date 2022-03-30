package Trie;

/*Trie is an efficient information reTRIEval data structure
 * Trie Insert and Search
 * */
public class ClassTrieInsertSearch {
	static final int ALPHABET_SIZE =26;
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		// isEndOfWord is true if the node represents end of a word
		boolean isEndofWord;
		TrieNode() {
			isEndofWord = false;
			for(int i=0; i<ALPHABET_SIZE; i++) {
				children[i] = null;
			}
		}
	}
	
	static TrieNode root;
	
	// If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
	static void insert(String key) {
		int level;
		int index;
		int len = key.length();
		TrieNode pCrawl = root;
		for(level=0; level<len; level++) {
			index = key.charAt(level) - 'a';
			if(pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isEndofWord = true;
	}
	
	/*Longest prefix matching – A Trie based solution
	 * Given a dictionary of words and an input string, 
	 * find the longest prefix of the string which is also a word in dictionary.
	 * */
	static String getMatchingPrefix(String key) {
		String result = "";
		int level, index;
		int len = key.length();
		TrieNode crawl = root;
		int prevmatch = 0;
		for(level=0; level< len; level++) {
			index = key.charAt(level) - 'a';
			if(crawl.children[index] != null) {
				crawl = crawl.children[index];
				if(crawl.isEndofWord) {
					prevmatch = level+1;
				}
			}
			else
				break;
		}
		result = key.substring(0, prevmatch);
		return result;
	}
	
	// Returns true if key presents in trie, else false
	static boolean search(String key) {
		int level;
		int index;
		int len = key.length();
		TrieNode pCrawl = root;
		
		for(level=0; level<len; level++) {
			index = key.charAt(level) - 'a';
			if(pCrawl.children[index] == null)
				return false;
			pCrawl = pCrawl.children[index];
		}
		return pCrawl.isEndofWord;
	}
	
	static boolean isEmpty(TrieNode root) {
		for(int i=0; i<ALPHABET_SIZE; i++) {
			if(root.children[i] != null)
				return false;
		}
		return true;
	}
	
	// Recursive function to Delete a key from given Trie
	static TrieNode remove(TrieNode root, String key, int depth) {
		// If trie is empty
		if(root == null)
			return null;
		
		// If last character of key is being processed
		if(depth == key.length()){
			// This node is no more end of word after
            // removal of given key
			if(root.isEndofWord)
				root.isEndofWord = false;
			// If given is not prefix of any other word
			if(isEmpty(root))
				root= null;
			return root;
		}
		// If not last character, recur for the child
        // obtained using ASCII value
		int index = key.charAt(depth) - 'a';
		root.children[index] = remove(root.children[index], key, depth+1);
		
		// If root does not have any child (its only child got
        // deleted), and it is not end of another word.
		if(isEmpty(root) && root.isEndofWord == false)
			root = null;
		return root;
	}
	
	public static void main(String[] args) {
		String[] keys = {"the", "a", "answer", "there", "any", "by", "bye", "their", "hero", "heroplane"};
		root = new TrieNode();
		for(int i=0; i< keys.length; i++) {
			insert(keys[i]);
		}
		if(search("there"))
			System.out.println("there ---> present in Trie");
		else
			System.out.println("there ---> not present in Trie");
		if(search("therea"))
			System.out.println("therea ---> present in Trie");
		else
			System.out.println("therea ---> not present in Trie");
		if(search("heroplane"))
			System.out.println("heroplane ---> present in Trie");
		else
			System.out.println("heroplane ---> not present in Trie");
		remove(root, "heroplane", 0);
		if(search("heroplane"))
			System.out.println("heroplane ---> present in Trie");
		else
			System.out.println("heroplane ---> not present in Trie");
		if(search("hero"))
			System.out.println("hero ---> present in Trie");
		else
			System.out.println("hero ---> not present in Trie");
		
		String s= getMatchingPrefix("answer");
		if(s.isEmpty()) {
			System.out.println("No Prefix Match Found");
		}
		else
			System.out.println("prefix match found in dictionary "+ s);
		
	}
}
