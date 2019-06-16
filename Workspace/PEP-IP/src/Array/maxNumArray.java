package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class maxNumArray {
	public static void main(String[] args) {
		String s1 = "95";
		String s2 = "59";
		for (int i = 0; i < s1.length(); i++) {
			System.out.println((int)s1.charAt(i)-(int)s2.charAt(i));
		}
		System.out.println(s1.compareTo(s2));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {// 1 3 9 5 8
				list.add(sc.nextInt());
			}
			System.out.println(maxNum(list));
		}
	}

	static String maxNum(ArrayList<Integer> list) {

		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				String op1 = first + "" + second;
				String op2 = second + "" + first;
				System.out.print(op1 + " " + op2 + " ");
				System.out.println(op1.compareTo(op2));
				return op1.compareTo(op2) > 0 ? -1 : 1;
			}
		});

		String str = "";
		for (int i = 0; i < list.size(); i++) {
			str += list.get(i);
		}
		return str;
	}
}
