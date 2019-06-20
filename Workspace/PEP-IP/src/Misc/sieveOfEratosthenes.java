package Misc;

import java.util.Arrays;

public class sieveOfEratosthenes {
	public static int countPrimes(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		// Seed
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (primes[i] == true) {
				for (int j = i * i; j <= n; j += i) {
					primes[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (primes[i] == true) {
				count++;
			}
		}
		return count;
	}
}
