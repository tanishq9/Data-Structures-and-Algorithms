import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int tr=sc.nextInt();
	        int n=sc.nextInt();
	        int[] arr=new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        int[] dp=new int[tr+1];
	        Arrays.fill(dp,Integer.MAX_VALUE);
	        dp[0]=0;
	        for(int i=0;i<n;i++){
	            for(int j=arr[i];j<=tr;j++){
	                if(dp[j-arr[i]]!=Integer.MAX_VALUE && 
	                       dp[j-arr[i]]+1<dp[j]){
	                           dp[j]=dp[j-arr[i]]+1;
	                       }
	            }
	        }
	        System.out.println(dp[tr]==Integer.MAX_VALUE?-1:dp[tr]);
	    }
	 }
}