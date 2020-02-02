package RQ;

public class segmentTrees {

	static int[] oba;
	static int[] sa;
	static int[] lazy;

	public static void preprocess(int[] ba) {
		oba = ba;
		int height = getCeil(oba.length);
		int sa_size = (1 << (height + 1)) - 1;
		sa = new int[sa_size];
		lazy = new int[sa_size];
		buildTree(0, 0, oba.length - 1);
	}

	private static void buildTree(int si, int ss, int se) {
		if (ss == se) {
			sa[si] = oba[ss];
			return;
		}
		int mid = (ss + se) / 2;
		buildTree(2 * si + 1, ss, mid);
		buildTree(2 * si + 2, mid + 1, se);
		sa[si] = operation(sa[2 * si + 1], sa[2 * si + 2]);
	}

	private static int getCeil(int n) {
		int log = 0;
		while ((1 << log) < n) {
			log++;
		}
		return log;
	}

	private static void update(int idx, int si, int ss, int se, int nval) {
		if (ss == se) {
			oba[idx] = nval;
			sa[si] = nval;
			return;
		}

		int mid = (ss + se) / 2;
		if (idx <= mid) {
			update(idx, 2 * si + 1, ss, mid, nval);
		} else {
			update(idx, 2 * si + 2, mid + 1, se, nval);
		}
		sa[si] = operation(sa[2 * si + 1], sa[2 * si + 2]);
	}

	public static void update(int idx, int nval) {
		update(idx, 0, 0, oba.length - 1, nval);
	}

	public static int query(int qs, int qe) {
		return query(qs, qe, 0, 0, oba.length - 1);
	}

	private static int query(int qs, int qe, int si, int ss, int se) {
		// No overlap
		if (se < qs || ss > qe) {
			return identity(); // identity
		}
		// Complete overlap
		else if (ss >= qs && qe >= se) {
			return sa[si];
		} else {
			int mid = (ss + se) / 2;
			int lc = query(qs, qe, 2 * si + 1, ss, mid);
			int rc = query(qs, qe, 2 * si + 2, mid + 1, se);
			return operation(lc, rc);
		}
	}

	private static void handlependingupdates(int si, int ss, int se) {
		sa[si] += (se - ss + 1) * lazy[si];
		sa[2 * si + 1] += lazy[si];
		sa[2 * si + 1] += lazy[si];
		lazy[si] = 0;
	}

	public static void update2(int qs, int qe, int nval) {
		update2(qs, qe, 0, 0, oba.length - 1, nval);
	}

	public static int query2(int qs, int qe) {
		return query2(qs, qe, 0, 0, oba.length - 1);
	}

	private static void update2(int qs, int qe, int si, int ss, int se, int nval) {
		// No overlap
		if (se < qs || ss > qe) {
			// identity
			return;
		}
		// Complete overlap
		else if (ss >= qs && qe >= se) {
			lazy[si] = nval;
			handlependingupdates(si, ss, se);
			// return sa[si];
		} else {
			int mid = (ss + se) / 2;
			update2(qs, qe, 2 * si + 1, ss, mid, nval);
			update2(qs, qe, 2 * si + 2, mid + 1, se, nval);
			sa[si] = operation(sa[2 * si + 1], sa[2 * si + 2]);
		}
	}

	private static int query2(int qs, int qe, int si, int ss, int se) {
		handlependingupdates(si, ss, se);
		// No overlap
		if (se < qs || ss > qe) {
			return identity(); // identity
		}
		// Complete overlap
		else if (ss >= qs && qe >= se) {
			return sa[si];
		} else {
			int mid = (ss + se) / 2;
			int lc = query2(qs, qe, 2 * si + 1, ss, mid);
			int rc = query2(qs, qe, 2 * si + 2, mid + 1, se);
			return operation(lc, rc);
		}
	}

	private static void printSeg() {
		for (int i = 0; i < sa.length; i++) {
			System.out.print(sa[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] ba = { -3, 4, 5, 7, 1, 9, 8, 2 };
		System.out.println("Before Update : ");
		preprocess(ba);
		printSeg();
		System.out.println(query(0, 2));
		update(2, 10);
		System.out.println();
		System.out.println("After Update : ");
		printSeg();
		System.out.println(query(0, 2));

		int[] ca = { -3, 4, 5, 7, 1, 9, 8, 2 };
		System.out.println("Before Update : ");
		preprocess(ca);
		printSeg();
		update2(0, 7, 2);
		printSeg();
		System.out.println(query2(0, 7));

	}

	private static int identity() {
		return 0; // for sum
	}

	private static int operation(int lhs, int rhs) {
		return lhs + rhs; // for sum
	}

}
