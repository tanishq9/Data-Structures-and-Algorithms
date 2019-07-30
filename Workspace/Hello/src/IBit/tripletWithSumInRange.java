package IBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class tripletWithSumInRange {

	static class myC implements Comparator<Double> {
		public int compare(Double one, Double two) {
			if (one < two) {
				return 1; // 1 means one should come AFTER two
			} else if (one > two) {
				return -1; // -1 means one should come BEFORE two
			}
			return 0; // 0 else order doesn't matter
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = 0.1;
		System.out.println(i);
		ArrayList<Double> list = new ArrayList<Double>();
		// Collections.sort(list);
		for (int it = 10; it >= 1; it--) {
			list.add((double) it);
		}
	
		Collections.sort(list.subList(5, 10));
		// list.sort(new myC());
		System.out.println(list);
		Double.valueOf("23.1");
		System.out.println(list.get(0));
	}

}
