
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
		    System.out.println(jumps(arr));
		    t--;
		}
	}
	
	private static int jumps(int[] arr){
       if(arr[0]==0){
	        return -1;
	    }
	    
	    int[] dp = new int[arr.length];
        dp[arr.length - 1] = 0;
	    for (int i = arr.length - 2; i >= 0; i--) 
	    {
		    int min = Integer.MAX_VALUE;
			for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) 
			{
				// i+j is the possible position to go starting from i
				min = Math.min(dp[j],min);
			}
			// Handle overflow
			if (min != Integer.MAX_VALUE) 
			{
				dp[i] = min + 1;
			}
			else
			{
				dp[i] = min;
			}
		}
		if(dp[0]==Integer.MAX_VALUE){
		    return -1;
		}
		return dp[0];
	}
}
