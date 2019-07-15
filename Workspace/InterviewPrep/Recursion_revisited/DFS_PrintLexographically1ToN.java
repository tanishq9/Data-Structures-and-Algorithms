package Recursion_revisited;

import java.util.ArrayList;
import java.util.List;

public class DFS_PrintLexographically1ToN {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			dfs(i, n, res);
		}
		return res;
	}

	void dfs(int curr, int n, List<Integer> res) {
		if (curr > n) {
			return;
		} else {
			res.add(curr);
			for (int i = 0; i < 10; i++) {
				dfs(10 * curr + i, n, res);
			}
		}
	}

}
