package String;

public class maskingPersonalInfo {
	public static String maskPII(String S) {
		// Write your code here
		int atIndex = S.indexOf('@');
		if (atIndex >= 0) {
			// Email
			return (S.charAt(0) + "*****" + S.substring(atIndex - 1)).toLowerCase();
		} else {
			// Phone
			char modify[] = S.toCharArray();
			String Digits = "";
			for (int i = 0; i < modify.length; i++) {
				if (modify[i] != '+' && modify[i] != '-' && modify[i] != ')' && modify[i] != '(' && modify[i] != ' ') {
					Digits += modify[i];
				}
			}
			StringBuilder ans = new StringBuilder();
			ans.append("***-***-" + Digits.substring(Digits.length() - 4));

			if (Digits.length() == 10) {

				return ans.toString();
			}
			String ns = '+' + "";
			for (int i = 0; i < Digits.length() - 10; i++) {
				ns += '*';
			}
			ns += '-' + ans.toString();

			return ns;

		}
	}
}
