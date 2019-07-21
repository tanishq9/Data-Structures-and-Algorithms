package BinaryTree;

public class numberLeafNodesInKAryTree {
	static int mod = (int) (1e9 + 7);

	private static long kAryTree(int k, int height) {
		// k^m
		if (height == 0) {
			return 1;
		}
		long pow = kAryTree(k, height / 2);
		if (height % 2 == 1) {
			return (((pow * pow) % mod) * k) % mod;
		} else {
			return (pow * pow) % mod;
		}
	}

}
