import java.io.*;
import java.util.*;


public class ThreeStack {
	
	int stackSize = 100;

	int[] buffer;

	int[] stackPointer = {-1,-1,-1};

	ThreeStack() {
		buffer = new int[300];
	}

	public void push(int stackNum, int data) throws Exception {
		stackNum--;
		if (stackNum>2) {
			System.out.println("Stack nu"+stackNum);
			throw new Exception();

		}
		int stackBase = stackNum * 100;
		if ( stackPointer[stackNum] < (stackSize)) {
			stackPointer[stackNum]++;
			buffer[stackBase+stackPointer[stackNum]] = data;
		} else {
			System.out.println("Stack "+stackNum+" Full");
		}
	}


	public int pop(int stackNum) throws Exception {
		int res;
		stackNum--;
		int stackBase = stackNum * 100;
		if (stackPointer[stackNum] == -1) {
			System.out.println("EXception Nothing to Pop");
			throw new Exception();
		} else {
			res = buffer[stackBase + stackPointer[stackNum]];
			stackPointer[stackNum]--;
			return res;
		}
	}


	public void printStack(int stackNum) {

		System.out.println(" Details of Stack "+stackNum);
		stackNum--;
		int stackBase = stackNum * 100;

		if (stackPointer[stackNum] == -1) {
			System.out.println(" Nothing to Print Stack EMpty");
		} else {
			int tempStackPointer = stackPointer[stackNum];
			System.out.println("tempStackPointer =  "+tempStackPointer);
			while (tempStackPointer >= 0) {
				System.out.println(buffer[stackBase + tempStackPointer]);
				tempStackPointer--;	
			}
		}	
	}

	public static void main(String[] args) {


		ThreeStack ts = new ThreeStack();

		try {
		ts.push(1, 100);
		ts.push(1, 200);
		ts.printStack(1);
		ts.push(2, 1);
		ts.push(2, 2);
		ts.printStack(2);
		ts.push(3, 9);
		ts.push(3, 9);
		ts.printStack(3);
	} catch (Exception e) {
		System.out.println("Error in stack");
	}

	}

}