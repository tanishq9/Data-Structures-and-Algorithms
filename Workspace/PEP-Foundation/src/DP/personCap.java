package DP;

import java.util.ArrayList;

public class personCap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int caps = 100;
		int persons = 3;
		ArrayList<Integer>[] pcmap = new ArrayList[persons]; // 3 persons
		pcmap[0] = new ArrayList<>();
		pcmap[0].add(5);
		pcmap[0].add(7);
		pcmap[0].add(100);
		pcmap[1] = new ArrayList<>();
		pcmap[1].add(2);
		pcmap[1].add(7);
		pcmap[2] = new ArrayList<>();
		pcmap[2].add(100);
		pcmap[2].add(5);

		boolean[] captaken = new boolean[caps + 1];
		System.out.println("Using Boolean Array : " + countWays2(pcmap, 0, captaken));
		System.out.println("Using Bitmasking : " + countWays(pcmap, 0, 0));
	}

	// Similar to permutations
	// p is the level of the person
	// in backtracking we talk about level and options
	private static int countWays(ArrayList<Integer>[] pcmap, int p, int ctmask) {
		if (p == pcmap.length) {
			return 1;
		}
		int total = 0;
		for (int cap : pcmap[p]) {
			if ((ctmask & (1 << cap)) == 0) { // using & for checking availability
				ctmask = ctmask ^ (1 << cap); // making cap unavailable ,toggling using ^
				total += countWays(pcmap, p + 1, ctmask);
				ctmask = ctmask ^ (1 << cap); // making cap available,toggling using ^
			}
		}
		return total;
	}

	private static int countWays2(ArrayList<Integer>[] pcmap, int p, boolean[] ct) {
		if (p == pcmap.length) {
			return 1;
		}
		int total = 0;
		for (int cap : pcmap[p]) {
			if (ct[cap] == false) { // using & for checking availability
				ct[cap] = true; // making cap unavailable ,toggling using ^
				total += countWays2(pcmap, p + 1, ct);
				ct[cap] = false; // making cap available,toggling using ^
			}
		}
		return total;
	}

}
