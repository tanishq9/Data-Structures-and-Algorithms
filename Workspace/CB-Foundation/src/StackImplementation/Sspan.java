package StackImplementation;

public class Sspan {
	private int top;
	private int[] data;
	private final static int DEFAULT_CAPACITY = 100;

	public Sspan() {
		this(DEFAULT_CAPACITY);
	}

	public Sspan(int len) {
		this.data = new int[len];
		this.top = -1;
	}

	public int size() {
		return this.top + 1;
	}

	public void push(int item) {
		this.top++;
		this.data[this.top] = item;
	}

	public void pop() {
		this.data[this.top] = 0;
		this.top--;
	}

	public int top() {
		return this.data[this.top];
	}

	public static void main(String[] args) {
		Sspan sspan = new Sspan(10);
		int arr[] = { 100, 80, 60, 70, 75, 85 };
		int span[] = new int[arr.length];
		sspan.push(0);
		span[0] = 0;
		int current = sspan.top();
		for (int i = 1; i < arr.length; i++) {
			current = arr[i];
			while (current > arr[sspan.top()]) {
				sspan.pop();
			}
			span[i] = i - sspan.top();
			sspan.push(i);
		}
		for (int i = 0; i < span.length; i++) {
			System.out.print(span[i] + " ");
		}
	}
}
