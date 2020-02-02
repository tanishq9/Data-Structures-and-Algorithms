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
		    int[] dims = new int[n];
		    for(int i=0;i<n;i++){
		        dims[i]=sc.nextInt();
		    }
		    System.out.println(min(dims));
		    t--;
		}
	}
	public static int min(int[] dims){
	    int[][] mcm = new int[dims.length][dims.length];
        for(int gap=1;gap<dims.length;gap++){
            for(int i=0,j=i+gap;j<dims.length;j++,i++){
                if(gap==1){
                    mcm[i][j]=0;
                }else if(gap==2){
                    mcm[i][j]=dims[i]*dims[j]*dims[i+1];
                }else{
                    int min=Integer.MAX_VALUE;
                    for(int cut=1;cut<=gap-1;cut++){
                        int fp=mcm[i][i+cut];
                        int sp=mcm[i+cut][j];
                        int factor=dims[i]*dims[i+cut]*dims[j];
                        min=Math.min(min,fp+sp+factor);
                    }
                    mcm[i][j]=min;
                }
            }            
        }
        return mcm[0][mcm.length-1];
	}
}
