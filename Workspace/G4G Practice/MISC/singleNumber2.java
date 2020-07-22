package IBit;

import java.util.ArrayList;

public class singleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(1);
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(2);
		A.add(3);
		int[] arr = new int[32];
		for (int i = 0; i < A.size(); i++) {
			int current = A.get(i);
			int index = 0;
			while (current > 0) {
				if ((current & 1) == 1) {
					arr[index] += 1;
				}
				index++;
				current = current >> 1;
			}
		}
		for (int i = 0; i < 32; i++) {
			arr[i] %= 3;
		}
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			ans += arr[i] * Math.pow(2, i);
		}
		System.out.println(ans);
	}

}
