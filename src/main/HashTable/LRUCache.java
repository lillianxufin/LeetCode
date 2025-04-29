package main.HashTable;

import java.util.HashMap;

public class LRUCache {
	private HashMap<Integer, Node> map;
    private int capacity, count;
    private Node head, tail;
    
	class Node{
		int key, value;
		Node pre;
		Node next;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public LRUCache(int capacity) {
         this.capacity = capacity;
         count = 0;
         map = new HashMap<Integer, Node>();
         head = new Node(0, 0);
         tail = new Node(0, 0);
         head.next = tail;
         tail.pre = head;
         head.pre = null;
         tail.next = null;
    }
	
	public void addNodeToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;		
		node.pre = head;
		head.next = node;	
	}
	
	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
    
    public int get(int key) {
        if(map.get(key) != null) {
        	Node node = map.get(key);
        	int result = node.value;
        	deleteNode(node);
        	addNodeToHead(node);
        	return result;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
    	System.out.println("Add node: " + key );
        if(map.containsKey(key)) {
        	Node node = map.get(key);
        	node.value = value;
        	deleteNode(node);
        	addNodeToHead(node);
        	System.out.println("Already there");
        } else {
        	Node node = new Node(key, value);
        	map.put(key, node);
        	
        	if(count < capacity) {
        		count++;
        		addNodeToHead(node);
        		System.out.println("Added" );
        	} else {
        		map.remove(tail.pre.key);
        		System.out.println("Removed: " + tail.pre.key + " to add");
        		deleteNode(tail.pre);
        		addNodeToHead(node);
        		
        	}
        }
    }
    
    
        public static void main(String[] args)
        {
            System.out.println("Going to test the LRU "
                               + " Cache Implementation");
            LRUCache cache = new LRUCache(2);
     
            // it will store a key (1) with value
            // 10 in the cache.
            cache.put(1, 1);
     
            // it will store a key (1) with value 10 in the
            // cache.
            cache.put(2, 2);
            System.out.println("Value for the key: 1 is "
                               + cache.get(1)); // returns 10
     
            // evicts key 2 and store a key (3) with
            // value 30 in the cache.
            cache.put(3, 3);
     
            System.out.println(
                "Value for the key: 2 is "
                + cache.get(2)); // returns -1 (not found)
     
            // evicts key 1 and store a key (4) with
            // value 40 in the cache.
            cache.put(4, 4);
            System.out.println(
                "Value for the key: 1 is "
                + cache.get(1)); // returns -1 (not found)
            System.out.println("Value for the key: 3 is "
                               + cache.get(3)); // returns 30
            System.out.println("Value for the key: 4 is "
                               + cache.get(4)); // return 40
        }
}


