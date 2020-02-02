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
		    System.out.println(min(str));
		    t--;
		}
	}
	private static int min(String str){
	    boolean[][] ispalin = new boolean[str.length()][str.length()];
	    for(int gap=0;gap<str.length();gap++){
	        for(int i=0,j=i+gap;j<str.length();i++,j++){
	            if(gap==0){
	                ispalin[i][j]=true;
	            }else if(gap==1){
	                ispalin[i][j]= str.charAt(i)==str.charAt(j);
	            }else{
	                ispalin[i][j]= str.charAt(i)==str.charAt(j) && ispalin[i+1][j-1]==true;	                
	            }
	        }
	    }
	    int[][] minpc = new int[str.length()][str.length()];
	    for(int gap=0;gap<str.length();gap++){
	        for(int i=0,j=i+gap;j<str.length();i++,j++){
	            if(gap==0){
	                minpc[i][j]=0;
	            }else if(gap==1){
	                minpc[i][j]=ispalin[i][j]==true?0:1;
	            }else{
                    if(ispalin[i][j]==true){
                        minpc[i][j]=0;
                    }else{
                        int minval=Integer.MAX_VALUE;
                        for(int cut=1;cut<=gap;cut++){
                            int fp=minpc[i][i+cut-1];
                            int sp=minpc[i+cut][j];
                            minval=Math.min(minval,fp+sp+1);
                        }
                        minpc[i][j]=minval;
                    }   
	            }
	        }
	    }
	    return minpc[0][str.length()-1];
	    
	}
}
