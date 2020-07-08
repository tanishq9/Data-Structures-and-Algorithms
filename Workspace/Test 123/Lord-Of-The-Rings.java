import java.util.Scanner;
import java.util.Stack;

public class Main {
    	
	public static int[] getFinalPotential(int[] potential) {
		// I am using a stack based approach
		// as it will help to simulate the fights between wrestlers
		// the fight will only outbreak if the -ve potential wrestler
		// interact with +ve potential wrestler(s) on its left
		// Time Complexity : O(n)
		// Space Complexity : O(n)
		Stack<Integer> stack = new Stack<>();
		for (int currentWrestlerPotential : potential) {
			// If the wrestler's potential is +ve then push it into stack
			// as it will never interact with existing wrestlers
			// but may interact with future -ve potential wrestlers.
			if (currentWrestlerPotential > 0) {
				stack.push(currentWrestlerPotential);
			}
			// If the wrestler's potential is -ve then we need to simulate the fighting
			// and we will keep on popping the +ve potential wrestlers from top of stack
			// if the absolute value of -ve potential is more than top of stack after that
			// we will then decide whether to push the -ve potential wrestler to the stack
			// depending upon the possibility of 2 wrestlers having equal potential
			else {
				while (stack.size() > 0 && stack.peek() >= 0 && currentWrestlerPotential < 0
						&& stack.peek() < Math.abs(currentWrestlerPotential)) {
					stack.pop();
				}
				if (stack.size() == 0 || stack.peek() < 0) {
					// If the stack is empty or the top of stack wrestler has -ve potential
					// then we will push the current wrestler having -ve potential
					stack.push(currentWrestlerPotential);
				} else if (stack.peek() + currentWrestlerPotential == 0) {
					// If both wrestlers have equal potential then take both of them out
					stack.pop();
				}
			}
		}
		// The stack contains the wrestlers left after surviving the battle/fight
		int[] remainingWrestlers = new int[stack.size()];
		// Now, lets populate the result array and return it as a result
		int index = stack.size() - 1;
		// We will fill the result array from the end since the order of wrestlers
		// in the fight i.e from left to right has to be maintained
		while (stack.size() > 0) {
			remainingWrestlers[index--] = stack.pop();
		}
		return remainingWrestlers;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 'n' denotes the total number of wrestlers in the ring
		int n = sc.nextInt();
		// 'potential' array represents potential of each wrestler
		int[] potential = new int[n];
		for (int i = 0; i < n; i++) {
			potential[i] = sc.nextInt();
		}
		// This function returns the potential of wrestlers left in the ring after fight
		int[] result = getFinalPotential(potential);
		// Now, let's print the print the potential of the wrestlers left
		for (int wrestler : result) {
			System.out.print(wrestler + " ");
		}
	}
}