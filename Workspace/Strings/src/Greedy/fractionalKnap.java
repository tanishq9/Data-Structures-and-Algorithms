package Greedy;

import java.util.ArrayList;
import java.util.Comparator;

/* This is our Item class and it has 2 attributes which are price and weight */
class Item {
	int price;
	int weight;

	Item(int p, int w) {
		this.price = p;
		this.weight = w;
	}
}

/*
 * We define our own custom comparator in which we sort on the basis of
 * price/weight ratio
 */
class CustomComparator implements Comparator<Item> {
	public int compare(Item one, Item two) {
		if (one.price / one.weight > two.price / two.weight) {
			return -1;
		}
		return 1;
	}
}

public class fractionalKnap {
	private static int fractionalKnapsack(int total_capacity, ArrayList<Item> arr) {
		int current_capacity = 0, maximumProfit = 0;
		for (Item item : arr) {
			if ((current_capacity + item.weight) <= total_capacity) {
				current_capacity += item.weight;
				maximumProfit += item.price;
			} else {
				int remaining = total_capacity - current_capacity;
				int remain_cost = (remaining * item.price / item.weight);
				maximumProfit += remain_cost;
			}
		}
		return maximumProfit;
	}

	public static void main(String[] args) {
		int W = 50;// Weight of knapsack
		int[][] arr = { { 60, 10 }, { 100, 20 }, { 120, 30 } };
		ArrayList<Item> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			Item item = new Item(arr[i][0], arr[i][1]);
			list.add(item);
		}
		list.sort(new CustomComparator());
		for (Item i : list) {
			System.out.println(i.price + " " + i.weight);
		}
		System.out.println("Maximum value in Knapsack is:" + fractionalKnapsack(W, list));
	}

}
