package IBit;

import java.util.ArrayList;

public class permutationInList {

	public static void main(String[] args) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		temp.add(2);
		temp.add(3);
	}

	ArrayList<ArrayList<Integer>> list = null;

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		list = new ArrayList<ArrayList<Integer>>();
		StringBuilder sb = new StringBuilder();
		for (Integer i : A) {
			sb.append(String.valueOf(i));
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		genPermutations(sb, temp, 0);
		return list;
	}

	private void genPermutations(StringBuilder sb, ArrayList<Integer> temp, int i) {
		if (i == sb.length()) {
			list.add(temp);
			return;
		}
		for (int j = i; j != sb.length(); j++) {
			swap(sb, i, j);
			temp.add(Integer.valueOf(sb.charAt(j)));
			genPermutations(sb, temp, i + 1);
			swap(sb, i, j);
		}
	}

	private void swap(StringBuilder sb, int i, int j) {
		char t = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, t);
	}
}
