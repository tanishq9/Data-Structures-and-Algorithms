/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t!=0){
		    int n = sc.nextInt();
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    int[] dp = new int[arr.length];
    		int max = Integer.MIN_VALUE;
    		Arrays.fill(dp, 1);
    		for (int i = 0; i < arr.length; i++) {
    		    if(arr[i]<0){
    		        dp[i]=0;
    		        continue;
    		    }
    			for (int j = 0; j < i; j++) {
    				if(arr[i]>arr[j]) {
    					dp[i] = Math.max(dp[i], dp[j]+1);	
    				}
    			}
    			max=Math.max(dp[i],max);
    		}
    		System.out.println(max);
		    t--;
		}
	}
}
