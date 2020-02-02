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
            int capacity = sc.nextInt();
            int[] wts = new int[n];
            int[] prices = new int[n];
            for(int i=0;i<n;i++){
                prices[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                wts[i]=sc.nextInt();
            }
            System.out.println(maxProfit(wts,prices,capacity));
            t--;
        }
	}
	
	private static int maxProfit(int[] wts,int[] prices,int capacity){
	    int[] dp = new int[capacity+1];
	    for(int i=0;i<wts.length;i++){
	        for(int c=1;c<=capacity;c++){
	            if((c-wts[i])>=0){
	                dp[c]=Math.max(dp[c],dp[c-wts[i]]+prices[i]);
	            }
	        }
	    }
	    return dp[capacity];
	} 
	
}
