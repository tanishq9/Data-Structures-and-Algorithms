package String;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> res = new ArrayList<>();

		char[] patternArr = pattern.toCharArray();
		for (String query : queries) {
			boolean isMatch = match(query.toCharArray(), patternArr);
			res.add(isMatch);
		}

		return res;
	}

	private boolean match(char[] queryArr, char[] patternArr) {
		int j = 0;
		int i = 0;
		while (j < queryArr.length) {
			if (i < patternArr.length && queryArr[j] == patternArr[i]) {
				i++;
				j++;
			} else if (Character.isUpperCase(queryArr[j])) {
				return false;
			} else {
				j++;
			}
		}
		return i == patternArr.length;
	}

}
