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
	        int n=sc.nextInt();
	        int[] arr=new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        int tr=sc.nextInt();
	        int[] dp=new int[tr+1];
	        dp[0]=1;
	        for(int i=0;i<n;i++){
	            for(int j=arr[i];j<=tr;j++){
	                dp[j]+=dp[j-arr[i]];
	            }
	        }
	        System.out.println(dp[tr]);
	    }
	 }
}