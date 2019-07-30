package Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class killingProcess {
	public static ArrayList<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < pid.size(); i++) {
			if (!map.containsKey(ppid.get(i))) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(pid.get(i));
				map.put(ppid.get(i), list);
			} else {
				ArrayList<Integer> list = map.get(ppid.get(i));
				list.add(pid.get(i));
				map.put(ppid.get(i), list);
			}
		}
		LinkedList<Integer> q = new LinkedList<>();
		ArrayList<Integer> l = new ArrayList<>();
		q.add(kill);
		while (q.size() > 0) {
			int top = q.remove();
			l.add(top);
			if (map.containsKey(top)) {
				for (int child : map.get(top)) {
					q.add(child);
				}
			}
		}
		return l;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> pid = new ArrayList<>(n);
		List<Integer> ppid = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			pid.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			ppid.add(sc.nextInt());
		}
		ArrayList<Integer> res = (ArrayList<Integer>) killProcess(pid, ppid, k);
		Collections.sort(res);
		System.out.println(res);
	}

}
