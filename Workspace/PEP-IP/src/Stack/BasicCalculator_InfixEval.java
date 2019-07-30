package Stack;

import java.util.HashMap;
import java.util.Stack;

public class BasicCalculator_InfixEval {
	public int calculate(String s) {
		Stack<Character> op = new Stack<>();
		Stack<Integer> ns = new Stack<>();
		HashMap<Character, Integer> precedenceMap = new HashMap<>();
		precedenceMap.put('+', 1);
		precedenceMap.put('-', 1);
		precedenceMap.put('*', 2);
		precedenceMap.put('/', 2);
		int i = 0;
		while (i < s.length()) {
			char cc = s.charAt(i);
			// SPACE
			if (cc == ' ') {
				i++;
				continue;
			}
			// NUMBER
			if (Character.isDigit(cc)) {
				int num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}
				ns.push(num);
				continue;
			}
			// OPENING BRACE
			else if (cc == '(') {
				op.push(cc);
			}
			// CLOSING BRACE
			else if (cc == ')') {
				while (op.peek() != '(') {
					int num1 = ns.pop();
					int num2 = ns.pop();
					char oper = op.pop();
					if (oper == '+') {
						ns.push(num2 + num1);
					} else if (oper == '-') {
						ns.push(num2 - num1);
					} else if (oper == '/') {
						ns.push(num2 / num1);
					} else if (oper == '*') {
						ns.push(num2 * num1);
					}
				}
				op.pop(); // POP THE OPENING BRACE NOW
			}
			// OPERATOR
			else {
				while (op.size() > 0 && op.peek() != '(' && precedenceMap.get(cc) <= precedenceMap.get(op.peek())) {
					// Greater predence operator will be evaluated first
					int num1 = ns.pop();
					int num2 = ns.pop();
					char oper = op.pop();
					if (oper == '+') {
						ns.push(num2 + num1);
					} else if (oper == '-') {
						ns.push(num2 - num1);
					} else if (oper == '/') {
						ns.push(num2 / num1);
					} else if (oper == '*') {
						ns.push(num2 * num1);
					}
				}
				op.push(cc);
			}
			i++;
		}
		while (op.size() > 0 && ns.size() > 1) {
			int num1 = ns.pop();
			int num2 = ns.pop();
			char oper = op.pop();
			if (oper == '+') {
				ns.push(num2 + num1);
			} else if (oper == '-') {
				ns.push(num2 - num1);
			} else if (oper == '/') {
				ns.push(num2 / num1);
			} else if (oper == '*') {
				ns.push(num2 * num1);
			}
		}
		return ns.pop();

	}
}
