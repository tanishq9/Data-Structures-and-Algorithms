	class Solution {
		public boolean canReach(int[] arr, int start) {
			return f(arr, start, arr.length, new HashSet<>());
		}

		boolean f(int[] arr, int current, int len, HashSet<Integer> set) {
			if (arr[current] == 0) {
				return true;
			}
			// add to the set so that we wont process that index again
			set.add(current);
			int jp = arr[current];
			// get the next and prev index
			int nextIndex = current + jp;
			int prevIndex = current - jp;

			// check if nextIndex is not the index we already processed
			if (nextIndex < len && !set.contains(nextIndex)) {
				boolean isZero = f(arr, nextIndex, len, set);
				if (isZero == true) {
					return true;
				}
			}

			// check if prevIndex is not the index we already processed
			if (prevIndex >= 0 && !set.contains(prevIndex)) {
				boolean isZero = f(arr, prevIndex, len, set);
				if (isZero == true) {
					return true;
				}
            }
			return false;
		}
	}