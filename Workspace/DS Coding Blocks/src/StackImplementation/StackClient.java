package StackImplementation;

public class StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack stack=new Stack();
		Stack helper=new Stack();
		for(int i=1;i<=5;i++) {
			stack.push(i*10);	
		}
		stack.display();
		//reverseStack(stack,helper);
		reverseStackAlter(stack,helper,0);
		//helper.display();
		/*for(int i=helper.size()-1;i>=0;i--) {
			stack.push(helper.top());
			helper.pop();
		}*/
		stack.display();
	}
	public static void reverseStack(Stack stack,Stack helper) throws Exception {
		if(stack.size()==0) {
			return;
		}
		int rv=stack.pop();
		reverseStack(stack,helper);
		helper.push(rv);
		return;
	}
	public static void reverseStackAlter(Stack stack,Stack helper,int index) throws Exception {
		if(stack.size()==0) {
			return;
		}
		int rv=stack.pop();
		reverseStackAlter(stack,helper,index+1);
		helper.push(rv);
		if(index==0) {
			while(!helper.isEmpty()) {
				stack.push(helper.pop());
			}
		}
		return;
	}

}
