package BinarySearch;

public class upperBoundAndLowerBound {
	public int[] searchRange(int[] nums, int target) {
		int fo = bslb(nums, target);
		int lo = bsub(nums, target);
		if (fo == -1 && lo == -1) {
			return new int[] { -1, -1 };
		} else {
			return new int[] { fo, lo };
		}
	}

	public int bslb(int[] arr, int target) {
		int lo = 0;
		int ans = -1;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] < target) {
				lo = mid + 1;
			} else if (arr[mid] == target) {
				ans = mid;
				hi = mid - 1; // keep computing dont return
			} else {
				hi = mid - 1;
			}
		}
		return ans;
	}

	public int bsub(int[] arr, int target) {
		int lo = 0;
		int ans = -1;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] < target) {
				lo = mid + 1;
			} else if (arr[mid] == target) {
				ans = mid;
				lo = mid + 1; // keep computing dont return
			} else {
				hi = mid - 1;
			}
		}
		return ans;
	}
}
