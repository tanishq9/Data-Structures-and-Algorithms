package Recursion;

import java.util.ArrayList;
import java.util.Comparator;

public class permute {

	static class myComparator implements Comparator<String> {
		public int compare(String one, String two) {
			return two.compareTo(one);
		}
	}

	private static ArrayList<String> list;

	private static void genPer(StringBuilder str, int i) {
		if (i >= str.length()) {
			list.add(str.toString());
			// System.out.println(str);
			return;
		}
		for (int j = i; j < str.length(); j++) {
			swap(str, i, j);
			genPer(str, i + 1);
			swap(str, i, j);
		}
	}

	private static void swap(StringBuilder str, int i, int j) {
		char ivala = str.charAt(i);
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j, ivala);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("abc");
		list=new ArrayList<>();
		genPer(str, 0);
		list.sort(new myComparator());
		System.out.println(list);
	}

}
