package basetest.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.Vector;
import java.util.function.Consumer;

import org.apache.poi.util.SystemOutLogger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;;

public class CollectionTest {
	
	public static void main(String...args) {
		LinkedList<Integer> testList = new LinkedList<>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		
		//Below methods operate on first/head end of Dqueue
		//testList.addFirst(12);
		//testList.offerFirst(13);
		//testList.push(14);

		//System.out.println(testList.element());
		//System.out.println(testList.peek());
		//System.out.println(testList.get(0));
		//System.out.println(testList.poll());
		//System.out.println(testList.remove());
		//testList.pop();

		//System.out.println(testList.getFirst());
		//System.out.println(testList.peekFirst());
		//System.out.println(testList.get(0));
		//System.out.println(testList.pollFirst());
		//System.out.println(testList.removeFirst());
		
		//Below methods operate on last/tail end of Dqueue
		//testList.add(11);
		//testList.offer(12);
		//testList.addLast(13);
		//testList.offerLast(14);

		//System.out.println(testList.getLast());
		//System.out.println(testList.peekLast());
		//System.out.println(testList.get(testList.size() - 1));
		//System.out.println(testList.pollLast());
		//System.out.println(testList.removeLast());
		
		//System.out.println("++++++++++++++++");
		//testList.forEach(System.out::println);
		
		//ArrayList<Integer> al1 = new ArrayList<>();
		//al1.add(1);
		//al1.add(2);
		//al1.add(3);
		//al1.forEach(new Consumer<Integer>() {
		//	@Override
		//	public void accept(Integer t) {
		//		System.out.println(t);
		//	}
		//});
		
		//HashSet<String> hs1;
		//LinkedHashSet<String> lhs1;
		
		//HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		//hm1.put("A", 5);
		//hm1.put("C", 3);
		//hm1.put("B", 2);
		//hm1.put("E", 1);
		//hm1.put("D", 4);
		//hm1.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
		//Iterator<Map.Entry<String, Integer>> it1 = hm1.entrySet().iterator();
		//ListIterator<Map.Entry<String, Integer>> lit1 = new ArrayList<Map.Entry<String, Integer>>(hm1.entrySet()).listIterator();
		//Vector<String> v1 = new Vector<String>();
		//Enumeration<String> en1 = v1.elements();
		//Spliterator<Map.Entry<String, Integer>> sit1 = hm1.entrySet().spliterator();
		//sit1.forEachRemaining(e -> System.out.println(e.getKey()));
		//List<String> make = new ArrayList<String>();
		
		/*
		TreeMap<Integer, String> tm1 = new TreeMap<Integer, String>(new Comparator<Integer>( ) {
			public int compare(Integer i, Integer j) {
				return (i - j);
			}
		});
		tm1.put(1, "Abc");
		tm1.put(3, null);
		tm1.put(5, null);
		tm1.put(7, null);
		tm1.put(9, null);
		tm1.put(2, null);
		tm1.put(4, null);
		tm1.put(6, null);
		tm1.put(8, null);
		tm1.put(0, null);
		System.out.println(tm1.ceilingKey(2) + "  " + tm1.higherKey(2));
		System.out.println(tm1.floorKey(0) + "  " + tm1.lowerKey(0));
		HashMap<Integer, String> hm2 = new HashMap<Integer, String>();
		hm2.put(null, "A");
		System.out.println(hm2);
		*/
		
		
		ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();
		class Box { private String boxName; public Box() {} public Box(String boxName) {this.boxName = boxName;} public String getBoxName() {return boxName; } public void setBoxName(String boxName) { this.boxName = boxName; }} 
		ConcurrentSkipListMap<Box, Integer> cslm = new ConcurrentSkipListMap<>(new Comparator<Box>() { public int compare(Box b1, Box b2) { return b2.getBoxName().compareTo(b1.getBoxName());}});
		cslm.put(new Box("C"), 2);
		cslm.put(new Box("A"), 0);
		cslm.put(new Box("I"), 8);
		cslm.put(new Box("J"), 9);
		cslm.put(new Box("B"), 1);
		cslm.put(new Box("D"), 3);
		cslm.put(new Box("G"), 6);
		cslm.put(new Box("H"), 7);
		cslm.put(new Box("E"), 4);
		cslm.put(new Box("F"), 5);
		cslm.forEach((key, value) -> System.out.println(key.getBoxName()));
		
		
		
		
		
		
		
		
		
		
	}
}


