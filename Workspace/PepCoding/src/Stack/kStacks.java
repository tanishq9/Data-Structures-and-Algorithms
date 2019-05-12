package Stack;

import java.util.Arrays;

public class kStacks {

	static class kStack {
		int[] ptrArray = null;
		int[] refArray = null;
		int[] dataArray = null;
		int freeIndex = 0;
		int capacity;

		kStack(int cap, int k) {
			this.capacity = cap;
			ptrArray = new int[k + 1];
			dataArray = new int[cap];
			refArray = new int[cap];
			Arrays.fill(ptrArray, -1);
			for (int i = 0; i < cap; i++) {
				refArray[i] = i + 1;
			}
			refArray[cap - 1] = -1;
		}

		void push(int k, char cc) {
			// Find free index
			if (isFull() == true) {
				// Overflow
			} else {
				// removeFirst on free and addFirst on stack
				int oldFree = freeIndex;
				int newFree = refArray[oldFree];
				int csh = ptrArray[k];
				int nsh = oldFree;

				freeIndex = newFree;
				refArray[nsh] = csh;
				ptrArray[k] = nsh;

				dataArray[nsh] = cc;
			}
		}

		void pop(int k) {
			if (ptrArray[k] == -1) {
				// Underflow
			} else {
				// variables
				int nshead = ptrArray[refArray[k]];
				int nfhead = ptrArray[k];
				// updates;
				ptrArray[k] = nshead;
				refArray[nshead] = nshead;
				freeIndex = nfhead;
			}
		}

		boolean isFull() {
			return freeIndex == -1;
		}

	}

	public static void main(String[] args) {
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o' };
		kStack ks = new kStack(16, 5);
		ks.push(2, 'a');
		ks.push(2, 'b');
	}

}
