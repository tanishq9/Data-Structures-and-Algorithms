package DynamicProgramming;

import java.util.ArrayList;

public class minJumps {

	private static int minJumps(int[] arr, int l, int h, int[] memo) {
		if (l == h) {
			return 0;	
		}
		if (arr[l] == 0) {
			return Integer.MAX_VALUE;
		}
		if (memo[l] != 0) {
			return memo[l];
		}
		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			// matlab arr[1] is 2 then mai arr[2] and arr[3] mei 1 daal dunga
			int possibleJump = minJumps(arr, i, h, memo);
			min = Math.min(min, possibleJump + 1);
		}
		return memo[l] = min;
	}

	public static int jump(ArrayList<Integer> A) {
		int[] memo = new int[A.size() + 1];
		int minJumps = min(A, 0, A.size() - 1, memo);
		if (minJumps == Integer.MAX_VALUE - 5) {
			return -1;
		}
		return minJumps;
	}

	private static int min(ArrayList<Integer> list, int l, int h, int[] memo) {
		if (l == h) {
			return 0;
		}
		if (list.get(l) == 0) {
			return Integer.MAX_VALUE - 5;
		}
		if (memo[l] != 0) {
			return memo[l];
		}
		int result = Integer.MAX_VALUE - 5;
		for (int i = l + 1; i <= list.get(l) + l && i <= h; i++) {
			result = Math.min(1 + min(list, i, h, memo), result);
		}
		return memo[l] = result;
	}

	public static void main(String[] args) {
		int[] jumps = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int[] memo = new int[jumps.length + 1];
		// System.out.println(minJumps(jumps, 0, jumps.length - 1, memo));
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < jumps.length; i++) {
			list.add(jumps[i]);
		}
		System.out.println(jump(list));
	}

}
