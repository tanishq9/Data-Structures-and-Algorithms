package IBit;

public class reverseStringEachWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Welcome to India";
		System.out.println(reverseEachWord(input));
	}

	// Return the reversed string. No need to print
	static StringBuilder res = new StringBuilder();

	public static String reverseEachWord(String input) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (; i < input.length();) {
			if (input.charAt(i) != ' ') {
				sb.append(input.charAt(i));
				i += 1;
				continue;
			} else {
				i -= 1;
				sb.reverse();
				res.append(sb);
				sb.setLength(0);
				i = i + 1;
				while (input.charAt(i) == ' ') {
					res.append(" ");
					i++;
				}
				sb.setLength(0);
				continue;
			}
		}
		if (sb.length() != 0) {
			sb.reverse();
			res.append(sb);
		}
		return res.toString();
	}

}
