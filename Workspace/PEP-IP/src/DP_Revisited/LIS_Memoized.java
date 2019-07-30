package DP_Revisited;

public class LIS_Memoized {
	static int listentrypoint(int[] arr, int point) {

		int omax = 0;
		int[] qb = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int lisendingati = listendpoint(arr, i, qb);
			omax = Math.max(omax, lisendingati);
		}
		return omax;
	}

	static int listendpoint(int[] arr, int point, int[] qb) {
		if (point == 0) {
			return 1;
		}
		if (qb[point] != 0) {
			return qb[point];
		}
		int lisendingpoint = 0;
		for (int i = 0; i < point; i++) {
			if (arr[i] < arr[point]) {
				int lisendpointati = listendpoint(arr, i, qb);
				if (lisendpointati > lisendingpoint) {
					lisendingpoint = lisendpointati;
				}
			}
		}
		lisendingpoint += 1;
		qb[point] = lisendingpoint;
		return lisendingpoint;
	}
}
