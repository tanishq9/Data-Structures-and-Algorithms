package Stack;

public class GasStation {
	class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			// Find the first empty station
			int start = 0;
			int tank = 0;
			int sumgas = 0;
			int sumcost = 0;
			for (int i = 0; i < gas.length; i++) {
				// if car fails at start , go to the next station
				sumcost += cost[i];
				sumgas += gas[i];
				tank += gas[i] - cost[i];
				if (tank < 0) {
					// it means journey not possible
					start = i + 1;
					tank = 0;
				}
			}

			if (sumgas < sumcost) {
				return -1;
			} else {
				return start;
			}

		}
	}
}
