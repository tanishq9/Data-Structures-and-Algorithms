package StackQueues;

import java.util.Stack;

public class simplifyDirectoryPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/a/./b/../../c/";
		Stack<String> stack = new Stack<>();
		String temp = "";
		for (int i = 0; i < path.length(); i++) {
			temp = "";
			// Skip the multiple '/'
			while (path.charAt(i) == '/') {
				i++;
			}
			// store the input name
			while (i < path.length() && path.charAt(i) != '/') {
				temp += path.charAt(i);
				i++;
			}
			// if input name is .. i.e we have pop
			if (temp.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
			// if input name is . i.e we have pop
			else if (temp.equals(".")) {
				continue;
			} else {
				// It is a valid name
				stack.push(temp);
			}
		}
		String result = "/";
		Stack<String> t = new Stack<>();
		while (!stack.isEmpty()) {
			t.push(stack.pop());
		}
		while (!t.isEmpty()) {
			if (t.size() == 1) {
				result += t.pop();
			} else {
				result += t.pop() + "/";
			}
		}
		System.out.println(result);
	}

}
