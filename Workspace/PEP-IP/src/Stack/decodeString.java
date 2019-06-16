package Stack;

import java.util.Scanner;
import java.util.Stack;

public class decodeString {
	public static String decode(String S) {
		Stack<String> ss = new Stack<>();
		ss.push("");
		Stack<Integer> ns = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			char cc = S.charAt(i);
			int offset = cc - '0';
			if (0 <= offset && offset <= 9) {
				ns.push(offset);
			} else {
				if (cc == ']') {
					String s1 = "";
					while (ss.size() > 0 && !ss.peek().equals("[")) {
						s1 = ss.pop() + s1;
					}
					System.out.println(s1);
					ss.pop(); // Pop the opening bracket
					String s2 = "";
					if (ss.size() == 0) {
						s2 = "";
					} else {
						s2 = ss.pop();
					}
					int num = ns.pop();
					String blank = "";
					while (num-- > 0) {
						blank += s1;
					}
					s2 += blank;
					ss.push(s2);
				} else {
					ss.push(cc + "");
				}
			}
		}
		String op = "";
		while (ss.size() > 0) {
			op = ss.pop() + op;
		}
		return op;
	}

	public static void main(String[] args) {
		// 3[a2[c]]
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(decode(s));
	}
}
