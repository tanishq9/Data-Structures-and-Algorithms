/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t!=0){
	        String str = sc.next();
	        System.out.println(ways(str));
	        t--;
	    }
	}
	private static int ways(String str){
	    int[][] strg = new int[str.length()][str.length()];
	    for(int gap=0;gap<str.length();gap++){
	        for(int i=0,j=i+gap;j<str.length();i++,j++){
	            if(gap==0){
	                strg[i][j]=1;
	            }else if(gap==1){
	                if(str.charAt(i)==str.charAt(j)){
	                    strg[i][j]=2;
	                }else{
	                    strg[i][j]=1;
	                }
	            }else{
	                 if(str.charAt(i)==str.charAt(j)){
	                    strg[i][j]=strg[i+1][j-1]+2;
	                }else{
	                    strg[i][j]=Math.max(strg[i+1][j],strg[i][j-1]);
	                }
	            }
	        }
	    }
	   return strg[0][str.length()-1];
	}
}
