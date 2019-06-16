package Stack;

import java.util.Stack;

public class findFormula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "C(H0)3";
		Stack<Integer> ns = new Stack<>();
		Stack<String> ss = new Stack<>();
		ss.push("");
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			int offset = cc - '0';
			if (0 <= offset && offset <= 9) {
				ns.push(offset);
			} else {
				if (cc != ')') {
					ss.push(cc + "");
				} else {
					int n = ns.pop();
					String nstr = "";
					while (ss.size() > 0 && !ss.peek().equals("(")) {
						nstr = ss.pop() + nstr;
					}
					ss.pop();
					String blank = "";
					while (n-- > 0) {
						blank += nstr;
					}
					String ctop = ss.pop();
					ss.push(ctop + blank);
				}
			}
		}
		System.out.println(ss.peek());
	}

}
