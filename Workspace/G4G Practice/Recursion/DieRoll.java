package RecursionClassics;

public class DieRoll {

	static int total = 0;

	public static void main(String[] args) {
		roll(5, 0, "");
		System.out.println();
		System.out.println(total);
	}

	static void roll(int target, int currentSum, String result) {
		if (currentSum == target) {
			System.out.print(result + " ");
			total += 1;
			return;
		}
		if (currentSum > target) {
			return;
		}
		for (int i = 1; i <= 6; i++) {
			roll(target, currentSum + i, result + String.valueOf(i));
		}
	}
	
}
