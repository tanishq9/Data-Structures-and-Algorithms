package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class fractionalKnapsack {

	public static void main(String[] args) {
		int[] wts = { 10, 40, 20, 30 };
		int[] prices = { 60, 40, 100, 120 };
		int bag = 50;
		fractionalKnapsack(wts, prices, bag);
	}

	public static void fractionalKnapsack(int[] wts, int[] prices, int bag) {
		Item[] items = new Item[wts.length];
		for (int i = 0; i < wts.length; i++) {
			items[i] = new Item(wts[i], prices[i]);
		}
		Arrays.sort(items, Collections.reverseOrder());
		int itemIndex = 0;
		double profit = 0.0;
		int remainingCapacity = bag;
		while (remainingCapacity > 0) {
			if (items[itemIndex].wt <= remainingCapacity) {
				profit += items[itemIndex].price;
				remainingCapacity -= items[itemIndex].wt;
			} else {
				profit += items[itemIndex].ratio * remainingCapacity;
				remainingCapacity = 0;
			}
			itemIndex++;
		}
		System.out.println(profit);
	}

	public static class Item implements Comparable<Item> {
		int wt;
		int price;
		double ratio;

		Item(int wt, int price) {
			this.wt = wt;
			this.price = price;
			this.ratio = price * 1.0 / wt;
		}

		@Override
		public int compareTo(Item other) {
			if (this.ratio < other.ratio) {
				return -1;
			} else if (this.ratio == other.ratio) {
				return 0;
			} else {
				return 1;
			}
		}
	}

}
