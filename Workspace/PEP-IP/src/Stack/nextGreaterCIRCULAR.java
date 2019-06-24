package Stack;

import java.util.Stack;

public class nextGreaterCIRCULAR {
	public static int[] nextGreaterCircularInManner(int[] nums) {
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();
		int[] nge = new int[n];
		stack.push(nums[n - 1]);
		for (int i = 2 * n - 1; i >= 0; i--) {
			while (stack.size() > 0 && stack.peek() <= nums[i % n]) {
				stack.pop();
			}
			nge[i % n] = stack.size() > 0 ? stack.peek() : -1;
			stack.push(nums[i % n]);
		}
		return nge;
	}
}
