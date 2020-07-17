package Recursion_Pep_Online;

public class maze_mulit_moves {
	public static void main(String[] args) {
		multiMoves(0, 0, 2, 2, "");
	}

	static int counter = 0;

	static void multiMoves(int sr, int sc, int dr, int dc, String psf) {

		if (sr == dr && sc == dc) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		// move right until there is scope
		for (int j = 1; j <= dc - sc; j++) {
			multiMoves(sr, sc + j, dr, dc, psf + "H" + j);
		}
		// move down until there is scope
		for (int i = 1; i <= dr - sr; i++) {
			multiMoves(sr + i, sc, dr, dc, psf + "V" + i);
		}
		// move diagonal until there is scope
		for (int k = 1; k <= dr - sc && k <= dc - sc; k++) {
			multiMoves(sr + k, sc + k, dr, dc, psf + "D" + k);
		}
	}

	// Pro Active Approach
	static void movesNormal(int sr, int sc, int dr, int dc, String psf) {

		if (sr == dr && sc == dc) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		if (sr + 1 <= dr) {
			movesNormal(sr + 1, sc, dr, dc, psf);
		}
		if (sc + 1 <= dc) {
			movesNormal(sr, sc + 1, dr, dc, psf);
		}
	}

}
