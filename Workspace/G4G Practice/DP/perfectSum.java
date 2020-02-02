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
	        int target = sc.nextInt();
	        System.out.println(ways(arr,target));
		    t--;
		}
	}
	private static int ways(int[] arr,int target){
	    int[][] dp = new int[arr.length+1][target+1];
	    // Meaning dp[i][j] : number of ways to make sum 'j' using 'i' elements
	    for(int i=0;i<dp.length;i++){
	        for(int j=0;j<dp[0].length;j++){
	            if(i==0 && j==0){
	                dp[i][j]=1;
	            }else if(i==0){
	                dp[i][j]=0;
	            }else if(j==0){
	                dp[i][j]=1;
	            }else{
	                dp[i][j]+=dp[i-1][j];
	                if((j-arr[i-1])>=0){
	                    dp[i][j]+=dp[i-1][j-arr[i-1]];
	                }
	            }
	        }
	    }
	    return dp[arr.length][target];
	}
}
