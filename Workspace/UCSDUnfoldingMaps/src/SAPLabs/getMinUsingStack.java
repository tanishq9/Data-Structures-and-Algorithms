package SAPLabs;

public class getMinUsingStack {
	private int[] data;
	private int size;
	private int top;
	int minEle;

	public getMinUsingStack() {
		this.data = new int[10];
		this.size = 0;
		this.top = -1;
	}

	public Boolean isEmpty() {
		return this.size == 0;
	}

	public void push(int item) {
		if (isEmpty()) {
			top++;
			this.data[this.top] = item;
			minEle = item;
			return;
		} else if (item < minEle) {
			// update the minEle as the minimum element and
			// in stack push a value which is lesser than the minEle just found
			this.top++;
			this.data[this.top] = 2 * item - minEle;
			minEle = item;
			return;
		} else {
			// Don't update the minimum element now.
			top++;
			this.data[this.top] = item;
		}

	}

	public void pop() {
		int element = this.data[this.top];
		if (element < minEle) {
			System.out.println(minEle);
			minEle = 2 * minEle - element;
			return;
		}
		System.out.println(minEle);
	}

	public static void main(String[] args) {
		getMinUsingStack stack = new getMinUsingStack();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(4);
		stack.pop();
	}

}
