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
	        int len=sc.nextInt();
	        String s=sc.next();
	        int[] dp=new int[s.length()];
	        System.out.println(f(s,"",0,dp));
	    }
	 }
	 
	 static int f(String str,String result,int i,int[] dp){
	     if(str.length()==0){
	         return 1;
	     }
	     if(str.charAt(0)=='0'){
	        return 0; 
	     }
	     if(dp[i]!=0){
	         return dp[i];
	     }
	     int index=str.charAt(0)-'1';
	     char cc=(char)(index+65);
	     String ros=str.substring(1);
	     int count=f(ros,result+cc,i+1,dp);
	     if(str.length()>1){
	         index=Integer.valueOf(str.substring(0,2));
	         if(index<=26){
    	        cc=(char)(index+64);	             
	            count+=f(str.substring(2),result+cc,i+2,dp);
	         }
	     }
	     return dp[i]=count;
	 }
	 
}