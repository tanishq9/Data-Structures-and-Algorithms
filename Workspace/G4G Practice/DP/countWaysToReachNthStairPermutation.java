/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    private static int mod = 1000000007; 
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	
		int[] dp = new int[100001];
		ways(dp,100001);
		int t = Integer.parseInt(br.readLine()); 
		StringBuffer sb = new StringBuffer();
		while(t!=0){
		    int n = Integer.parseInt(br.readLine()); 
		    sb.append(dp[n]+"\n");
		    t--;
		}
		System.out.println(sb);
	}
	private static void ways(int[] dp,int n){
	    dp[0] = 1;
	    for(int i=1;i<n;i++){
            if((i-1)>=0){
                dp[i]=(dp[i]%mod+(dp[i-1]%mod))%mod;
            }
            if((i-2)>=0){
                dp[i]=(dp[i]%mod+(dp[i-2]%mod))%mod;
            }
	    }
	}
}
