package BinarySearch;

public class T2_badVersion {
	public int firstBadVersion(int n) {
		/*
		 * When assigning right = mid, cannot do right = mid -1, because at this point
		 * that mid value might be the earliest bad version. However, if at one point it
		 * is not a bad version, the first bad version must be on the right side. That's
		 * why we assign left = mid + 1.
		 */
		int start = 1, end = n;
		while (start < end) { // condition start<end | start=mid+1 | end=mid
			int mid = start + (end - start) / 2;
			if (isBadVersion(mid) == true) {
				// keep narrowing down
				end = mid;
			} else if (isBadVersion(mid) == false) {
				start = mid + 1;
			}
		}
		// Post processing start == end
		return start;
	}

	public int firstBadVersion2(int n) {
		int start = 1, end = n, ans = -1;
		while (start <= end) { // condition start<end | start=mid+1 | end=mid
			int mid = start + (end - start) / 2;
			if (isBadVersion(mid) == true) {
				// keep narrowing down
				end = mid - 1;
				ans = mid;
			} else if (isBadVersion(mid) == false) {
				start = mid + 1;
			}
		}
		return ans;
	}

	boolean isBadVersion(int n) {
		return true;
	}
}
