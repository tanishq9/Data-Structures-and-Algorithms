package Stack;

import java.util.Stack;

public class absoluteCanonicalPath {
	class Solution {
		public String simplifyPath(String path) {
			Stack<String> stack = new Stack<>();
			for (int i = 0; i < path.length(); i++) {
				// Skip the unnecessary /
				while (i < path.length() && path.charAt(i) == '/') {
					i++;
				}
				String s = "";
				while (i < path.length() && path.charAt(i) != '/') {
					s += path.charAt(i);
					i++;
				}
				if (s.equals("")) {
					continue;
				}
				i--;
				if (s.equals("..")) {
					if (stack.size() > 0) {
						stack.pop();
					}
				} else if (s.equals(".")) {
					continue;
				} else {
					stack.push(s);
				}
			}
			// Now the stack contains all the valid file names or strings
			StringBuilder sb = new StringBuilder();
			Stack<String> temp = new Stack<>();
			while (stack.size() > 0) {
				temp.push(stack.pop());
			}
			sb.append("/");
			while (temp.size() > 0) {
				if (temp.size() == 1) {
					sb.append(temp.pop());
				} else {
					sb.append(temp.pop() + "/");
				}
			}
			return sb.toString();
		}
	}
}
