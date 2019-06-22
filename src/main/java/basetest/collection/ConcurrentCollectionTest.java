/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.collection;

import java.lang.Iterable; //Iterface which made collections iterable and allow enhance for loop
import java.util.Collection; //Parent interface of all collection Interfaces and Classes

import java.util.List; //Provide linear and dynamic array feature
import java.util.ArrayList; //Implementation of List Interface

import java.util.Set; //Provide dynamic list of unique elements
import java.util.HashSet; //Hashing based implementation of Set
import java.util.LinkedHashSet; //Extended from HashSet and provide insertion order unique collection

import java.util.SortedSet; //Interface to provided sorted collection based upon implementation of Comparable and Comparator interfaces
import java.util.TreeSet; //Implemenation of SortedSet and NavigableSet

import java.util.Queue; //Iterface to provde queue data structure
import java.util.Random;
import java.util.Deque; //Extends Queue and provide duble ended queue data structure where element can be added/removed from both end
import java.util.LinkedList; //Implemenation of List and Deque based on element linking technique behaves like List, Queue, Dequeue and Stack
import java.util.ArrayDeque; //Resizable array based implementation of Dequeue behaves like Queue, Dequeue, and Stack. Faster than LinkedList
import java.util.PriorityQueue; //Unbounded Queue based on priority heap. Does not permit null as element, object must be type of Comparable, in natural order as Comparable implemented

import java.util.Map;
import java.util.HashMap; //It is a hashing based Map implementation which stores the Key and Value pair and provide functionality to deal with Key and Value
import java.util.LinkedHashMap; //This class extends HashMap and provide linked list based Map implementation. It provides all feature like HashMap with insertion order
import java.util.SortedMap; //This interface extends Map interface and provide methods for backed Map and other sorted methods
import java.util.TreeMap; //It is implementation of NavigableMap, and SortedMap interface which provide sorted map based upon Comparable and Comparator interface

import java.util.Vector; //Legacy dynamic list like ArrayList with properties like: legacy, methods are synchronized, provide enumration based iteration
import java.util.Dictionary;
import java.util.Hashtable; //Legacy hashing based class to Provide key, value storage like Map, with properties like: legacy class, methods are sysnchronized, store no null value in key or value, provide enumration based iteration
import java.util.Stack;

import java.util.Iterator; //It proves a way for iterating over collections, also provde remove method for removing the element
import java.util.ListIterator; //Extends Iterator and provide reverse iteration over collections

import java.util.Collections; //Provide Utils for Collection
import java.util.Arrays; //Provide Utils for Arrays
import java.util.Enumeration;
import java.util.NavigableMap; 
import java.util.NavigableSet; //Backed Collection - Means if any changes made on this, changes reflect in original collection from which it made

import java.util.concurrent.CopyOnWriteArrayList; //Concurrent List created by using array, whenever any modification made, a new copy of array is created in locked environment
import java.util.concurrent.CopyOnWriteArraySet; //Concurrent Set created by using CopyOnWriteArrayList, it is same as CopyOnWriteArrayList except can contains only unique elements 

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentHashMap; //It provide hashing based map with fully concurrency
import java.util.concurrent.ConcurrentSkipListMap; //Concurrent NavigableMap implementation based upon skip list where marker is used to delete element concurrently
import java.util.concurrent.ConcurrentSkipListSet; //Concurrent NavigableSet implementation
import java.util.concurrent.ConcurrentLinkedQueue; //Linked node based unbounded Queue
import java.util.concurrent.ConcurrentLinkedDeque; //Linked node based unbounded Dequeue

import java.util.concurrent.ArrayBlockingQueue; //Blocking Queue backed by Array
import java.util.concurrent.LinkedBlockingQueue; //Linked Node based optionally bounded blocking Queue
import java.util.concurrent.LinkedBlockingDeque; //Linked Node based optionally bounded blocking Dequeue
import java.util.concurrent.PriorityBlockingQueue; //Unbounded Queue used same priority as ProrityQueue

import java.util.concurrent.Delayed; //DelayQueue must implement DelayedQueue interface which extends Comparable<Delayed> interface
import java.util.concurrent.DelayQueue; //Unbounded blocking Queue of delayed element
import java.util.concurrent.SynchronousQueue; //Blocking Queue which takes a single element and wait for removing this element
import java.util.concurrent.LinkedTransferQueue; //Linked node based TransferQueue

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sandeepkumar
 */
public class ConcurrentCollectionTest {

    /**
     *
     */
    public void go() {
        /**
         * Collection methods
         * size()
         * isEmpty()
         * contains(Object ob)
         * containsAll(Collection c)
         * iterator()
         * toArray()
         * add(Object ob)
         * addAll(Collection c)
         * remove(Object ob)
         * removeAll(Collection c)
         * retainAll(Collection c)
         * clear()
         * equals(Object ob)
         * hashCode()
         */
        
         /**
          * List Methods
          * imports all methods of Collection interface
          * addAll(int index, Collection c)
          * get(int index)
          * set(int index, Object ob)
          * add(int index, Object ob)
          * remove(int index)
          * indexOf(Object ob)
          * lastIndexOf(Object ob)
          * listIterator()
          * listIterator(int index)
          * subList(int from, int to)
          */
         
         /**
          * Set Methods
          * Imports all methods of Collection
          */

          /**
           * Queue Methods
           * import all methods of Collection interface
           * add(Object ob) 
           * offer(Object ob)
           * remove()
           * poll()
           * element()
           * peek()
           */
          
          /**
           * Dequeue Methods
           * import all methods of Queue interface
           * addFirst(Object ob)
           * addLast(Object ob)
           * offerFist(Object ob)
           * offerLast(Object ob)
           * removeFirst()
           * removeLast()
           * pollFirst()
           * pollLast()
           * getFirst()
           * getLast()
           * peekFirst()
           * peekLast()
           * removeFirstOccurance(Object ob)
           * removeLastOccurance(Object ob)
           * push(Object ob)
           * pop()
           */
          
          /**
           * Map methods
           * size()
           * isEmpty()
           * containsKey(Object ob)
           * containsValue(Object ob)
           * get(Object ob)
           * put(Object key, Object value)
           * putALL(Map map)
           * remove(Object key)
           * clear()
           * keySet()
           * values()
           * entrySet()
           * equals()
           * hashCode()
           * putIfAbsent(Object key, Object value)
           */
          
          /**
           * Map.Entry methods
           * getKey()
           * getValue()
           * setValue()
           */
         
        /**
         * ArrayList
         * Inherits all functions from List Interface and provide index based 
         * dynamic list feature. Can be preferred for index based access with
         * large number of elements. Frequent modification in list may impact on
         * it's performance.
         * 
         * - It is index based duplicate collection
         * - Provide Iterator and ListIterator for traversing
         * - Insertion order
         * - Less efficient when frequent modification is needed
         * - Override equals method to work with custom objects
         */
         
        ArrayList<String> al1 = new ArrayList<String>();
        /*
        al1.add("C");
        al1.add(0, "Z");
        boolean contains1 = al1.contains("C");
        al1.ensureCapacity(10);
        String temp1 = al1.get(0);
        int index1 = al1.indexOf("C");
        boolean empty1 = al1.isEmpty();
        al1.forEach((str) -> {
            System.out.println(str);
        });
        Iterator<String> it1 = al1.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next());
        }
        ListIterator<String> it2 = al1.listIterator();
        while(it2.hasPrevious()) {
            System.out.println(it2.previous());
        }
        int size1 = al1.size();
        al1.remove(0);
        al1.remove("A");
        List<String> al2 = al1.subList(0, 0);
        al1.set(0, "D");
        al1.clear();
        */
        
        
        /**
         * - Implementation hash based unique collection by extending AbstractSet
         * - Unordered and added based upon hash code bucket system
         * - To work with Custom object, Override equals and hashCode method
         * - Implements all methods of Collection and Set interface
         * - Elements are placed based upon the hashing technique
         */
        HashSet<String> set1 = new HashSet<String>();
        /*
        set1.add("A");
        boolean add1 = set1.add("A");
        boolean isExits1 = set1.contains("Z");
        boolean isEmpay1  = set1.isEmpty();
        Iterator<String> it3 = set1.iterator();
        while(it3.hasNext()) {
            System.out.println(it3.next());
        }
        boolean isRemoved1 = set1.remove("A");
        int size2 = set1.size();
        set1.clear();
        */
    	
        
        /**
         * LinkedHashSet: It extends HashSet and implements Set so it provides
         * functionalities of both. It also work upon the hashing technique for
         * element bucketing and placement.
         * - To work with Custom Object, Override equals and hashCode method for
         * proper element placement
         * - Preserves insertion-order (like AarryList)
         */
        LinkedHashSet<String> lhs1 = new LinkedHashSet<String>();
        /*
        boolean isAdded2 = lhs1.add("A");
        Collection c = new ArrayList();
        c.add("B");
        lhs1.addAll(c);
        Iterator it3 = lhs1.iterator();
        while(it3.hasNext()) {
            System.out.println(it3.next());
        }
        boolean isContains2 = lhs1.contains("A");
        boolean isContains3 = lhs1.containsAll(c);
        boolean isEmpty2 = lhs1.isEmpty();
        boolean isRemoved2 = lhs1.remove("A");
        boolean isRemoved3 = lhs1.removeAll(c);
        int size3 = lhs1.size();
        lhs1.clear();
        */
    	
        
        /**
         * TreeSet: TreeSet implements NavigableSet and SortedSet so it provide 
         * functionality of both interfaces. As, it is an Set, is unique and
         * as it is also implementation of SortedSet so, it is an ordered
         * collection where order will be determined by the comparable method
         * implemented in objects being added. We can also, pass Comparator
         * object while creating object of TreeSet to give custom order.
         * 
         * As it also implements NavigableSet, so it provide functions for 
         * backed collection like headSet(), tailSet(), lower(), floor(),
         * ceiling(), higher() etc.
         * 
         * 
         */
        TreeSet<String> ts1 = new TreeSet<String>();
        /*
        ts1.add("Z");
        ts1.add("B");
        ts1.add("A");
        ts1.add("M");
        ts1.add("Q");
        ts1.add("C");
        ts1.add("F");
        ts1.add("D");
        ts1.add("H");
        
        String str1 = ts1.first(); //Returns first (lowest) element
        String str2 = ts1.last(); //Returns last (highest) element
        String str3 = ts1.ceiling("B"); //Return least(smaller) where element >= passed element
        String str4 = ts1.floor("F"); //Returns greatest(bigger) where element <= passed element
        String str5 = ts1.higher("D"); //Retruns greater than the given element, null if not found
        String str6 = ts1.lower("X"); //Returns smaller than the given element, null if not found
        String str7 = ts1.pollFirst(); //Retrieves and removes first (smaller) element, returns null if empty
        String str8 = ts1.pollLast(); //Retrives and removes last (highest) element, returns null if empty
        
        //Backed collection, it means if we change in resultant collection it will reflect in original collection
        NavigableSet<String> navSet1 = ts1.descendingSet(); //Return reverse order NavigableSet
        NavigableSet<String> navSet2 = ts1.headSet("B", true); //Retruns head (smaller) set than passed element, if second argument is true then include passed also otherwise does not
        NavigableSet<String> navSet3 = ts1.tailSet("D", false); //Retruns tail (greater) set than passed element, if second argument is true then include passed also otherwise does not
        NavigableSet<String> navSet4 = ts1.subSet("P", true, "Z", false); //Retrun middle set (0 <= M <= N) of apssed elements, second boolean argument tells whether passed element will be included in result or not
        SortedSet<String> sortedSet1 = ts1.headSet("F"); //Returns head (smaller) set than passed element
        SortedSet<String> sortedSet2 = ts1.tailSet("P"); //Returns tail (greater) set than passed element
        SortedSet<String> sortedSet3 = ts1.subSet("P", "X"); //Returns middle set of passed elements, if fromElement and toElement are not in order throw Exception

        boolean isContains4 = ts1.contains("X");
        int size4 = ts1.size();
        ts1.clear();
        boolean isEmpty3 = ts1.isEmpty();
        
        class TestA implements Comparable<TestA> {
            private int box;
            private String boxName;
            private String boxType;

            public TestA(int box, String boxName, String boxType) {
                this.box = box;
                this.boxName = boxName;
                this.boxType = boxType;
            }

            public int getBox() {
                return box;
            }

            public void setBox(int box) {
                this.box = box;
            }

            public String getBoxName() {
                return boxName;
            }

            public void setBoxName(String boxName) {
                this.boxName = boxName;
            }

            public String getBoxType() {
                return boxType;
            }

            public void setBoxType(String boxType) {
                this.boxType = boxType;
            }

            @Override
            public int compareTo(TestA o) {
                return this.box - o.box;
            }
        }
        TreeSet ts2 = new TreeSet();
        ts2.add(new TestA(5, "A", "X"));
        ts2.add(new TestA(1, "B", "Y"));
        ts2.add(new TestA(3, "C", "Z"));
        ts2.add(new TestA(9, "D", "A"));
        ts2.add(new TestA(2, "E", "B"));
        */
        
        
        /**
         * LinkedList: This class acts like one stop solution for various data
         * structures in Java. It implements Queue, Dequeue (Double Ended Queue)
         * List and provide feature of list, queue, double ended queue and stack
         * by its methods.
         * It is much effective for the list which made frequent modification
         * because it's implementation is based upon the element linking 
         * technique.
         */
        LinkedList<Integer> ll1 = new LinkedList<Integer>();
        /*
        boolean isAdded1 = ll1.add(10);
        ll1.add(15);
        ll1.add(11);
        ll1.add(12);
        ll1.add(13);
        ll1.add(19);
        ll1.add(17);
        ll1.add(14);
        ll1.add(20);
        ll1.add(0, 22); //Adds at specified index and shift the index
        
        //Collection
        boolean isContains5 = ll1.contains(1);
        Integer size6 = ll1.size();
        boolean isEmpty5 = ll1.isEmpty();
        //List
        ll1.add(20);
        Integer i2 = ll1.get(0); //Retrieves element at specified index, return IndexOutOfBounds if index is not available
        Integer i5 = ll1.indexOf(1); //Return index of passed element (when first found, return negative if not found)
        Integer i6 = ll1.lastIndexOf(5); //Return index of passed element (when last found, return negative if not found)
        Integer i14 = ll1.remove(); //Retrives and removes the frist element of the list
        Integer i15 = ll1.remove(0); //Retrives and removes the element specified by passed index and shifts the elements
        Integer i18 = ll1.set(0, 103); //Replaces the element of specified index
        boolean isRemoved5 = ll1.remove(Integer.valueOf(50)); //Removed specified element, if does not available passed element list will be unchanged
        //Queue
        ll1.add(20);
        boolean isAdded2 = ll1.offer(105); //Add the specified element at the tail
        Integer i19 = ll1.remove(); //Retrives and removes the frist element of the list
        Integer i1 = ll1.element(); //Retrieves first (head) element (does not remove)
        Integer i7 = ll1.peek(); //Retrieves first (head) element (does not remove)
        Integer i10 = ll1.poll(); //Retrieves first (head) element and removes the element
        //Deque
        ll1.addFirst(100);
        ll1.addLast(101);
        boolean isAdded3 = ll1.offerFirst(106); //Add specified element at tail of the list
        boolean isAdded4 = ll1.offerLast(107); //Add the specified element at the end of list.
        Integer i3 = ll1.getFirst(); //Retrieves first element of list (does not remove)
        Integer i4 = ll1.getLast(); //Retrieves last element of list (does not remove)
        Integer i8 = ll1.peekFirst(); //Retrieves first element (does not remove)
        Integer i9 = ll1.peekLast(); //Retrieves last element (does not remove)
        Integer i11 = ll1.pollFirst(); //Retrieves first (head) element and removes the element
        Integer i12 = ll1.pollLast(); //Retrieves last (tail) element and removes the element
        Integer i16 = ll1.removeFirst(); //Retrives and remove the first element of the list
        Integer i17 = ll1.removeLast(); //Retrives and remove the last element of the list
        
        //Deque - Stack
        ll1.push(108); //Push the element in stack, means at the fron of the list
        Integer i13 = ll1.pop(); //Pops the element from the stack, means retrives and remove the first element

        ll1.clear();
        */
        
        
        /**
         * ArrayDeque: It is an dynamic array based implementation of Dequeue 
         * which is very fast compare to the LinkedList. But it does not 
         * implement List interface thus can not work like array. It is fail-
         * fast.
         */
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        /*
        boolean isAdded10 = ad1.add("B"); //Add element at tail of Dequeue
        ad1.add("C");
        ad1.add("M");
        ad1.add("A");
        ad1.add("Z");
        ad1.add("P");
        ad1.addFirst("D"); //Add element at head of Dequeue
        ad1.addLast("X"); //Add element at tail of Dequeue
        ad1.offer("Q"); //Add element at tail of Dequeue
        ad1.offerFirst("E"); //Add element at head of Dequeue
        ad1.offerLast("F"); //Add element at tail of Dequeue
        
        String strAd1 = ad1.element(); //Returns head element of Dequeue (does not remove)
        String strAd2 = ad1.getFirst(); //Returns head element of Dequeue (does not remove, throws exception if empty)
        String strAd3 = ad1.getLast(); //Return last element of Dequeue (does not remove, throws exception if empty)

        String strAd4 = ad1.peek(); //Returns head element of Dequeue (does not remove)
        String strAd5 = ad1.peekFirst(); //Returns head element of Dequeue (does not remove, return null if empty)
        String strAd6 = ad1.peekLast(); //Return last element of Dequeue (does not remove, return null if empty)
        
        String strAd7 = ad1.poll(); //Returns head element of Dequeue (Remove element)
        String strAd8 = ad1.pollFirst(); //Returns head element of Dequeue (Remove element, return null if empty)
        String strAd9 = ad1.pollLast(); //Return last element of Dequeue (Remove element, return null if empty)
        
        String strAd10 = ad1.remove(); //Returns head element of Dequeue (Remove element)
        String strAd11 = ad1.removeFirst(); //Returns head element of Dequeue (Remove element, throws exception if empty)
        String strAd12 = ad1.removeLast(); //Return last element of Dequeue (Remove element, throws exception if empty)
        boolean isRemovedAd1 = ad1.remove("Z"); //Remove First Occurance of passed element, does nothing if not available
        boolean isRemovedAd2 = ad1.removeFirstOccurrence("Z"); //Remove First Occurance of passed element
        boolean isRemovedAd3 = ad1.removeLastOccurrence("Z"); //Remove Last Occurance of passed element
        
        ad1.push("FF"); //Add element at head (stack open end)
        String strAd13 = ad1.pop(); //Remove element at head (stack open end)
        
        boolean isEmpty6 = ad1.isEmpty();
        boolean isContains6 = ad1.contains("X");
        int size6 = ad1.size();
        ad1.clear();
        */
        
        
        /**
         * PriorityQueue: Unbounded Queue based upon priority heap where
         * elements are being in order based upon natural shorting. That means
         * the head of element is least (smallest) and tail of queue is largest
         * element. Does not permit null as element, and does not gurantee to
         * traverse in sorted order.
         * 
         * It does not allow null elements
         */
        PriorityQueue<String> pq1 = new PriorityQueue<String>();
        /*
        boolean isAdded20 = pq1.add("Z"); //Add element based upon priority, thorws NullPointerException if element is null
        pq1.add("X");
        pq1.add("Y");
        pq1.add("A");
        pq1.add("C");

        boolean isAdded21 = pq1.offer("X"); //Add element based upon priority, thorws NullPointerException if element is null
        
        String strPq1 = pq1.element(); //Return head (least) element, does not remove, throws NoSuchElementException if empty
        String strPq2 = pq1.peek(); //Return head (least) element, does not remove, retrun null if empty
        String strPq3 = pq1.poll(); //Return head (least) element, Remove element, retrun null if empty
        String strPq4 = pq1.remove(); //Return head (least) element, Remove element, throws NoSuchElementException if empty
        boolean isRemovedPq1 = pq1.remove("X"); //Remove first occurance of specified element
        
        int size7 = pq1.size();
        boolean isEmpty7 = pq1.isEmpty();
        boolean isContains7 = pq1.contains("X");
        pq1.clear();
        */
        
        
        /**
         * HashMap: It is a hash table based implementation of Map interface. It
         * does not implement Collection interface, still part of Java
         * Collection API. It if fail-fast, can hold null value and key. It is
         * not synchronized as most collection API classes.
         */
        HashMap<String, String> hm1 = new HashMap<String, String>();
        /*
        String strHm5 = hm1.put("A", "123"); //Adds new Key value pair and return null, If key already exists, replaces the value and return previous value
        hm1.put("B", "234");
        hm1.put("C", "345");
        hm1.put("D", "456");
        hm1.put("E", "567");

        Set<Map.Entry<String, String>> entrySet = hm1.entrySet(); //Return entry set to traverse all the entries
        for(Map.Entry<String, String> entry:entrySet) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        String strHm1 = hm1.get("A"); //Return value of associated key, if key not available return null
        String strHm2 = hm1.getOrDefault("X", "NA"); //Return value of associated key, if key not available return given Default value

        Set<String> keySet = hm1.keySet(); //Return Set of all keys available in HashMap
        for(String key:keySet) {
            System.out.println("Key: " + key);
        }
        Collection<String> values = hm1.values(); //Return Collection of all values available in HashMap
        for(String value:values) {
            System.out.println("Value: " + value);
        }
        
        String strHm3 = hm1.remove("B"); //Remove specified key and return value, if key not available return null
        String strHm4 = hm1.replace("D", "987"); //Replaces the value for the specified key and return old value, if key not available return null
        boolean isReplaced1 = hm1.replace("D", "987", "963"); //Replaces the value for the specified key and return true, if key not available return false
        boolean isRemoved21 = hm1.remove("C", "123456");
        
        int size9 = hm1.size();
        boolean isEmpty8 = hm1.isEmpty();
        boolean isConatins8 = hm1.containsKey("B");
        boolean isContains9 = hm1.containsValue("1232");
        hm1.clear();
        */
        
        
        /**
         * LinkedHashMap: It extends HashMap class and provide all feature of a
         * typical Map. However, it is based upon the linked list so it
         * preserves the insertion order with very minimum cost and provide 
         * almost equal performance as HashMap except few methods.
         * It is non-synchronized and fail fast.
         */
        LinkedHashMap<String, String> lhm1 = new LinkedHashMap<String, String>();
        /*
        String strLhm11 = lhm1.put("A", "012"); //Adds new Key value pair and return null, If key already exists, replaces the value and return previous value
        String strLhm12 = lhm1.put("Z", "123");
        String strLhm13 = lhm1.put("X", "234");
        String strLhm14 = lhm1.put("M", "345");
        String strLhm15 = lhm1.put("B", "456");
        String strLhm16 = lhm1.put("T", "567");
        
        String strLhm17 = lhm1.get("A"); //Return value of associated key, if key not available return null
        String strLhm18 = lhm1.getOrDefault("A", "999"); //Return value of associated key, if key not available return given Default value
        lhm1.entrySet();
        lhm1.keySet();
        lhm1.values();
        
        String strLhm19 = lhm1.remove("Z"); //Remove specified key and return value, if key not available return null
        boolean isRemoved11 = lhm1.remove("B", "123"); //Remove specified key and value pair (if matches both) and return value, if key not available return null

        String strLhm20 = lhm1.replace("Z", "888"); //Replaces the value for the specified key and return old value, if key not available return null
        boolean isReplaced12 = lhm1.replace("Z", "888", "333"); //Replaces the value for the specified key and return true, if key not available return false

        boolean isContains12 = lhm1.containsKey("X");
        boolean isContains13 = lhm1.containsValue("123");
        int size9 = lhm1.size();
        lhm1.clear();
        */
        
        
        /**
         * TreeMap: It is implementation of NavigableMap and SortedMap thus 
         * provides Key, Value based data structure in sorted order, where
         * algorithm for sorting defines by Comparable, or Comparator 
         * implementation. It also, provides functionalities to create backed
         * collection, where if anyone make any changes in resultant collection
         * also reflect on parent collection from which backed collection 
         * created. It is also fail-fast.
         */
        TreeMap<String, String> tm1 = new TreeMap<String, String>();
        /*
        String strTm1 = tm1.put("Z", "012"); //Adds key, value pair and make order, return old value if key already exists or return null
        String strTm2 = tm1.put("D", "123");
        String strTm3 = tm1.put("P", "234");
        String strTm4 = tm1.put("S", "345");
        String strTm5 = tm1.put("U", "456");
        String strTm6 = tm1.put("X", "567");
        String strTm7 = tm1.put("I", "678");
        String strTm8 = tm1.put("K", "789");
        String strTm9 = tm1.put("M", "890");
        String strTm10 = tm1.put("C", "901");

        String strTm11 = tm1.get("A"); //Return value of specifed key, if key not available return null
        String strTm12 = tm1.getOrDefault("S", "N/A"); //Return value of specified key, if key not available return null
        
         String strTm13 = tm1.firstKey(); //Return least (smaller) key, if map is empty thorws NoSuchElementException
        String strTm14 = tm1.lastKey(); //Return highest (biggest) key, if map is empty throws NoSuchElementException 

        String strTm15 = tm1.ceilingKey("E"); //Return smaller key where key >= passed key, if not found or empty map, return null. Throws NullPointerException if specified key is null
        String strTm16 = tm1.floorKey("E"); //Return greater key where key <= passed key. If key not found or empty map, return null. Thorws NullPointerException if specified key is null

        String strTm17 = tm1.higherKey("E"); //Return just greater key than passed key. If key is null or empty map, return null
        String strTm18 = tm1.lowerKey("E"); //Return just smaller key than passed key. If key is null or empty map, return null

        Map.Entry<String, String> entry1 = tm1.firstEntry(); //Return highest entry, null if map is empty
        Map.Entry<String, String> entry2 = tm1.lastEntry(); //Return lowest entry, null if map is empty

        Map.Entry<String, String> entry3 = tm1.ceilingEntry("E"); //Just higher or same Map.Entry of passed key, return null if not available or Map is empty, NullPointerException when passed key is null
        Map.Entry<String, String> entry4 = tm1.floorEntry("E"); //Just lower or same Map.Entry of passed key, return null if not available or Map is empty, NullPointerException when passed key is null

        Map.Entry<String, String> entry5 = tm1.higherEntry("E"); //Return just higher Map.Entry of passed key, return null if not avaiable or map is empty, throws NullPointerException if passed key is  null
        Map.Entry<String, String> entry6 = tm1.lowerEntry("E"); //Return just lower Map.Entry of passed key, return null if not available or map is empty, throws NullPointerException if passed value is null

        Map.Entry<String, String> entry7 = tm1.pollFirstEntry(); //Return Map.Entry of lowest key
        Map.Entry<String, String> entry8 = tm1.pollLastEntry(); //Return Map.Entry of highest key

        String strTm19 = tm1.remove("D"); //Remove passed key and return value of passed key, passed key is not available, return null and does nothing
        boolean strTm20 = tm1.remove("D", "123"); //Remove entry if passed key, value matches in Map and return true, otherwise return false

        String strTm21 = tm1.replace("I", "555"); //Replaces the value of key with passed value and return old value, if key not available nothing happend and return null
        boolean strTm22 = tm1.replace("I", "555", "666"); //Replaces value of the entry whose key and value matches and return true, otherwise return false and does nothing

        //Backed Collection
        SortedMap<String, String> headMap1 = tm1.headMap("P"); //Return sub map (SortedMap) where keys is lower than passed key
        NavigableMap<String, String> headMap2 = tm1.headMap("P", true); //Return sub map (NavigableMap) where keys is lower than passed key, if second argument is true, adds passed key's entry also, if is false, then does not add passed key in resultant sub map
        SortedMap<String, String> subMap1 = tm1.subMap("P", "X"); //Return sub map (SortedMap) between passed key
        NavigableMap<String, String> subMap2 = tm1.subMap("P", true, "X", false); //Return sub map (NavigableMap) amid passed keys, the second argument decides wheatcher passed key will be included in resultant map
        SortedMap<String, String> tailMap1 = tm1.tailMap("X"); //Return sub map(SortedMap) where keys are greater than passed key
        NavigableMap<String, String> tailMap2 = tm1.tailMap("X", true); //Return sub map(NavigableMap) where keys are greater than passed keys, the second argument decides whether the passed key will be added in resulted map or not

        Set<String> decendingKeySet = tm1.descendingKeySet();
        Map<String, String> decendingMap = tm1.descendingMap();
        NavigableSet<String> navigableSet = tm1.navigableKeySet();
        Set<String> keySet = tm1.keySet();
        Set<Map.Entry<String, String>> entrySet = tm1.entrySet();
        Collection<String> values = tm1.values();

        boolean isContains10 = tm1.containsKey("A");
        boolean isContains11 = tm1.containsValue("123");
        boolean isEmpty10 = tm1.isEmpty();
        int size10 = tm1.size();
        tm1.clear();
        */
        
        /**
         * Vector: Vector is a legacy class, it means it was available before 
         * the collection introduced in Java 1.5. It implements List interface
         * and provides almost same functionality as array list with following
         * differences:
         * - It is legacy class, available from Java 1.0
         * - All methods are synchronized so it is thread-safe
         * - Provide enumeration based iteration (not fail-fast, however iterator is fail-fast)
         */
        Vector<String> v = new Vector<String>();
        /*
        v.add("A");
        v.add(null);
        v.add("C");
        v.add("B");
        v.add("Z");
        v.add(null);
        v.add("X");
        boolean contains15 = v.contains("C");
        v.ensureCapacity(10);
        String temp21 = v.get(0);
        int index21 = v.indexOf("C");
        boolean empty21 = v.isEmpty();
        v.forEach((str) -> {
            System.out.println(str);
        });
        Iterator<String> it1 = v.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next());
        }
        ListIterator<String> it2 = v.listIterator();
        while(it2.hasPrevious()) {
            System.out.println(it2.previous());
        }
        int size1 = v.size();
        v.remove(0);
        v.remove("A");
        List<String> al2 = v.subList(0, 0);
        v.set(0, "D");
        v.clear();
        Enumeration e = v.elements();
        while(e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
        */
        
        /**
         * Hashtable: This is a legacy class which implements Map and Dictionary
         * interfaces and provide data structure to store key, value pair. It
         * almost behaves like HashMap but it was available in Java since 1.0
         * so often called legacy class. Initial capacity and load factor, both
         * are responsible for its performance. The behaviour is almost same as
         * HashMap except below point(s):
         * - It is legacy class available since Java 1.0
         * - All methods are synchronized so it's thread-safe
         * - Does not take nay null key and null value
         * - Provide enumeration for entry iteration (not fail-fast, however iterator is fail-fast)
         */
        Hashtable<String, String> ht2 = new Hashtable<String, String>();
        /*
        String strHm35 = ht2.put("A", "123"); //Adds new Key value pair and return null, If key already exists, replaces the value and return previous value
        ht2.put("B", "234");
        ht2.put("C", "345");
        ht2.put("D", "456");
        ht2.put("E", "567");

        Set<Map.Entry<String, String>> entrySet31 = ht2.entrySet(); //Return entry set to traverse all the entries
        for(Map.Entry<String, String> entry:entrySet31) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        String strHm31 = ht2.get("A"); //Return value of associated key, if key not available return null
        String strHm32 = ht2.getOrDefault("X", "NA"); //Return value of associated key, if key not available return given Default value

        Set<String> keySet31 = ht2.keySet(); //Return Set of all keys available in HashMap
        for(String key:keySet31) {
            System.out.println("Key: " + key);
        }
        Collection<String> values = ht2.values(); //Return Collection of all values available in HashMap
        for(String value:values) {
            System.out.println("Value: " + value);
        }
        
        Enumeration et = ht2.keys();
        while(et.hasMoreElements()) {
            System.out.println(et.nextElement());
        }
        
        String strHm33 = ht2.remove("B"); //Remove specified key and return value, if key not available return null
        String strHm34 = ht2.replace("D", "987"); //Replaces the value for the specified key and return old value, if key not available return null
        boolean isReplaced31 = ht2.replace("D", "987", "963"); //Replaces the value for the specified key and return true, if key not available return false
        boolean isRemoved231 = ht2.remove("C", "123456");
        
        int size39 = ht2.size();
        boolean isEmpty38 = ht2.isEmpty();
        boolean isConatins38 = ht2.containsKey("B");
        boolean isContains39 = ht2.containsValue("1232");
        ht2.clear();
        */
        
        
        /**
         * CopyOnWriteArrayList: It is the basic Concurrent collection in which
         * the internal array which holds the elements is being created/copied
         * each and every time when any modification is made; and this happens
         * in locked environment by using ReenterantLock class.
         * It must be used for small amount of elements and less modification
         * scenario because it consists heavy copy operation each time when
         * modification made.
         */
    	CopyOnWriteArrayList<String> cowal = new CopyOnWriteArrayList<String>();
    	/*
    	Runnable cr1 = new Runnable() {
			@Override
			public void run() {
				for(long l = 0; l < 100; l++) {
					cowal.add(String.valueOf(l));
				}
			}
    	};
    	Runnable cr2 = new Runnable() {
    		@Override
    		public void run() {
    			cowal.forEach(ele -> System.out.println(ele));
    		}
    	};
    	new Thread(cr1).start();
    	new Thread(cr2).start();
    	*/
    	

    	/**
    	 * CopyOnWriteArraySet: It is created by using CopyOnWriteArrayList to maintain
    	 * concurrent Set type (unique) collection. Thus, it provide same features as 
    	 * CopyOnWriteArrayList except uniqueness of element.
    	 * 
    	 */
    	CopyOnWriteArraySet<String> cowas = new CopyOnWriteArraySet<String>();
    	/*
    	Runnable cr3 = new Runnable() {
			@Override
			public void run() {
				for(long l = 0; l < 100; l++) {
					cowas.add(String.valueOf(l));
				}
			}
    	};
    	Runnable cr4 = new Runnable() {
    		@Override
    		public void run() {
    			cowas.forEach(ele -> System.out.println(ele));
    		}
    	};
    	new Thread(cr3).start();
    	new Thread(cr4).start();
    	*/
    	
        /**
         * ConcurrentHashMap: It implements ConcurrentMap and AbstractMap; and
         * provides a fully synchronized hashing based map. It splits the entire
         * map into Segment, and synchronization is performed on Segment that 
         * allows the map to get lock on segments instead of entire map. This
         * means, the number of Segment in map may handle the same number of
         * Threads concurrently. Also, the reading operation like get does not
         * block because of the use of Segment.
         * - Does not hold null key, value just like Hashtable
         */
        ConcurrentHashMap<String, String> chm1 = new ConcurrentHashMap<String, String>();
        /*
        Runnable r1 = new Runnable() {
            public void run() {
                for(int i = 0; i < 100; i++) {
                    String key = ThreadLocalRandom.current().nextInt(0, 10000) + "";
                    String value = ThreadLocalRandom.current().nextInt(0, 10000) + "";
                    chm1.put(key, value);
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                }
           }
        };
        Runnable r2 = new Runnable() {
            public void run() {
                String threadName = Thread.currentThread().getName();
                Set<Map.Entry<String, String>> entrySet = chm1.entrySet();
                for(Map.Entry<String, String> entry:entrySet) {
                    System.out.println(threadName + ": " + "Key: " + entry.getKey() + " Value: " + entry.getValue());
                }
            }
        };
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r2).start();
        new Thread(r2).start();
        */
        
    	
        /**
         * ConcurrentSkipListMap: This is an implementation of concurrent link
         * node based Map. It implements NavigableMap, thus is will be in sorted
         * manner. It applies marker based deletion to avoid any deletion errors.
         * 
         * The key elements must be either implements Comparable or a Comparator
         *  object must be passed in constructor 
         */
        ConcurrentSkipListMap<String, String> cslm1 = new ConcurrentSkipListMap<String, String>();
        /*
        String strCslm1 = cslm1.put("A", "0123");
        String strCslm2 = cslm1.put("Z", "1234");
        String strCslm3 = cslm1.put("X", "2345");
        String strCslm4 = cslm1.put("C", "3456");
        String strCslm5 = cslm1.put("V", "4567");

        Map.Entry<String, String> cslm1Entry1 = cslm1.ceilingEntry("C");
        String strCslm6 = cslm1.ceilingKey("C");
        Map.Entry<String, String> cslm1Entry2 = cslm1.floorEntry("V");
        String strCslm7 = cslm1.floorKey("V");

        Map.Entry<String, String> cslm1Entry3 = cslm1.higherEntry("X");
        String strCslm8 = cslm1.higherKey("V");
        Map.Entry<String, String> cslm1Entry4 = cslm1.lowerEntry("C");
        String strCslm9 = cslm1.lowerKey("C");
        
        Map.Entry<String, String> cslm1Entry5 = cslm1.firstEntry();
        String strCslm10 = cslm1.firstKey();
        Map.Entry<String, String> cslm1Entry6 = cslm1.lastEntry();
        String strCslm11 = cslm1.lastKey();

        String strCslm12 = cslm1.get("A");
        String strCslm13 = cslm1.getOrDefault("P", "N/A");

        Map.Entry<String, String> cslm1Entry7 = cslm1.pollLastEntry();
        Map.Entry<String, String> cslm1Entry8 = cslm1.pollFirstEntry();

        String strCslm14 = cslm1.remove("A");
        boolean isRemoved41 = cslm1.remove("F", "123456");

        String strCslm15 = cslm1.replace("Z", "123456789");
        boolean isReplaced41 = cslm1.replace("Z", "123456789", "987");

        ConcurrentNavigableMap<String, String> cnm41 = cslm1.headMap("C");
        ConcurrentNavigableMap<String, String> cnm42 = cslm1.headMap("V", true);
        ConcurrentNavigableMap<String, String> cnm43 = cslm1.subMap("C", "X");
        ConcurrentNavigableMap<String, String> cnm44 = cslm1.subMap("C", false, "V", true);
        ConcurrentNavigableMap<String, String> cnm45 = cslm1.tailMap("D");
        ConcurrentNavigableMap<String, String> cnm46 = cslm1.tailMap("D", true);

        Set<Map.Entry<String, String>> cnm47 = cslm1.entrySet();
        Set<String> cnm48 = cslm1.keySet();
        Collection<String> cnm49 = cslm1.values();
        NavigableSet cnm50 = cslm1.navigableKeySet();
        
        boolean isContains41 = cslm1.containsKey("A");
        boolean isContains42 = cslm1.containsValue("1234");
        boolean isEmpty41 = cslm1.isEmpty();
        int size41 = cslm1.size();
        cslm1.clear();
        */
        
        /**
         * ConcurrentSkipListSet: A concurrent node skip list based NavigableSet
         * implementation which work on basis of marker element for deletion of
         * an element.
         */
        ConcurrentSkipListSet<String> csls1 = new ConcurrentSkipListSet<String>();
        /*
        boolean strCsls1 = csls1.add("X");
        boolean strCsls2 = csls1.add("C");
        boolean strCsls3 = csls1.add("V");
        boolean strCsls4 = csls1.add("B");
        boolean strCsls5 = csls1.add("N");
        boolean strCsls6 = csls1.add("M");
        
        csls1.ceiling("D");
        csls1.clear();
        csls1.contains("A");
        csls1.first();
        csls1.floor("C");
        csls1.headSet("N");
        csls1.headSet("N", false);
        csls1.higher("W");
        csls1.isEmpty();
        csls1.isEmpty();
        csls1.last();
        csls1.lower("C");
        csls1.pollFirst();
        csls1.pollLast();
        csls1.remove("S");
        */
        
        
        /**
         * ConcurrentLinkedQueue: It is a thread-safe queue based upon linked nodes, orders elements in FIFO.
         * The head of queue is the element which available in queue from the longest time. The tail of the
         * queue is the element which is newly added. It is appropriate choice when multiple thread access the
         * same queue. It does not accept null as element.
         * 
         * Iterator does not throw ConcurrentModificationException and it is weekly consistent as queue may be
         * modified at the same time when it is being iterated by other thread.The bulk operation like addAll()
         * removeAll(), retainAll(), conatinsAll(), equals(), and to toArray() are not guaranteed to performed
         * automatically, for example, suppose adding a bunch of elements by using addAll(), while traversal with
         * Iterator in other thread may show some of the added elements.
         * 
         * It implements Queue interface thus provides all the methods of queue
         */
        ConcurrentLinkedQueue<String> clq1 = new ConcurrentLinkedQueue<>();
        /*
        Runnable r1 = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 1000;i++) {
        			ThreadLocalRandom.current().ints(1000, 65, 91).forEach((v) -> {clq1.add(String.valueOf((char)v));});
        		}
        	}
        };
        Runnable r2 = new Runnable() {
        	public void run() {
        		clq1.forEach(System.out::println);
        	}
        };
        new Thread(r1).start();
        new Thread(r2).start();
        */
        
        /**
         * ConcurrentLinkedDequeue: It is unbounded, thread-safe deque which implements Deque interface and thus provides
         * all methods of Deque. Does not accept null element as other concurrent collections. Iterator and Spliterator
         * are weekly consistent. Bulk operations like addAll, removeAll, retailAll, clear, toArray and equals are not
         * performed automatically.
         * 
         */
        ConcurrentLinkedDeque<Integer> cld1 = new ConcurrentLinkedDeque<>();
        /*
        Runnable r1 = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 1000; i++) {
        			cld1.add(i);
        			cld1.offerFirst((-1)*i);
        		}
        	}
        };
        Runnable r2 = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 1000; i++) {
        			System.out.println(cld1.pollFirst());
        		}
        	}
        };
        new Thread(r1).start();
        try {Thread.sleep(5000);} catch(InterruptedException ie) {ie.printStackTrace();}
        new Thread(r2).start();
        */
        
        
        
        /**
         * ArrayBlockingQueue: A bounded blocking queue baked  by an array where the longest time element in queue is the head and new elements are
         * at tail. It is a classic bounded-buffer made by fixed sized array where elements are added by producer thread and elements are removed
         * by consumer threads. Once it is created size can't be changed. Attempt to added element in full queue result blocking of thread which is
         * trying to add. Similarly, attempt to take element from empty queue put on hold for the addition of element from other producer thread.
         * 
         * The size of ArrayBlockingQueue is fixed at creation by using constructor argument.
         */
        ArrayBlockingQueue<String> abq1 = new ArrayBlockingQueue<>(3);
        /*
        Runnable producer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 10; i++) {
        			try {
            			System.out.println("Producer: Ready to add element - " + i);
            			abq1.put("" + i);
            			System.out.println("Producer: Added element - " + i);
            			System.out.println("Producer: Start Sleeping - " + i);
            			Thread.sleep(2000);
            			System.out.println("Producer: Wakeup Sleeping - " + i);
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        		}
        	}
        };
        Runnable consumer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 10; i++) {
        			System.out.println("Consumer: STaking element - " + i);
        			try {
        				abq1.take();
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        			System.out.println("Consumer: ETaking element - " + i);
        		}
        	}
        };
        new Thread(producer).start();
        new Thread(consumer).start();
        */
        
        
        /**
         * LinkedBlockingQueue: It is an optionally bounded queue based on linked node. We can defined size for LinkedBlockingQueue at the creation
         * in constructor otherwise it's size will be Integer.MAX by default. Linked queue typically have high throughput than array based queue
         * but less predictable performance in most concurrent applications. It blocks the producer thread if the queue is full (in case of, if
         * size of queue is specified in constructor or size is greater than Integer.MAX) and blocks the consumer if queue is empty.
         */
        LinkedBlockingQueue<Integer> lbq1 = new LinkedBlockingQueue<>();
        /*
        Runnable producer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 10; i++) {
        			try {
            			System.out.println("Producer: Ready to add element - " + i);
            			lbq1.put(i);
            			System.out.println("Producer: Added element - " + i);
            			System.out.println("Producer: Start Sleeping - " + i);
            			Thread.sleep(2000);
            			System.out.println("Producer: Wakeup Sleeping - " + i);
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        		}
        	}
        };
        Runnable consumer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 10; i++) {
        			System.out.println("Consumer: STaking element - " + i);
        			try {
        				lbq1.take();
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        			System.out.println("Consumer: ETaking element - " + i);
        		}
        	}
        };
        new Thread(producer).start();
        new Thread(consumer).start();
        */
        
        
        /**
         * LinkedBlockingDeque: It is optionally bounded deque which implements Deque interface and provides all functionalities for Deque
         * If capacity is not specified in constructor, the size will be Integer.MAX.
         * 
         */
        LinkedBlockingDeque<String> lbd1 = new LinkedBlockingDeque<>();
        /*
        Runnable producer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 1000; i++) {
        			try {
            			lbd1.put("" + i);
            			Thread.sleep(500);
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        		}
        	}
        };
        Runnable consumer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 1000; i++) {
        			try {
        				System.out.println(lbd1.take());
        			}
        			catch(InterruptedException ex) {
        				ex.printStackTrace();
        			}
        		}
        	}
        };
        new Thread(consumer).start();
        new Thread(producer).start();
        */
        
        
        /**
         * PriorityBlockingQueue: It is unbounded blocking queue which uses ordering rules as per PriorityQueue and supplies blocking retrieval operation.
         * Though, it is unbounded it may fail addition of resources due to exhaustion (causing OutOfMemoryError). Does not allow null values. It allows
         * natural order thus elements being added must be implementation of Comparable interface otherwise throw ClassCastException.
         * 
         * Iterator does not guarantee about ordered traversal due to modification of queue by other threads. Thus, it can be used as Arrays.sort(pq.toArray()).
         * Operation sequence is not guaranteed on the elements of same priority, to enforce secondry ordering, custom Comparators can be used
         * 
         * The queue is unbound, it means put() method never blocks the producer thread
         */
        PriorityBlockingQueue<Box> pbq1 = new PriorityBlockingQueue<Box>();
        /*
        Runnable producer = new Runnable() {
        	public void run() {
        		for(int i = 1000; i > 0 ; i--) {
        			String tmp = ("000" + i);
        			tmp = tmp.substring(tmp.length() - 4, tmp.length());
        			pbq1.put(new Box(tmp));
        			try {
        				if(i % 100 == 0) {
        					Thread.sleep(100);
        				}
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        		}
        	}
        };
        Runnable consumer = new Runnable() {
        	public void run() {
        		try {
        			for(int i = 0; i < 1000; i++) {
        				System.out.println(pbq1.take());
        				Thread.sleep(100);
        			}
        		}
        		catch(InterruptedException ie) {
        			ie.printStackTrace();
        		}
        	}
        };
        new Thread(producer).start();
        new Thread(consumer).start();
        */
        
        /**
         * LinkedTransferQueue: It is an unbounded queue based upon link nodes. The queue orders elements in FIFO with respect to any
         * given producer. The head of queue is the element which stayes longest time in queue; and the tail it the element which stays
         * shortest time for some consumer.
         * 
         * The size() method is not constant time operation because the obtaing size requires traversal of elements, and thus, it may 
         * report inaccurate if queue is being modified during traversal. Additionally, the bulk operation such as addAll(), removeAll(),
         * retainAll(), clear() are not atomic operation.
         * 
         * LinkedTransferQueue = LinkedBlockingQueue + SynchronousQueue + DelayQueue
         * 
         * It means it provide all functionalities of LinkedBlockingQueue along with SynchronousQueue; there is method introduced named
         * transfer(E e), it is used for producer and put the producer thread in wait state till appropriate consumer found to consume the
         * element.
         * 
         * put() and take(): for BlockingQueue
         * transfer() and take(): for SynchronousQueue
         * offer(E e, long timeOut, TimeUnit timeUnit), take(): for DelayQueue
         */
        LinkedTransferQueue<String> ltq1 = new LinkedTransferQueue<String>();
        int mode = 2; //0 - BlockingQueue, 1 - TransferQueue, 2 - DelayQueue
        Runnable producer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 10; i++) {
        			if(mode == 0) {
        				System.out.println("BlockingQueue: S - Element is added " + i);
        				ltq1.put("E" + i);
        				System.out.println("BlockingQueue: E - Element is added " + i);
        				try {
        					Thread.sleep(2000);
        				}
        				catch(InterruptedException ie) {
        					ie.printStackTrace();
        				}
        			}
        			else if(mode == 1) {
        				System.out.println("TransferQueue: S - Element is added " + i);
        				try {
        					ltq1.transfer("E" + i);
        				}
        				catch(InterruptedException ie) {
        					ie.printStackTrace();
        				}
        				System.out.println("TransferQueue: E - Element is added " + i);
        			}
        			else if(mode == 2) {
        				System.out.println("DelayQueue: S - Element is added " + i);
        				ltq1.offer("E" + i, 5000, TimeUnit.MILLISECONDS);
        				System.out.println("DelayQueue: E - Element is added " + i);
        				try {
        					Thread.sleep(1000);
        				}
        				catch(InterruptedException ie) {
        					ie.printStackTrace();
        				}
        			}
        		}
        	}
        };
        Runnable consumer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 10; i++) {
            		if(mode == 0) {
            			System.out.println("CBQ: S Value " + i);
            			try {
            				System.out.println("CBQ Take:  " + ltq1.take());
            			}
            			catch(InterruptedException ie) {
            				ie.printStackTrace();
            			}
            			System.out.println("CBQ: E Value " + i);
            		}
            		else if(mode == 1) {
            			System.out.println("CTQ: S Value " + i);
            			try {
            				System.out.println("CTQ Take: " + ltq1.take());
            				Thread.sleep(2000);
            			}
            			catch(InterruptedException ie) {
            				ie.printStackTrace();
            			}
            			System.out.println("CTQ: E Value " + i);
            		}
            		else if(mode == 2) {
            			System.out.println("CDQ: S Value " + i);
            			try {
            				System.out.println("CDQ Take: " + ltq1.take());
            			}
            			catch(InterruptedException ie) {
            				ie.printStackTrace();
            			}
            			System.out.println("CDQ: E Value " + i);
            		}
        		}
        	}
        };
        new Thread(producer).start();
        new Thread(consumer).start();
        
        
        
        
        
        
        /**
         * DelayQueue: It is unbounded blocking queue of delayed elements where an element can only be taked from queue when delay expired.
         * The head of queue is the element whose delay expired furthest in the past. If not delay expired, there will not be head and poll
         * will return null. Thus, unexpired elements can't be reomved from the queue by poll(), or take() methods.
         * 
         * The queue does not permits null elements. Object is being added into DelayQueue must implements Delayed interface
         * 
         * The iterator does not guarantee the traversal in any order
         * offer(E e, long timeout, TimeUnit timeUnit) associates expiry of element
         */
        DelayQueue<DelayedBox> dq1 = new DelayQueue<DelayedBox>();
        /*
        Random r = new Random();
        Runnable producer = new Runnable() {
        	Random r = new Random();
        	public void run() {
        		for(int i = 0; i < 1000; i++) {
        			DelayedBox d = new DelayedBox("A" + i, r.nextInt(10000));
        			System.out.println("Producer: " + d);
        			dq1.put(d);
        			try {
        				Thread.sleep(500);
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        		}
        	}
        };
        Runnable consumer = new Runnable() {
        	public void run() {
        		try {
        			for(int i = 0; i < 1000; i++) {
            			DelayedBox d = dq1.take();
            			System.out.println("Consumer: " + d);
        			}
        		}
        		catch(InterruptedException ie) {
        			ie.printStackTrace();
        		}
        	}
        };
        new Thread(producer).start();;
        new Thread(consumer).start();
        */
        
        
        
        /**
         * SynchronousQueue: It does not have any internal capacity, here, insert operation must wait for corresponding remove operation and vice-versa.
         * Not able to insert, take or iterate this queue because it does not have internal cabinet for holding even a single element. Thus, trying to
         * remove element using poll() returns null. It's also called empty collection. It does not permits null element.
         * 
         *  This queue also supports order fairness policy for waiting producer/consumer threads. By default, ordering is not guaranteed but if fairness
         *  policy is passed true in constructor, it will be FIFO
         */
        SynchronousQueue<String> sq = new SynchronousQueue<String>(true);
        /*
        Runnable producer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 100; i++) {
        			try {
        				System.out.println("PUT Wait: " + i);
        				sq.put("" + i);
        				System.out.println("PUT: " + i);
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        		}
        	}
        };
        Runnable consumer = new Runnable() {
        	public void run() {
        		for(int i = 0; i < 100; i++) {
        			try {
        				System.out.println("Take Wait: " + i);
        				String tmp = sq.take();
        				System.out.println("Take: " + tmp);
        			}
        			catch(InterruptedException ie) {
        				ie.printStackTrace();
        			}
        		}
        	}
        };
        new Thread(producer).start();
        new Thread(consumer).start();
        */
        
        
    }

    /**
     *
     * @param args
     */
    public static void main(String...args) {
        ConcurrentCollectionTest test = new ConcurrentCollectionTest();
        test.go();
    }
}



































class Box implements Comparable<Box> {
	private String boxName;
	public Box() {}
	public Box(String boxName) {
		this.boxName = boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public String getBoxName() {
		return boxName;
	}
	public String toString() {
		return boxName;
	}
	public int compareTo(Box b1) {
		return boxName.compareTo(b1.boxName);
	}
}

class DelayedBox implements Delayed {
	private String boxName;
	private long expiryTime;
	public DelayedBox() {}
	public DelayedBox(String boxName) {
		this.boxName = boxName;
	}
	public DelayedBox(String boxName, long expiryTime) {
		this.boxName = boxName;
		this.expiryTime = expiryTime;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public String getBoxName() {
		return boxName;
	}
	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}
	public long getExpiryTime() {
		return expiryTime;
	}
	public String toString() {
		return "Box Name: " + boxName + " Exp Time: " + expiryTime;
	}
	public long getDelay(TimeUnit timeUnit) {
		long diff = expiryTime - System.currentTimeMillis();
		return timeUnit.convert(diff, TimeUnit.MILLISECONDS);
	}
	public int compareTo(Delayed b1) {
		if(expiryTime < ((DelayedBox)b1).expiryTime) {
			return -1;
		}
		else if(expiryTime > ((DelayedBox)b1).expiryTime) {
			return 1;
		}
		else {
			return 0;
		}
	}
}