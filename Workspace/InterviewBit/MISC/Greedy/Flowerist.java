package Greedy;

import java.util.*;

class myComparator implements Comparator<Integer> {
	public int compare(Integer one, Integer two) {
		return two - one;
	}
}

public class Flowerist {

	public static void main(String[] args) {
		Integer[] arr = { 2, 5, 4, 1 };
		Arrays.sort(arr, new myComparator());
		double a = 2;
		System.out.println(String.format("%.6f", a / 3));
	}
}
