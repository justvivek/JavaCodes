package myHashMap;
import java.util.*;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<Integer, String> mp1 = new HashMap<Integer, String>();
		
		mp1.put(100,"ruk");
		mp1.put(1000,"arrey");
		mp1.put(10000,"baba");
		mp1.put(100000,"ruk");
		
		System.out.println(mp1);
		
		Map<String, Integer> mp2 = new HashMap<String, Integer>();
		mp2.put("kasam", 100);
		mp2.put("ki", 100);
		mp2.put("kasam", 200);
		mp2.put("hai", 100);
		mp2.put("kasam", 300);
		mp2.put("se", 100);
		
		System.out.println(mp2);
		
		mp1.remove(100000);
		mp2.remove("kasam");
		
		System.out.println(mp1);
		System.out.println(mp2);
		
		mp1.put(100000, "baba");
		mp2.put("hai", 500 );
		
		System.out.println(mp1);
		System.out.println(mp2);
		
		//Iterating through the Map
		for(Map.Entry<String, Integer> mapelement : mp2.entrySet()) {
			System.out.println(mapelement.getKey() + ": "+ mapelement.getValue());
		}
		
		//Java Program to illustrate the LinkedHashmap Class
		//LinkedHashMap is just like HashMap with an additional feature of maintaining an order of elements inserted into it.
		Map<String, Integer> mp3 = new LinkedHashMap<>();
		mp3.put("Vishal", 200);
		mp3.put("Sachin", 300);
		mp3.put("Vaibhav", 600);
		System.out.println("LinkedHashMap Iteration");
		for(Map.Entry<String, Integer> mapE : mp3.entrySet()) {
			System.out.println(mapE.getKey() + ": "+ mapE.getValue());
		}
		//Java Program to illustrate the Treemap Class
		//The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, 
		//depending on which constructor is used
		Map<String, Integer> mp4 = new TreeMap<>();
		mp4.put("Vishal", 200);
		mp4.put("Sachin", 300);
		mp4.put("Vaibhav", 600);
		System.out.println("TreeMap Iteration");
		for(Map.Entry<String, Integer> mapE : mp4.entrySet()) {
			System.out.println(mapE.getKey() + ": "+ mapE.getValue());
		}
	}
}
