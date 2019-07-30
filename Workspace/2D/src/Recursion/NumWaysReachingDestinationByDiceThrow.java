package Recursion;

import java.util.ArrayList;

public class NumWaysReachingDestinationByDiceThrow {

	public static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		ways(4, 0, "");
		System.out.println(list.size());
	}

	private static void ways(int end, int start, String result) {
		if (start == end) {
			System.out.println(result);
			list.add(result);
		}
		if (start > end) {
			return;
		}
		for (int i = 1; i <= 3; i++) {
			ways(end, start + i, result + i);
		}
	}

}
