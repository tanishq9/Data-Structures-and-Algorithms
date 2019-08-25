/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t!=0){
	        int n = sc.nextInt();
	        int[] coins = new int[n];
	        for(int i=0;i<n;i++){
	            coins[i]=sc.nextInt();
	        }
	        int amount = sc.nextInt();
	        System.out.println(numCombinations(amount,coins));
	        t--;
	    }
	}
	
	private static int numCombinations(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;
		// har coin ka asar daalde one by one
		// taaki bas combination hi generate hoye
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				// 'j' is the current amount which is denoted by dp[j]
				// and 'i' is the index of coin being considered
				dp[j] += dp[j - coins[i]];
			}
		}
		return dp[amount];
	}
}
