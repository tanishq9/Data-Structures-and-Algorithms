package Recursion;

import java.util.ArrayList;

public class mazePath {

	public static void main(String[] args) {
		int dr = 2, dc = 2;
		ArrayList<String> paths = getMazePath(0, 0, dr, dc);
		for (String path : paths) {
			// System.out.println(path);
		}
		// System.out.println(paths.size());
		ArrayList<String> paths2 = getMultiMove(0, 0, dr, dc);
		for (String path : paths2) {
			System.out.println(path);
		}
		System.out.println(paths2.size());
	}

	private static ArrayList<String> getMazePath(int cr, int cc, int dr, int dc) {
		if (cc == dc && cr == dr) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		ArrayList<String> hpaths = new ArrayList<>();
		ArrayList<String> vpaths = new ArrayList<>();
		ArrayList<String> mpaths = new ArrayList<>();

		if (cc < dc) {
			vpaths = getMazePath(cr, cc + 1, dr, dc);
		}
		if (cr < dr) {
			hpaths = getMazePath(cr + 1, cc, dr, dc);
		}
		for (int i = 0; i < hpaths.size(); i++) {
			mpaths.add("h" + hpaths.get(i));
		}
		for (int i = 0; i < vpaths.size(); i++) {
			mpaths.add("v" + vpaths.get(i));
		}
		return mpaths;
	}

	public static ArrayList<String> getMultiMove(int cr, int cc, int dr, int dc) {
		if (cc == dc && cr == dr) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		ArrayList<String> mpaths = new ArrayList<>();

		// Horizontally move
		for (int i = 1; cc + i <= dc; i++) {
			ArrayList<String> hpaths = getMultiMove(cr, cc + i, dr, dc);
			for (int j = 0; j < hpaths.size(); j++) {
				mpaths.add("h" + String.valueOf(i) + hpaths.get(j));
			}
		}
		// Vertically move
		for (int i = 1; cr + i <= dr; i++) {
			ArrayList<String> vpaths = getMultiMove(cr + i, cc, dr, dc);
			for (int j = 0; j < vpaths.size(); j++) {
				mpaths.add("v" + String.valueOf(i) + vpaths.get(j));
			}
		}
		// Diagonal moves
		for (int i = 1; cr + i <= dr && cc + i <= dc; i++) {
			ArrayList<String> diagonal = getMultiMove(cr + i, cc + i, dr, dc);
			for (int j = 0; j < diagonal.size(); j++) {
				mpaths.add("d" + String.valueOf(i) + diagonal.get(j));
			}
		}

		return mpaths;

	}

}
