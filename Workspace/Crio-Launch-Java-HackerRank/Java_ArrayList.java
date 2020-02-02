package Crio_Launch_HackerRank_Java;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_ArrayList {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		ArrayList<int[]> list = new ArrayList<>();
		int n = sc.nextInt();
		sc.nextLine();
		while (n-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			if (size > 0) {
				for (int i = 0; i < size; i++) {
					arr[i] = sc.nextInt();
				}
				list.add(arr);
			} else {
				list.add(null);
			}
			sc.nextLine();
		}
		int q = sc.nextInt();
		while (q-- > 0) {
			int id = sc.nextInt();
			int eleid = sc.nextInt();
			if (list.get(id - 1) == null || eleid > list.get(id - 1).length) {
				System.out.println("ERROR!");
			} else {
				System.out.println(list.get(id - 1)[eleid - 1]);
			}
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
		}
	}
}
