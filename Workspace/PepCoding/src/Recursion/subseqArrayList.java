package Recursion;

import java.util.ArrayList;

public class subseqArrayList {

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> result = getSubseq(str);
		System.out.println(result);
	}

	// Doing Work in post area of recursive call
	public static ArrayList<String> getSubseq(String str) {
		// Low Level : Stack trace and Base case
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;// Return ArrayList with Blank string
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		// High Level : Expectation and Faith part
		ArrayList<String> recResult = getSubseq(ros);
		ArrayList<String> myResult = new ArrayList<>();
		for (String s : recResult) {
			myResult.add(s);
			myResult.add(s + cc);
		}
		return myResult;
	}

}
