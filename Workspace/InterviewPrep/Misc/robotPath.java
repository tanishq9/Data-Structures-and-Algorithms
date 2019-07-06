package Misc;

public class robotPath {
	class Solution {
		public boolean isRobotBounded(String instructions) {
			int dir = 0, i = 0, j = 0;
			for (char cc : instructions.toCharArray()) {
				if (cc == 'G') {
					if (dir == 0) {
						j++;
					} else if (dir == 1) {
						i++;
					} else if (dir == 2) {
						j--;
					} else if (dir == 3) {
						i--;
					}
				} else if (cc == 'L') {
					dir--;
				} else if (cc == 'R') {
					dir++;
				}
				dir = (dir % 4 + 4) % 4;
			}
			return dir != 0 || (i == 0 && j == 0);
		}
	}

	public static void main(String[] args) {
		System.out.println(Math.sqrt(20));
	}
}
