package SAPLabs;

public class BleakNum {

	// O(no of set bits)
	static int countSetBits(int num) {
		int count = 0;
		while (num > 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

	static int ceil(int num) {
		int count = 0;
		num--;// Important Step
		while (num > 0) {
			num = num >> 1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int num = 64;// x+countSetBits(x) then the number is bleak
		Boolean flag = false;
		for (int i = num - ceil(num); i < num; i++) {
			if (i + countSetBits(i) == num) {
				flag = true;
				/*
				 * System.out.println(i);
				 */
			}
		}
		if (flag == true) {
			System.out.println("BLEAK");
		} else {
			System.out.println("NOT BLEAK");
		}
	}

}
