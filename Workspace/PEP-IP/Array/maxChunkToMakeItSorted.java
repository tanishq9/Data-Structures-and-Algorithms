package Array;

public class maxChunkToMakeItSorted {
	public int maxChunksToSorted(int[] arr) {
		int[] lmax = new int[arr.length];
		lmax[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			lmax[i] = Math.max(lmax[i - 1], arr[i]);
		}
		int[] rmin = new int[arr.length];
		rmin[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			rmin[i] = Math.min(rmin[i + 1], arr[i]);
		}
		int chunk = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (lmax[i] <= rmin[i + 1]) {
				chunk++;
			}
		}

		return chunk + 1;
	}

	// left right
	// [......max] [min......]
	// if max is greater than min, then the array cannot be a sorted one after they
	// are // concatenated. So it must hold that max in the left is either smaller
	// or the same // as the min element on the right chunk.

}
