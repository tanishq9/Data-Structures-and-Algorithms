
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        int n = sc.nextInt();
	        String str = sc.next();
	        int[] memo = new int[n];
	        System.out.println(numDecodings(str,0,memo));
	    }
	}
	private static int numDecodings(String str,int i,int[] memo){
	    if(i==str.length()){
	        return 1;
	    }
	    if(memo[i]!=0){
	        return memo[i];
	    }
	    if(str.charAt(i)=='0'){
	        return 0;
	    }
	    int count = numDecodings(str,i+1,memo);
	    if((i+1)<str.length()){
    	    int offset = Integer.valueOf(str.substring(i,i+2));
    	    if(1<=offset && offset<=26){
    	        count += numDecodings(str,i+2,memo);    
    	    }
	    }
	    return memo[i]=count;
	} 
}
