package Stack;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class stackOperations {

	public static String infixToPostfix(String exp) {
		Stack<Character> stack = new Stack<>();
		String expression = "";
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashMap<Character, Integer> precedenceMap = new HashMap<>();
		precedenceMap.put('+', 1);
		precedenceMap.put('-', 1);
		precedenceMap.put('*', 2);
		precedenceMap.put('/', 2);
		precedenceMap.put('^', 3);
		for (int i = 0; i < exp.length(); i++) {
			char currentElement = exp.charAt(i);
			int ascii = currentElement;
			// Digit
			if (48 <= ascii && ascii <= 57) {
				expression += currentElement;
			} else if (stack.isEmpty()) {
				// Push
				stack.push(currentElement);
			} else if (currentElement == '(') {
				// Pop
				stack.push(currentElement);
			} else if (currentElement == ')') {
				// Pop
				while (stack.peek() != '(') {
					expression += stack.pop();
				}
				stack.pop();
			} else {
				// Operator precedence
				if (stack.isEmpty() || stack.peek() == '(') {
					stack.push(currentElement);
				} else if (precedenceMap.get(currentElement) > precedenceMap.get(stack.peek())) {
					// Push
					stack.push(currentElement);
				} else if (precedenceMap.get(currentElement) <= precedenceMap.get(stack.peek())) {
					// Pop
					while (!stack.isEmpty() && stack.peek() == '('
							&& precedenceMap.get(currentElement) <= precedenceMap.get(stack.peek())) {
						expression += stack.pop();
					}
					stack.push(currentElement);
				}
			}
		}
		while (!stack.isEmpty()) {
			expression += stack.pop();
		}

		return expression;
	}

	public static String postfixToInfix(String exp) {
		Stack<Integer> stack = new Stack<>();
		String expression = "";
		for (int i = 0; i < exp.length(); i++) {
			char currentElement = exp.charAt(i);
			int ascii = currentElement;
			// Digit
			if (48 <= ascii && ascii <= 57) {
				stack.push(currentElement - '0');
			} // Operand
			else if (currentElement == '+') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left + right);
				expression += "(" + left + "+" + right + ")";
			} else if (currentElement == '-') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left - right);
				expression += "(" + left + "-" + right + ")";
			} else if (currentElement == '*') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left * right);
				expression += "(" + left + "*" + right + ")";
			} else if (currentElement == '/') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left / right);
				expression += "(" + left + "/" + right + ")";
			} else if (currentElement == '^') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push((int) Math.pow(left, right));
				expression += "(" + left + "^" + right + ")";
			}
		}
		return expression;
	}

	public static void postfixToPrefix(String exp) {
		Stack<String> pre = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char currentElement = exp.charAt(i);
			int ascii = currentElement;
			// Digit
			if (48 <= ascii && ascii <= 57) {
				pre.push(currentElement - '0' + "");
			} // Operand
			else if (currentElement == '+') {
				String preTop1 = pre.pop();
				String preTop2 = pre.pop();
				pre.push("+" + preTop2 + preTop1);
			} else if (currentElement == '-') {
				String preTop1 = pre.pop();
				String preTop2 = pre.pop();
				pre.push("-" + preTop2 + preTop1);
			} else if (currentElement == '*') {
				String preTop1 = pre.pop();
				String preTop2 = pre.pop();
				pre.push("+" + preTop2 + preTop1);
			} else if (currentElement == '/') {
				String preTop1 = pre.pop();
				String preTop2 = pre.pop();
				pre.push("/" + preTop2 + preTop1);
			} else if (currentElement == '^') {
				String preTop1 = pre.pop();
				String preTop2 = pre.pop();
				pre.push("^" + preTop2 + preTop1);
			}
		}
		while (!pre.isEmpty()) {
			System.out.print(pre.pop() + "");
		}
	}

	public static int evaluatePostfix(String exp) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char currentElement = exp.charAt(i);
			int ascii = currentElement;
			// Digit
			if (48 <= ascii && ascii <= 57) {
				stack.push(currentElement - '0');
			} // Operand
			else if (currentElement == '+') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left + right);
			} else if (currentElement == '-') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left - right);
			} else if (currentElement == '*') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left * right);
			} else if (currentElement == '/') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left / right);
			} else if (currentElement == '^') {
				int right = stack.pop();
				int left = stack.pop();
				stack.push((int) Math.pow(left, right));
			}
		}
		return stack.pop();
	}

	public static int prefix(String expression) {
		Stack<Integer> stack = new Stack<>();
		Stack<String> in = new Stack<>();
		Stack<String> post = new Stack<>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char cc = expression.charAt(i);
			int offset = cc - '0';
			if (cc >= 0 && cc <= 9) {
				stack.push(offset);
			} else {
				int top1 = stack.pop();
				int top2 = stack.pop();
				if (cc == '+') {
					stack.push(top1 + top2);
					in.push("(" + top1 + "+" + top2 + ")");
				} else if (cc == '-') {
					stack.push(top1 - top2);
					in.push("(" + top1 + "-" + top2 + ")");
				} else if (cc == '*') {
					stack.push(top1 * top2);
					in.push("(" + top1 + "*" + top2 + ")");
				} else if (cc == '/') {
					stack.push(top1 / top2);
					in.push("(" + top1 + "/" + top2 + ")");
				} else if (cc == '^') {
					stack.push((int) Math.pow(top1, top2));
					in.push("(" + top1 + "^" + top2 + ")");
				}
			}
		}
		return stack.pop();
	}

	public static int infixEval(String exp) {
		Stack<Integer> value = new Stack<>();
		Stack<Character> op = new Stack<>();
		HashMap<Character, Integer> precedenceMap = new HashMap<>();
		precedenceMap.put('+', 1);
		precedenceMap.put('-', 1);
		precedenceMap.put('*', 2);
		precedenceMap.put('/', 2);
		precedenceMap.put('^', 3);
		for (int i = 0; i < exp.length(); i++) {
			char cc = exp.charAt(i);
			int offset = cc - '0';
			// If digit - push in value stack
			if (cc >= '0' && cc <= '9') {
				value.push(offset);
			}
			// If not push in operand stack
			else if (cc == '(') {
				op.push('(');
			} else if (cc == ')') {
				while (op.peek() != '(') {
					char opTop = op.pop();
					int top1 = value.pop();
					int top2 = value.pop();
					if (opTop == '+') {
						value.push(top2 + top1);
					} else if (opTop == '*') {
						value.push(top2 * top1);
					} else if (opTop == '-') {
						value.push(top2 - top1);
					} else if (opTop == '/') {
						value.push(top2 / top1);
					} else if (opTop == '^') {
						value.push((int) Math.pow(top2, top1));
					}
				}
				op.pop();
			}
			// Precedence
			else {
				// Operator precedence
				System.out.println(cc);
				while (op.size() > 0 && op.peek() != '(' && precedenceMap.get(cc) <= precedenceMap.get(op.peek())) {
					char opTop = op.pop();
					int top1 = value.pop();
					int top2 = value.pop();
					if (opTop == '+') {
						value.push(top2 + top1);
					} else if (opTop == '*') {
						value.push(top2 * top1);
					} else if (opTop == '-') {
						value.push(top2 - top1);
					} else if (opTop == '/') {
						value.push(top2 / top1);
					} else if (opTop == '^') {
						value.push((int) Math.pow(top2, top1));
					}
				}

				op.push(cc);

			}
		}
		while (op.size() > 0) {
			char opTop = op.pop();
			int top1 = value.pop();
			int top2 = value.pop();
			if (opTop == '+') {
				value.push(top2 + top1);
			} else if (opTop == '*') {
				value.push(top2 * top1);
			} else if (opTop == '-') {
				value.push(top2 - top1);
			} else if (opTop == '/') {
				value.push(top2 / top1);
			} else if (opTop == '^') {
				value.push((int) Math.pow(top2, top1));
			}
		}
		return value.pop();
	}

	public static void main(String[] args) {
		String exp = "82-3/2131+*^+";
		String exp2 = "(1-2)/3+4^(5*(6+7))";
		System.out.println(infixToPostfix(exp2));

		// System.out.println(evaluatePostfix(exp));
		// System.out.println(postfixToInfix(exp));
		postfixToPrefix(exp);

		String input = "8-2/3+2^1*(1+3)";
		System.out.println();
		System.out.println(infixEval(input));

	}

}
