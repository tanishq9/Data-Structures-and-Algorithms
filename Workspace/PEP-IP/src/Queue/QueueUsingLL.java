package Queue;

public class QueueUsingLL {
	static class QueueNode {
		int data;
		QueueNode next;

		QueueNode(int a) {
			data = a;
			next = null;
		}
	}

	static class MyQueue {
		QueueNode front, rear;

		// This function should add an item at

		// rear
		void push(int a) {
			// Add Last
			QueueNode newNode = new QueueNode(a);
			if (front == null && rear == null) {
				front = newNode;
				rear = newNode;
			} else {
				rear.next = newNode;
				rear = newNode;
			}
		}

		// This function should remove front
		// item from queue and should return
		// the removed item.
		int pop() {
			// Remove First
			int data = front.data;
			QueueNode temp = front.next;
			front.next = null;
			front = temp;
			if (front == null) {
				rear = null;
			}
			return data;
		}
	}

}
