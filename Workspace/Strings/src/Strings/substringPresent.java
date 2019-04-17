package Strings;

public class substringPresent {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hi";
		Boolean flag = false;
		for (int i = 0; i < s2.length(); i++) {
			for (int j = 0; j < s1.length(); j++) {
				if (s2.charAt(i) == s1.charAt(j)) {
					flag = true;
					break;
				}
			}
		}
		if (flag == false) {
			System.out.println("Not present");
		} else {
			System.out.println("Present");
		}
	}

}
