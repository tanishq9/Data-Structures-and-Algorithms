package Strings;

import java.util.Scanner;

public class DeletionsTomakeAnagrams {

	private static final int ALPHABETS = 26;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String first = s.nextLine();
		String second = s.nextLine();
		int[] charFirst = getCharsCount(first);
		int[] charSecond = getCharsCount(second);
		System.out.println(delta(charFirst, charSecond));
	}

	private static int delta(int[] charFirst, int[] charSecond) {
		if (charFirst.length != charSecond.length) {
			return -1;// Error handling
		}
		int difference = 0;
		for (int i = 0; i < charFirst.length; i++) {
			difference += Math.abs(charFirst[i] - charSecond[i]);
		}
		return difference;
	}

	private static int[] getCharsCount(String first) {
		int[] charCount = new int[ALPHABETS];
		for (int i = 0; i < first.length(); i++) {
			char cc = first.charAt(i);
			int code = cc - (int) 'a';
			charCount[code]++;
		}
		return charCount;
	}

}
