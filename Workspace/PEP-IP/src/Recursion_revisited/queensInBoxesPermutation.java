package Recursion_revisited;

public class queensInBoxesPermutation {

	static int count = 0;

	static void ways(int n, int q) {
		boolean[] placed = new boolean[n];
		count = 0;
		waysHelper(placed, q);
		System.out.println(count);
		// level mei queens hai
		// options mei boxes hai
	}

	static void waysHelper(boolean[] placed, int qToBePlaced) {
		if (qToBePlaced == 0) {
			int number = 1;
			for (int i = 0; i < placed.length; i++) {
				if (placed[i] == false) {
					System.out.print("-");
				} else {
					System.out.print("Q" + number++);
				}
			}
			System.out.println();
			count++;
		}
		// place the queen
		for (int i = 0; i < placed.length; i++) {
			if (placed[i] == false) {
				placed[i] = true;
				waysHelper(placed, qToBePlaced - 1);
				// backtracking step
				placed[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		ways(4, 2);
	}
}
