package Array;

import java.util.Arrays;
import java.util.LinkedList;

public class revealCardInIncreasingOrder {
	public int[] deckRevealedIncreasing(int[] deck) {
		// Logic : Assign card to alternate indexes because
		// that is the order of revealing
		Arrays.sort(deck); // Sort the array
		LinkedList<Integer> index = new LinkedList<>();
		for (int i = 0; i < deck.length; i++) {
			index.addLast(i);
		}
		int[] order = new int[deck.length];
		for (int card : deck) {
			order[index.removeFirst()] = card;
			// Alternately assign the indexes : 0,2,4... as it the order of revealing
			if (index.size() > 0) {
				index.addLast(index.removeFirst());
			}
		}
		return order;
	}
}
