package HashMap;

import java.util.HashMap;

public class loggerRateLimiter {
	static class Logger {

		/**
		 * Initialize your data structure here.
		 */
		HashMap<String, Integer> map = new HashMap<>();

		public Logger() {
			map = new HashMap<>();
		}

		/**
		 * Returns true if the message should be printed in the given timestamp,
		 * otherwise returns false. If this method returns false, the message will not
		 * be printed. The timestamp is in seconds granularity.
		 */
		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!map.containsKey(message) || (timestamp - map.getOrDefault(message, 0)) >= 10) {
				map.put(message, timestamp);
				return true;
			}
			return false;
		}
	}
}
