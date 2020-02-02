package Crio_Launch_HackerRank_Java;

import java.util.LinkedList;
import java.util.Scanner;

public class Java_List {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.addLast(sc.nextInt());
		}
		sc.nextLine();
		int q = sc.nextInt();
		while (q-- > 0) {
			String str = sc.next();
			sc.nextLine();
			if (str.equals("Insert")) {
				int id = sc.nextInt();
				int ele = sc.nextInt();
				list.add(id, ele);
			} else if (str.equals("Delete")) {
				int id = sc.nextInt();
				list.remove(id);
			}
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
		}
		for (int ele : list) {
			System.out.print(ele + " ");
		}
	}
}
