package Strings;

public class Pangrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "We promptly judged antique ivory buckles for the next prize".toLowerCase();
		int[] countAlpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				countAlpha[(int) s.charAt(i) - 97]++;
			}
		}
		for (int i = 0; i < countAlpha.length; i++) {
			// System.out.print(countAlpha[i]+" ");
			if (countAlpha[i] == 0) {
				System.out.println("no");
			}
		}
		System.out.println("yes");
	}

}
