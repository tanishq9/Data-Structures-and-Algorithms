package Strings;

public class compressString {

	public static void main(String[] args) {
		String str = "sstrrrinnggg";
		StringBuilder sb = new StringBuilder();
		int currentCount = 0;
		for (int i = 0; i < str.length();) {
			char cc = str.charAt(i);
			currentCount = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) == cc) {
					currentCount++;
				} else {
					break;
				}
			}
			sb.append(cc);
			sb.append(currentCount);
			i += currentCount;
		}
		System.out.println(sb.toString());
	}

}
