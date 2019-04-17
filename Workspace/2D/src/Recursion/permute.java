package Recursion;

public class permute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	permute(new StringBuilder("str"), 0);
		permutations("str");
	}

	public static void permutations(String input){
		StringBuilder sb=new StringBuilder(input);
		permute(sb,0);
	}
    private static void permute(StringBuilder string, int i) {
          if(i>=string.length()) {
              System.out.println(string);
              return;
          }
          for (int j = i; j < string.length(); j++) {
              swap(string, i, j);
              permute(string, i + 1);
              swap(string, i, j);
          }
      }

      private static void swap(StringBuilder str, int i, int j) {
          char ivala = str.charAt(i);
          str.setCharAt(i, str.charAt(j));
          str.setCharAt(j, ivala);
      }
}
