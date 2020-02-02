package StackImplementation;

import java.util.Stack;

public class stackmax {

	Stack<Integer> currentStack = new Stack<>();
	Stack<Integer> trackStack = new Stack<>();

	public stackmax() {
		// this(DEFAULT_CAPACITY);
	}

	public void push(int item) {
		currentStack.push(item);
		if (trackStack.size() < 1 || trackStack.peek() < item) {
			trackStack.push(item);
		} else {
			trackStack.push(trackStack.peek());
		}
	}

	public void pop() {
		currentStack.pop();
		trackStack.pop();
	}

	public int top() {
		return currentStack.peek();
	}

	public int max() {
		return trackStack.peek();
	}

	public static void main(String[] args) {
		stackmax stackmax = new stackmax();
		stackmax.push(4);
		stackmax.push(2);
		stackmax.push(14);
		stackmax.push(1);
		stackmax.push(18);

		System.out.println(stackmax.max());
		stackmax.pop();
		System.out.println(stackmax.max());
	}

}
