package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class flipGame {
	public static List<String> generatePossibleNextMoves(String s) {
		// Write your code here
		List<String> list = new ArrayList<String>();
		char[] arr = s.toCharArray();
		for (int i = 0; i <= (arr.length - 2); i++) {
			if (arr[i] == '+' && arr[i + 1] == '+') {
				// Update
				arr[i] = '-';
				arr[i + 1] = '-';
				list.add(String.valueOf(arr));
				// Reset
				arr[i] = '+';
				arr[i + 1] = '+';
			}
		}
		return list;
	}
	 public static void main(String[] args) {
 	 	 Scanner scn = new Scanner(System.in);
 	 	 String s = scn.next();
 	 	 List<String> res = generatePossibleNextMoves(s);
 	 	 System.out.print(res);
 	 }
}
