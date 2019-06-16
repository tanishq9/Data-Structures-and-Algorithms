package Graph;

import java.util.HashMap;

public class cloneLLUsingHashMap {

	class Node {
		int data;
		Node next, arb;

		Node(int d) {
			next = arb = null;

		}
	}

	Node copyList(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		Node temp = head;
		while (temp != null) {
			map.put(temp, new Node(temp.data));
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			Node cloned = map.get(temp);
			cloned.next = map.get(temp.next);
			System.out.println(map.get(temp.next));
			cloned.arb = map.get(temp.arb);
			temp = temp.next;
		}
		return map.get(head);
	}
}
