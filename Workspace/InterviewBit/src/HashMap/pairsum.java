package HashMap;

import java.util.*;

public class pairsum {

	public static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		Integer arr1[] = new Integer[n1];

		for (int i = 0; i < n1; i++)
			arr1[i] = sc.nextInt();

		int n2 = sc.nextInt();
		Integer arr2[] = new Integer[n2];

		for (int i = 0; i < n2; i++)
			arr2[i] = sc.nextInt();

		LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
		LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));

		int x = sc.nextInt();

		System.out.println(countpair(head1, head2, x));
	}

	// you just need to complete this function
	public static int countpair(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < head1.size(); i++) {
			int val = head1.get(i);
			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}
		System.out.println(map);
		int count = 0;
		for (int i = 0; i < head2.size(); i++) {
			int val = head2.get(i);
			int val2 = x - val;
			if (map.containsKey(x - val)) {
				count += 1;
				System.out.println(val + " " + val2);
			}
		}
		return count;
	}

}
