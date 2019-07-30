package String;

public class studentAttendanceRecord {
	public static boolean checkRecord(String s) {
		// write your code here.
		int i = 0;
		int cA = 0;
		while (i < s.length()) {
			char cc = s.charAt(i);
			if (cc == 'A') {
				cA++;
				if (cA > 1) {
					return false;
				}
				i++;
				continue;
			} else if (cc == 'L') {
				int cL = 0;
				while (i < s.length() && s.charAt(i) == 'L') {
					i++;
					cL++;
				}
				if (cL > 2) {
					return false;
				}
			} else {
				i++;
			}
		}
		return true;

	}

}
