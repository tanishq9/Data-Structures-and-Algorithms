import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

	// This function returns the minimum number of elements that
	// would be required to reach the target state
	// For this question, we need to print the steps
	// so this function will not be called
	static int minElementsRequired(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				if (j % coins[i] == 0 && dp[j / coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], 1 + dp[j / coins[i]]);
				}
			}
		}
		return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
	}

	// This function prints the steps involved in the minimal state
	static void printMinimalState(int[] elements, int target) {
		// Sort the elements as it will help to maintain the lexiciographically ordering
		Arrays.sort(elements);
		// We will use dynamic programming approach due to repeating sub problems
		// Time Complexity : O(elements.length * target)
		int[] dp = new int[target + 1];
		// dp[i] denotes the number of ways to reach the 'ith' state
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		// To store the steps, we will use a 2D arraylist
		// where each index contains the steps to reach that particular state.
		// Our output will be the last string corresponding to the 'target' index
		// of this 2D arraylist
		for (int i = 0; i <= target; i++) {
			result.add(new ArrayList<>());
		}
		// There is one way to reach '1' i.e by just using 1
		// I am using commas to separate each state
		result.get(1).add("1,");
		dp[1] = 1;
		for (int i = 0; i < elements.length; i++) {
			for (int j = elements[i]; j <= target; j++) {
				// check if this element is a multiple of this state
				if (j % elements[i] == 0) {
					// if yes, then add it to number of possible ways to reach 'ith' state
					dp[j] += dp[j / elements[i]];
					// update the 2D arraylist as well, this is what we will be using for output
					for (String prev : result.get(j / elements[i])) {
						result.get(j).add(prev + elements[i] + ",");
					}
				}
			}
		}
		int outputSize = result.get(target).size();
		if (outputSize > 0) {
			String[] outputStates = result.get(target).get(outputSize - 1).split(",");
			for (String state : outputStates) {
				System.out.print(state + " ");
			}
			System.out.println();
		} else {
			// No possible way to this 'target' state
			System.out.println("-1");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input the final value i.e the target
		int target = sc.nextInt();
		// input the elements that can be used to reach the target
		int n = sc.nextInt();
		int[] elements = new int[n];
		for (int i = 0; i < n; i++) {
			elements[i] = sc.nextInt();
		}
		// This function will print the minimal state to reach target
		printMinimalState(elements, target);
	}
}