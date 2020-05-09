package Recursion_revisited;

import java.util.ArrayList;

public class getKthPermutation_FactorialTrick {
	// https://leetcode.com/problems/permutation-sequence/discuss/22539/Java-Recursive-and-Iterative
	// https://leetcode.com/problems/permutation-sequence/discuss/22554/Backtrack-Summary%3A-General-Solution-for-10-Questions!!!!!!!!-Python-(Combination-Sum-Subsets-Permutation-Palindrome)
	public String getPermutation(int n, int k) {
		ArrayList<Integer> numbers = new ArrayList<>();
		int[] fact = new int[n + 1];
		fact[0] = 1;
		fact[1] = 1;
		for (int i = 2; i <= n; i++) {
			fact[i] = fact[i - 1] * i;
		}
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		String res = "";
		for (int i = numbers.size() - 1; i >= 0; i--) {
			// 40th is 39 in the sequence as we do indexing from 0
			int num = (k - 1) / fact[i];
			k = k - num * fact[i];
			res += numbers.get(num);
			numbers.remove(num);
		}
		return res;
	}
}
