package Recursion_revisited;

import java.util.ArrayList;
import java.util.List;

public class letterCombinationsOfPhoneNumber {
	String[] strs = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		helper(digits, "", result);
		if (result.size() == 1) {
			return new ArrayList<String>();
		}
		return result;
	}

	void helper(String digits, String asf, List<String> list) {
		if (digits.length() == 0) {
			list.add(asf);
			return;
		}
		char cc = digits.charAt(0);
		String ros = digits.substring(1);
		int index = cc - '0';
		for (int i = 0; i < strs[index].length(); i++) {
			helper(ros, asf + strs[index].charAt(i), list);
		}
	}
	
}
