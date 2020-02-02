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
            // Initial seed
            for(int i=0;i<n;i++){
                dp[i]=arr[i];   
            }
            int max = dp[0];
            for(int i=1;i<n;i++){
                int cm = Integer.MIN_VALUE;
                for(int j=0;j<i;j++){
                    if(arr[i]>arr[j] && cm<dp[j]){
                        cm=dp[j];
                    }
                }
                if(cm!=Integer.MIN_VALUE){
                    dp[i]+=cm;
                }
                max = Math.max(max,dp[i]);
            }
            System.out.println(max);
            t--;
        }
	}
}
