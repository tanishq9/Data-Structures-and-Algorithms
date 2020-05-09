package String;

public class compareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		int len1 = version1.length();
		int len2 = version2.length();
		int i = 0, j = 0;
		while (i < len1 || j < len2) {
			int temp1 = 0;
			int temp2 = 0;
			// If one version is shorter in length then its contribution will be
			// counted as 0 for further iterations
			while (i < len1 && version1.charAt(i) != '.') {
				temp1 = temp1 * 10 + (version1.charAt(i) - '0');
				i++;
			}
			while (j < len2 && version2.charAt(j) != '.') {
				temp2 = temp2 * 10 + (version2.charAt(j) - '0');
				j++;
			}
			if (temp1 > temp2) {
				return 1;
			} else if (temp1 < temp2) {
				return -1;
			}
			i++; // skip the dot and compare further numbers
			j++; // skip the dot and compare further numbers
		}
		return 0;
	}
}
