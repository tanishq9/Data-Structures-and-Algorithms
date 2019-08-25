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
		    System.out.println(longest(str));
		    t--;
		}
	}
	private static String longest(String str){
	    boolean[][] strg = new boolean[str.length()][str.length()];
	    int start = 0 , end = 0 , diff = 0;
	    for(int gap=0;gap<str.length();gap++){
	        for(int i=0,j=i+gap;j<str.length();i++,j++){
	            if(gap==0){
	                strg[i][j]=true;
	            }else if(gap==1){
	                strg[i][j]=str.charAt(i)==str.charAt(j);
	            }else{
	                strg[i][j]=str.charAt(i)==str.charAt(j)
	                            && strg[i+1][j-1]==true;
	            }
	            if(strg[i][j]==true){
	                if((j-i)>diff){
	                    start=i;
    	                end=j;  
    	                diff=end-start;
	                }
	           }
	        }
	    }
	    return str.substring(start,end+1);
	}
}
