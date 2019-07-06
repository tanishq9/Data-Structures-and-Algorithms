package String;

public class removeString {
	public static void removeString(String str, String m, String n) {
		int[] canprint = new int[str.length()];
		for (int i = 0; i <= str.length() - m.length(); i++) {
			String toTest = str.substring(i, i + m.length());
			if (toTest.compareTo(m) == 0) {
				for (int j = i; j < i + m.length(); j++) {
					canprint[j]++;
				}
			}
		}

		for (int i = 0; i <= str.length() - n.length(); i++) {
			String toTest = str.substring(i, i + n.length());
			if (toTest.compareTo(n) == 0) {
				for (int j = i; j < i + n.length(); j++) {
					canprint[j]++;
				}
			}
		}
		int printed = 0;
		for (int i = 0; i < canprint.length; i++) {
			if (canprint[i] == 0) {
				System.out.print(str.charAt(i));
				printed++;
			}
		}

		if (printed == 0) {
			System.out.println(-1);
		} else {
			System.out.println();
		}

	}
}
