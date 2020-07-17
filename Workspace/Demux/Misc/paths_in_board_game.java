package Recursion_Pep_Online;

public class paths_in_board_game {
	static int counter = 0;

	public static void main(String[] args) {
		// pbpProActive(0, 10, "");
		pbpStarting16Only(0, 10, "");
	}

	public static void pbpReactive(int src, int dest, String psf) {
		if (src > dest) {
			return;
		}
		if (src == dest) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			pbpReactive(src + dice, dest, psf + dice + " ");
		}
	}

	public static void pbpProActive(int src, int dest, String psf) {
		if (src == dest) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			if (src + dice <= dest) {
				pbpProActive(src + dice, dest, psf + dice + " ");
			}
		}
	}

	static void pbpStarting16Only(int src, int dest, String psf) {
		if (src == dest) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			if (src + dice <= dest) {
				if (psf.length() == 0) {
					// the first character of psf tells how the user got entry in the game
					// i.e by getting 1 or 6
					if (dice == 1 || dice == 6) {
						// src+1 because entry 1 ya 6 se hoti hai par move +1 hi hota hai
						// and not src+6 incase of 6
						pbpStarting16Only(src + 1, dest, psf + dice + " ");
					}
				} else {
					pbpStarting16Only(src + dice, dest, psf + dice + " ");
				}
			}
		}
	}
}
