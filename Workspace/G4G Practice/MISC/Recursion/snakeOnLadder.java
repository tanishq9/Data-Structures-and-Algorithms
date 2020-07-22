package Recursion;

import java.util.ArrayList;
import java.util.Comparator;

public class snakeOnLadder {
	
	static class Item {
		int price;
		int weight;

		Item(int p, int w) {
			this.price = p;
			this.weight = w;
		}
	}

	static class CustomComparator implements Comparator<Item> {
		public int compare(Item one, Item two) {
			if (one.price / one.weight > two.price / two.weight) {
				return -1;
			}
			return 1;
		}
	}

	public static void main(String[] args) {
		int target = 5;
		int k = 3;
		int[] arr = new int[4];
		ArrayList<Item> list = new ArrayList<>();
		list.sort(new CustomComparator());
	}

}
