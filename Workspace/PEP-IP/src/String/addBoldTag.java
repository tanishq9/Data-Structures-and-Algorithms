package String;

public class addBoldTag {
	public static String addBoldTag(String s, String[] dict) {
		boolean[] visited = new boolean[s.length()];
		for (String word : dict) {
			for (int i = 0; i <= (s.length() - word.length()); i++) {
				if (s.substring(i, i + word.length()).equals(word)) {
					for (int j = i; j < i + word.length(); j++) {
						visited[j] = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int end = 0;
		while (end < s.length()) {
			if (visited[end] == true) {
				sb.append("<b>");
				while (end < s.length() && visited[end] == true) {
					sb.append(s.charAt(end++));
				}
				sb.append("</b>");
			} else {
				sb.append(s.charAt(end++));
			}
		}
		return sb.toString();
	}
}
