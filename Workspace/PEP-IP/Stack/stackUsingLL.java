package Stack;

public class stackUsingLL {
	static class StackNode {
		int data;
		StackNode next;

		StackNode(int a) {
			data = a;
			next = null;
		}
	}

	static class MyStack {
		// Note that top is by default null
		// in Java
		StackNode top, head;

		public MyStack() {
			this.top = null;
			this.head = null;
		}

		// Comlete the functions
		void push(int a) {
			StackNode node = new StackNode(a);
			if (top == null && head == null) {
				top = node;
				head = node;
			} else {
				top.next = node;
				top = node;
			}

		}

		int pop() {
			// Invalid case
			if (top == null) {
				return -1;
			}
			// Reset
			if (head == top) {
				int ans = top.data;
				top = null;
				head = null;
				return ans;
			}
			int ans = top.data;
			StackNode temp = head;
			while (temp.next != top) {
				temp = temp.next;
			}
			temp.next = null;
			top = temp;
			return ans;
		}

	}

}
