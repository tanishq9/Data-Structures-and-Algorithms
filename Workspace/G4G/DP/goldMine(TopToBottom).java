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
	        // Formation of input matrix
	        int[][] input = new int[n][n];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                input[i][j]=sc.nextInt();
	            }
	        }
            // Bottom Up !
	        int[][] dp = new int[n][n];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                // Dividing into 4 regions and then computing
	                if(i==0){
	                    dp[i][j]=input[i][j];
	                }
	                else if(j==0){
	                    dp[i][j]=input[i][j]+Math.max(dp[i-1][j],dp[i-1][j+1]);
	                }
	                else if(j==(n-1)){
	                    dp[i][j]=input[i][j]+Math.max(dp[i-1][j],dp[i-1][j-1]);
	                }
	                else{
	                    dp[i][j]=input[i][j]+Math.max(Math.max(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]);
	                }
	            }
	        }
	        
	        int max = Integer.MIN_VALUE;
	        for(int col=0;col<dp[0].length;col++){
	            max = Math.max(max,dp[n-1][col]);
	        }
	        System.out.println(max);
	        t--;
	    }
	    
	}
}
