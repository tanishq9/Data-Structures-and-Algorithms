package StackImplementation;

public class sortStack {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(4);
		Sort(stack);
		stack.display();
	}

	static void Sort(Stack stack) throws Exception {
		if (stack.isEmpty()) {
			return;
		}
		int element = stack.top();
		stack.pop();
		Sort(stack);
		Insert(stack, element);
	}

	static void Insert(Stack stack, int element) throws Exception {
		if (stack.isEmpty() || stack.top() <= element) {
			stack.push(element);
			return;
		} else {
			int ele = stack.top();
			stack.pop();
			Insert(stack, element);
			stack.push(ele);
		}
	}

}
