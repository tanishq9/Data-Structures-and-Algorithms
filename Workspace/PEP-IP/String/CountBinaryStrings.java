package String;

public class CountBinaryStrings {
	public int countBinarySubstrings(String s) {

		int prev = 0;
		int curr = 1;
		int count = 0;
		int num = s.charAt(0) - '0';
		int index = 1;

		while (index < s.length()) {
			int offset = s.charAt(index) - '0';
			if (num == offset) {
				curr++;
			} else {
				prev = curr;
				curr = 1;
				num = offset;
			}
			if (prev >= curr) {
				count += 1;
			}
			index++;
		}

		return count;

	}
}
