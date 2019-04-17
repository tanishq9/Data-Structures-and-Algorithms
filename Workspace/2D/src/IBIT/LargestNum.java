package IBIT;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNum {
	static public class Solution {
		static class myC implements Comparator<String> {
			public int compare(String a, String b) {
				String ab = a + b;
				String ba = b + a;
				if (ab.compareTo(ba) > 0) {
					return -1;
				} else if (ab.compareTo(ba) < 0) {
					return 1;
				}
				return 0;
			}
		}

		// DO NOT MODIFY THE LIST. IT IS READ ONLY
		public String largestNumber(final List<Integer> list) {
			int countZ = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == 0) {
					countZ += 1;
				}
			}
			if (countZ == list.size()) {
				return "0";
			}

			ArrayList<String> strlist = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				strlist.add(String.valueOf(list.get(i)));
			}

			strlist.sort(new myC());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < strlist.size(); i++) {
				sb.append(strlist.get(i));
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
