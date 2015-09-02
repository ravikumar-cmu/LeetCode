import java.util.*;
import java.io.*;

class minStack {
	
	Stack s  = new Stack();
	Stack minS = new Stack();

	public void push(int data) {

		s.push(new Integer(data));

		if (minS.isEmpty() || (data < (Integer)minS.peek())) {
			minS.push(new Integer(data));
		}
	}


	public int pop() {
		
		if ((Integer)s.peek() <= (Integer)minS.peek()) {
			minS.pop();
		} 
		return (Integer)s.pop();
	}

	public void getMin() {
		
	}

	public void print() {
		System.out.println(Arrays.toString(s.toArray()));
		System.out.println ("*************************************** ");
		System.out.println(Arrays.toString(minS.toArray()));
	}

	public static void main(String[] args) {
		minStack ms = new minStack();

		ms.push(11);
		ms.push(3);
		ms.push(4);
		ms.push(1);
		ms.print();
	}
}