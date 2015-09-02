
import java.util.*;

public class remdupunsortlist {
	
	node head = null;

	public void createList(int x) {
	
		node n = new node();
		n.data = x;
		n.next = head;
		head = n;
	}

	public void printList(node head) {
		node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void remDupUsingHash() {
		HashMap<Integer, Boolean> linkedMap =  new HashMap<Integer, Boolean>();
		
		node prev = null;

		node temp = head;
		prev = head;

		while (temp!= null) {
//			System.out.println(temp.data);
		
			if (linkedMap.containsKey(temp.data)) {
				prev.next = temp.next;
			} else {
				linkedMap.put(temp.data, true);
			}
			prev = temp;
			temp = temp.next;
		}	

	}

	public static void main (String[] args) {
		
		remdupunsortlist list = new remdupunsortlist();
		list.createList(1);
		list.createList(2);
		list.createList(3);
		list.createList(4);
		list.createList(5);
		list.createList(5);
		list.printList(list.head);
		System.out.println("*****************");

		list.remDupUsingHash();

		list.printList(list.head);
	}
}

class node {

	int data;
	node next = null;

}


