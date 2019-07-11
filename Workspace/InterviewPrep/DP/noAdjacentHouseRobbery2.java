package DP;

public class noAdjacentHouseRobbery2 {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(rob0(nums), rob1(nums));
	}

	int rob0(int[] nums) {
		int in = nums[0];
		int ex = 0;
		for (int i = 1; i <= nums.length - 2; i++) {
			int previnc = in;
			int prevex = ex;
			in = prevex + nums[i];
			ex = Math.max(previnc, prevex);
		}
		return Math.max(in, ex);
	}

	int rob1(int[] nums) {
		int in = nums[1];
		int ex = 0;
		for (int i = 2; i <= nums.length - 1; i++) {
			int previnc = in;
			int prevex = ex;
			in = prevex + nums[i];
			ex = Math.max(prevex, previnc);
		}
		return Math.max(in, ex);
	}
}
