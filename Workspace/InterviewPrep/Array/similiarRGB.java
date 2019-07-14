package Array;

public class similiarRGB {
	public String similarRGB(String color) {
		if (color == null || color.length() == 0) {
			return "";
		}

		String[] dict = new String[] { "00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc",
				"dd", "ee", "ff" };
		int minDistance = Integer.MAX_VALUE;
		String ans = "";

		for (String R : dict) {
			for (String G : dict) {
				for (String B : dict) {
					String s = "#" + R + G + B;
					int distance = getDistance(s, color);
					if (distance < minDistance) {
						ans = s;
						minDistance = distance;
					}
				}
			}
		}

		return ans;
	}

	private int getDistance(String a, String b) {
		int distance = 0;
		for (int i = 1; i < 7; i += 2) {
			int n1 = Integer.parseInt(a.substring(i, i + 2), 16);
			int n2 = Integer.parseInt(b.substring(i, i + 2), 16);
			distance += (n1 - n2) * (n1 - n2);
		}

		return distance;
	}
}
