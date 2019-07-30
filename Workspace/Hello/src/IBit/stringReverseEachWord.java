package IBit;

import java.util.Scanner;

public class stringReverseEachWord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		StringBuilder sb = new StringBuilder(str);
		int left = 0, right = str.length() - 1;
		while (left <= right) {
			char temp = sb.charAt(left);
			sb.setCharAt(left, sb.charAt(right));
			sb.setCharAt(right, temp);
			left++;
			right--;
		}
		//System.out.println(sb.toString());
		StringBuilder res = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < sb.length();) {
			if (sb.charAt(i) != ' ') {
				res.append(sb.charAt(i));
				i += 1;
				continue;
			} else {
				i -= 1;
				ans.append(res.reverse());
				res.setLength(0);
				i += 1;
				while (sb.charAt(i) == ' ') {
					ans.append(' ');
					i += 1;
				}
				continue;
			}
		}
		if (sb.length() != 0) {
			ans.append(res.reverse());
		}
		System.out.println(ans.toString());
	}

}
