package HashMap;

import java.util.HashSet;

public class distributeCandies {
	public int distributeCandies_Leet(int[] candies) {
		HashSet<Integer> set = new HashSet<>();
		for (int candy : candies) {
			set.add(candy);
		}
		return Math.min(set.size(), candies.length / 2);
	}
}
