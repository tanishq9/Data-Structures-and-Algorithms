package Strings;

public class maxFreqAlter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] countArr = new int[256];// 256 is ascii size
		String str = "striiiinggg";
		for (int i = 0; i < str.length(); i++) {
			countArr[str.charAt(i)]++;
		}
		int max = -1;
		char result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (max < countArr[str.charAt(i)]) {
				max = countArr[str.charAt(i)];
				result = str.charAt(i);
			}
		}
		System.out.println(result);
	}

}
