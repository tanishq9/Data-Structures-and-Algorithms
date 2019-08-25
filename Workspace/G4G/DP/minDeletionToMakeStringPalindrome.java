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
		    System.out.println(str.length()-lpsq(str));
		    t--;
		}
	}
	private static int lpsq(String str){
	    int[][] table = new int[str.length()][str.length()];
	    for(int gap=0;gap<str.length();gap++){
	        for(int i=0,j=i+gap;j<str.length();j++,i++){
	            if(gap==0){
	                table[i][j]=1;
	            }else if(gap==1){
	                if(str.charAt(i)==str.charAt(j)){
	                    table[i][j]=2;
	                }else{
	                    table[i][j]=1;
	                }
	            }else{
	                if(str.charAt(i)==str.charAt(j)){
	                    table[i][j]=table[i+1][j-1]+2;
	                }else{
	                    table[i][j]=Math.max(table[i+1][j],table[i][j-1]);
	                }
	            }
	        }
	    }
	    return table[0][str.length()-1];
	}
}
