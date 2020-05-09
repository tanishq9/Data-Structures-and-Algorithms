package Strings;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DateConverter {

	static String IntToString(int num) {
		int rem = 0;
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			rem = num % 10;
			sb.append(rem);
			num = num / 10;
		}
		sb.reverse();
		return sb.toString();
	}

	static int StringToInt(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			int convertedWord = str.charAt(i) - '0';
			result = result * 10 + convertedWord;
		}
		return result;
	}

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		String pm = "PM";
		int j = 0;
		// First we check if PM occurs in the string or not
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == pm.charAt(j)) {
				j++;
			}
		}
		StringBuilder sb = new StringBuilder();
		// If we this is true then we have PM in the time string
		if (j == pm.length()) {
			String firstTwo = s.substring(0, 2);
			int newHours = StringToInt(firstTwo);
			if (newHours < 12) {
				newHours = 12 + StringToInt(firstTwo);
			}
			if (newHours == 12) {
				sb.append("12");
			} else {
				sb.append(IntToString(newHours));
			}
			for (int i = 2; i < s.length() - 2; i++) {
				sb.append(s.charAt(i));
			}
		} else {
			String firstTwo = s.substring(0, 2);
			int newHours = StringToInt(firstTwo);
			if (newHours == 12) {
				sb.append("00");
			} else if (newHours < 10) {
				sb.append("0"+IntToString(newHours));
			}else {
				sb.append(IntToString(newHours));
			}
			for (int i = 2; i < s.length() - 2; i++) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scan.nextLine();

		String result = timeConversion(s);
		System.out.println(result);
	}
}
