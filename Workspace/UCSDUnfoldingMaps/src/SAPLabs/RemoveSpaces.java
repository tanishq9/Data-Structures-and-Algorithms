package SAPLabs;

public class RemoveSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		String str = "ge eks f o   r g e e ks";
		char[] chars = str.toCharArray();
		chars[1] = 'w';
		str = String.valueOf(chars);
		StringBuilder string = new StringBuilder(str);// this is mutable
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				string.setCharAt(count, str.charAt(i));
				count++;
			}
		}
		string.setLength(count);
		// System.out.println(count);
		System.out.println(string.toString());
	}

}
