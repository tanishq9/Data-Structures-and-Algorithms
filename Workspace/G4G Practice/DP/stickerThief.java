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
    	    
    	    int[] arr = new int[n];
    	    for(int i=0;i<n;i++){
    	        arr[i]=sc.nextInt();
    	    }
    	    int[] dp = new int[n];
    	    
            dp[0]=arr[0];
            if(n>1){
                dp[1]=Math.max(arr[0],arr[1]);
            }
            
    	    for(int i=2;i<n;i++){
    	        if(i>=2){
    	            // thief has option to take it or leave it
                    dp[i]=Math.max(dp[i-2]+arr[i],dp[i-1]);
    	        }
    	    }
    	    
    	    System.out.println(dp[n-1]);
    	    
	        t--;
	    }
	}
}
