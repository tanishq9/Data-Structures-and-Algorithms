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
	        int[] dp = new int[n+1];
	        // dp[i] denotes the number of ways to reach 'i' 
	        dp[0]=1;
	        for(int coin=1;coin<=2;coin++){
	            for(int sum=coin;sum<=n;sum++){
	                dp[sum] += dp[sum-coin];
	            }
	        }
	        System.out.println(dp[n]);
	        t--;
	    }
	    
	}
}
