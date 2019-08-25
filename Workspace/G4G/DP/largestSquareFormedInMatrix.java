/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int[][] arr = new int[n][m];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<m;j++){
		            arr[i][j]=sc.nextInt();
		        }
		    }
		    System.out.println(max(arr));
		    t--;
		}
	}
	public static int max(int[][] arr){
	    int largest = Integer.MIN_VALUE;
	    int[][] table = new int[arr.length][arr[0].length];
	    for(int i=table.length-1;i>=0;i--){
	        for(int j=table[0].length-1;j>=0;j--){
                if(i==table.length-1 || j==table[0].length-1){
                    table[i][j]=arr[i][j];
                }else if(arr[i][j]==0){
                    table[i][j]=0;
                }else{
                    table[i][j]=1+Math.min(Math.min(table[i+1][j],table[i][j+1]),table[i+1][j+1]);
                }
                largest = Math.max(largest,table[i][j]);
	        }
	    }
	    return largest;
	}
}
