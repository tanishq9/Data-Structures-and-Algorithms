package Stack;

import java.util.Scanner;
import java.util.Stack;

public class nextGreaterNode {

	private static int size(ListNode head) {
		ListNode temp = head;
		int i = 0;
		while (temp != null) {
			temp = temp.next;
			i++;
		}
		return i;
	}

	static class Pair {
		int val;
		int index;

		Pair(int iv, int ii) {
			this.val = iv;
			this.index = ii;
		}
	}

	public static void nextLargerNodes(ListNode head) {
		int n = size(head);
		
		int[] nge = new int[n];
		nge[0] = 0;

		ListNode temp = head;
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(temp.val, 0));
		temp = temp.next;

		for (int i = 1; i < n; i++) {
			while (stack.size() > 0 && stack.peek().val < temp.val) {
				nge[stack.pop().index] = temp.val;
			}
			stack.push(new Pair(temp.val, i));
			temp = temp.next;
		}
		while (stack.size() > 0) {
			nge[stack.pop().index] = 0;
		}
		for (int i = 0; i < nge.length; i++) {
			System.out.print(nge[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int headval = sc.nextInt();
		ListNode head = new ListNode(headval);
		ListNode tail = head;
		for (int i = 1; i < size; i++) {
			ListNode curr = new ListNode(sc.nextInt());
			tail.next = curr;
			tail = curr;
		}
		nextLargerNodes(head);
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
