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
		    int[][] memo = new int[n][n];
		    System.out.println(gain(arr,0,n-1,memo));
		    t--;
		}
	}
	
	private static int gain(int[] arr,int i,int j,int[][] memo){
	    if(i>=j){
	        return 0;
	    }
	    if(memo[i][j]!=0){
	        return memo[i][j];
	    }
	    int left=arr[i]+Math.min(gain(arr,i+2,j,memo),gain(arr,i+1,j-1,memo));
	    int right=arr[j]+Math.min(gain(arr,i+1,j-1,memo),gain(arr,i,j-2,memo));
	    return memo[i][j]=Math.max(left,right);
	}
	
}
