/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    int[][] dp = new int[m+1][n+1];
		    for(int row=m;row>=0;row--){
		        for(int col=n;col>=0;col--){
		            if(row==m || col==n){
		                dp[row][col]=1;
		            }else{
		                dp[row][col]=dp[row+1][col]+dp[row][col+1];
		            }
		        }
		    }
		    System.out.println(dp[0][0]);
		    t--;
		}
	}
}
