package String;

import java.util.Arrays;

public class longestUniqueSubstring {

	public static void main(String[] args) {
		String str = "abdefgaef";
		int[] lastOccurance = new int[256];
		Arrays.fill(lastOccurance, -1);
		// each character represents an alphabet starting from a till z
		lastOccurance[str.charAt(0)] = 0;
		int maxLength = 0;
		int currentLength = 1;
		for (int i = 1; i < str.length(); i++) {
			// GET the last occurrence of current character
			int lastOccurance_currentCharacter = lastOccurance[str.charAt(i)];
			// Check if that element has to be considered or not
			if (lastOccurance_currentCharacter == -1 || i - currentLength > lastOccurance_currentCharacter) {
				currentLength += 1;
			} else {
				if (currentLength > maxLength) {
					maxLength = currentLength;
				}
				currentLength = i - lastOccurance_currentCharacter;
				System.out.println(currentLength);
			}
			// Update the last occurrence of the current character
			lastOccurance[str.charAt(i)] = i;
		}
		if (currentLength > maxLength) {
			maxLength = currentLength;
			currentLength = 1;
		}
		System.out.println(maxLength);
	}

}
