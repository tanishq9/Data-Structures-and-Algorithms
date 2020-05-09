package Stack;

import java.util.HashMap;
import java.util.Stack;

public class maxFrequencyStack {
	class FreqStack {

		HashMap<Integer, Integer> freqchar = null;
		HashMap<Integer, Stack<Integer>> freqstack = null;
		int maxFreq;

		public FreqStack() {
			freqchar = new HashMap<>();
			freqstack = new HashMap<>();
			maxFreq = 0;
		}

		public void push(int x) {
			int f = freqchar.getOrDefault(x, 0) + 1;
			freqchar.put(x, f);
			if (f > maxFreq) {
				maxFreq = f;
			}
			if (!freqstack.containsKey(f)) {
				Stack<Integer> stack = new Stack<>();
				stack.push(x);
				freqstack.put(f, stack);
			} else {
				Stack<Integer> stack = freqstack.get(f);
				stack.push(x);
				freqstack.put(f, stack);
			}
		}

		public int pop() {
			int x = freqstack.get(maxFreq).pop();
			freqchar.put(x, freqchar.get(x) - 1);
			if (freqstack.get(maxFreq).size() == 0) {
				maxFreq--;
			}
			return x;
		}
	}
}
