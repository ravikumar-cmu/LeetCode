import java.util.*;

public class LRUCache {
    Map<Integer, Node> cache;
    Node head =  null;
    Node tail = null;
    
    int maxSize;
    int curSize;
    
    public LRUCache(int capacity) {
        if (capacity>0) {
            maxSize = capacity;
            cache = new HashMap<Integer, Node>();
        }
    }
    
    public int get(int key) {
        //System.out.println("Get :  key ="+key);
        if (cache.get(key) != null) {
            Node temp = cache.get(key);
            refresh(temp);
                System.out.println("Get :  key ="+key+" Val = "+temp.data);
            return temp.data;
        } else {
            System.out.println("Get :  key ="+key+" Val = -1");
            return -1;
        }
        
    }
    
    public void set(int key, int value) {
        System.out.println("Set :  key ="+key+" value ="+value);
        
        Node t = new Node(key, value);
        
        Node existing = cache.get(key);
        
        if (existing != null) {
            remove(existing);
            cache.remove(key);
            addNode(t);
            cache.put(key, t);
            return;
        } 
        //System.out.println("in middle");
        //printCache();
        //System.out.println("in middle >>>>");

        if (curSize < maxSize) {
            curSize++;
            addNode(t);
            cache.put(key, t);
        } else {
            cache.remove(head.key);
            remove(head);
           // System.out.println(head.data);
            
            addNode(t);
            cache.put(key,t);
            
        }
    }
    
    public void remove(Node t) {

        System.out.println("remove : "+t.key +" : "+t.data);
        if (t== null) {
            return;
        }
        
        
        if (t.prev !=null) {
            t.prev.next = t.next;
        } else {
            head = head.next;
        }

        if (t.next != null) {
            t.next.prev = t.prev;
        } else {
            tail = tail.prev;
        }

        //printlist();
        //System.out.println("removed ");
        

    }

    
    public void addNode(Node t) {
        if (t == null) {
            return;
        }
        
        if (head == null) {
            head = t;
            tail = head;
            return;
        }
        
        tail.next = t;
        t.prev = tail;
        tail = tail.next;
    }

    
    public void refresh(Node t) {
        
        if (t== null) {
            return;
        }
        
        if (tail == t) {
            return;
        }
        
        
        if (t.prev !=null) {
            t.prev.next = t.next;
        } else {
            head = head.next;
        }
        if (t.next != null) {
            t.next.prev = t.prev;
        }
        addNode(t);
    }
    
    
    class Node{
        int key;
        int data;
        Node next;
        Node prev;
        
        Node(int key, int data ) {
            this.data = data;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }
    
public void printCache() {
    System.out.println("Cache : ");
    for (Map.Entry<Integer, Node> entry : cache.entrySet()) {
        System.out.print(entry.getKey());
        System.out.println(" : "+entry.getValue().data);
    }

    //printlist();
    
}   

public void printlist()  {
    Node temp = head;
    while (temp !=null) {
        System.out.println(" node : "+temp.key+" : "+temp.data);
        temp = temp.next;
    }
    if (tail !=null) {
          System.out.println("tail : "+tail.key+" : "+tail.data);
    }
}
    
public static void main(String[] args) {

    LRUCache x = new LRUCache(10);
    
    
x.set(10,13);
x.set(3,17);
x.set(6,11);
x.set(10,5);
x.set(9,10);
x.printCache();

x.get(13);
x.set(2,19);
x.get(2);
x.get(3);
x.set(5,25);
x.get(8);
x.set(9,22);
x.set(5,5);
x.set(1,30);
x.get(11);
x.set(9,12);
x.printCache();
x.get(7);
x.get(5);
x.get(8);
x.get(9);
x.set(4,30);
x.set(9,3);
x.get(9);
x.get(10);
x.get(10);
x.set(6,14);
x.set(3,1);
x.printCache();
x.get(3);
x.set(10,11);
x.get(8);
x.set(2,14);
x.get(1);
x.get(5);
x.get(4);
x.set(11,4);
x.set(12,24);
x.set(5,18);
x.get(13);
x.set(7,23);
x.printCache();
x.get(8);
x.get(12);
x.set(3,27);
x.set(2,12);
x.get(5);
x.set(2,9);
x.set(13,4);
x.set(8,18);
x.set(1,7);
x.get(6);
x.set(9,29);
x.set(8,21);
x.get(5);
x.set(6,30);
x.set(1,12);
x.printCache();
x.get(10);
x.set(4,15);
x.set(7,22);
x.set(11,26);
x.set(8,17);
x.set(9,29);
x.get(5);
x.set(3,4);
x.set(11,30);
x.get(12);
x.set(4,29);
x.get(3);
x.get(9);
x.get(6);
x.set(3,4);
x.get(1);
x.get(10);
x.set(3,29);
x.set(10,28);
x.set(1,20);
x.set(11,13);
x.printCache();
x.get(3);
x.set(3,12);
x.set(3,8);
x.set(10,9);
x.set(3,26);
x.get(8);
x.get(7);
x.get(5);
x.set(13,17);
x.set(2,27);
x.set(11,15);
x.printCache();
x.get(12);
x.set(9,19);
x.set(2,15);
x.set(3,16);
x.get(1);
x.set(12,17);
x.set(9,1);
x.set(6,19);
x.get(4);
x.get(5);
x.get(5);
x.set(8,1);
x.set(11,7);
x.set(5,2);
x.set(9,28);
x.printCache();
x.get(1);


x.set(2,2);
x.set(7,4);
x.set(4,22);
x.set(7,24);
x.set(9,26);
x.set(13,28);
x.set(11,26);




    for (Map.Entry<Integer, Node> entry : x.cache.entrySet()) {
        System.out.print(entry.getKey());
        System.out.println(entry.getValue().data);
    }
}

}