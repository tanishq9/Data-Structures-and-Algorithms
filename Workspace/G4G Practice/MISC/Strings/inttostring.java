package Strings;

public class inttostring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 12345, rem = 0;
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			rem = num % 10;
			sb.append(rem);
			num = num / 10;
		}
		sb.reverse();
		System.out.println(sb.toString());
	}

}
