package myHashMap;

import java.util.SortedMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;

public class SortedMapDemo {
	
	public static void main(String[] args) {
		SortedMap<Integer, String> sm1= new TreeMap<Integer, String>();
		
		sm1.put(5, "Lakhan");
		sm1.put(4, "is");
		sm1.put(3, "name");
		sm1.put(2, "My");
		sm1.put(1, "Yes");
		
		//iterate through SortedMap
		for(Map.Entry melement: sm1.entrySet()) {
			System.out.println(melement.getKey() + ": "+ melement.getValue());
		}
		
		System.out.println(sm1);
		
		// Using iterator in SortedMap
		Set s = sm1.entrySet();
		
		Iterator i = s.iterator();
		// Traversing map. Note that the traversal
        // produced sorted (by keys) output .
		while(i.hasNext()) {
			Map.Entry e = (Map.Entry)i.next();
			int key = (Integer)e.getKey();
			String str = (String)e.getValue();
			System.out.println(key + ": "+ str);
		}
		
		//Objects are stored in sorted, ascending order
		//But we can also store in descending order by passing a comparator.
		
		SortedMap<String, String> sm2 = new TreeMap<String, String>(new Comparator<String>() {
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		
		sm2.put("India", "1");
		sm2.put("Canada", "2");
		sm2.put("US", "3");
		sm2.put("SA", "4");
		
		System.out.println(sm2);
		
		
	}

}
