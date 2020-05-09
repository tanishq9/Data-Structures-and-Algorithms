package Recursion;

import java.util.ArrayList;

public class mazePathArrayList {

	public static void main(String[] args) {
		int m = 2;
		int n = 2;
		ArrayList<String> result = getMazePath(0, 0, m, n);
		System.out.println(result);
		gmp(0, 0, 2, 2, "");
		multiMove(0, 0, 2, 2, "");
	}

	public static void gmp(int cr, int cc, int dr, int dc, String psf) {
		if (cr == dr && cc == dc) {
			System.out.println(psf);
			return;
		}
		if (cc < dc) {
			gmp(cr, cc + 1, dr, dc, psf + "h");
		}
		if (cr < dr) {
			gmp(cr + 1, cc, dr, dc, psf + "v");
		}
	}

	// Doing Work in post area of recursive call
	public static ArrayList<String> getMazePath(int cr, int cc, int dr, int dc) {
		if (cc == dc && cr == dr) {
			ArrayList<String> list = new ArrayList<>();
			list.add(""); // Important step : It signifies that we can go nowhere from here
			// There we add Null move
			return list;
		}
		ArrayList<String> hpaths = new ArrayList<>();
		ArrayList<String> vpaths = new ArrayList<>();
		ArrayList<String> mpaths = new ArrayList<>();
		if (cc < dc) {
			hpaths = getMazePath(cr, cc + 1, dr, dc);
		}
		if (cr < dr) {
			vpaths = getMazePath(cr + 1, cc, dr, dc);
		}
		for (int i = 0; i < hpaths.size(); i++) {
			mpaths.add("h" + hpaths.get(i));
		}
		for (int i = 0; i < vpaths.size(); i++) {
			mpaths.add("v" + vpaths.get(i));
		}
		return mpaths;
	}

	public static void multiMove(int cr, int cc, int dr, int dc, String psf) {
		if (cc == dc && cr == dr) {
			System.out.println(psf);
			return;
		}
		for (int ma = 1; ma <= dc - cc; ma++) {
			multiMove(cr, cc + ma, dr, dc, psf + "H" + ma);
		}
		for (int ma = 1; ma <= dr - cr; ma++) {
			multiMove(cr + ma, cc, dr, dc, psf + "V" + ma);
		}
		for (int ma = 1; ma <= dc - cc && ma <= dr - cr; ma++) {
			multiMove(cr + ma, cc + ma, dr, dc, psf + "D" + ma);
		}
	}

}
