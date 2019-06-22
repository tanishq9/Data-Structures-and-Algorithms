package Stack;

import java.util.Scanner;
import java.util.Stack;

public class decodeString {
	public static String decodeString(String s) {
		Stack<String> ss = new Stack<>(); // for storing previous string
		Stack<Integer> ns = new Stack<>();
		String res = ""; // for forming new string and later appending it to previous string
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int num = 0;
				while (Character.isDigit(s.charAt(idx))) {
					num = num * 10 + (s.charAt(idx++) - '0');
				}
				ns.push(num);
			} else if (s.charAt(idx) == '[') {
				ss.push(res);
				res = "";
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder sb = new StringBuilder(ss.pop());
				int count = ns.pop();
				while (count-- > 0) {
					sb.append(res);
				}
				res = sb.toString();
				idx++;
			} else {
				res += s.charAt(idx++);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// 3[a2[c]]
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(decodeString(s));
	}
}
