/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    private static int query(int[] arr, int[] sqrt, int bs, int l, int r) {
		int lb = l / bs; // getting the left block
		int rb = r / bs; // getting the right block
		if (lb == rb) {
			int sum = 0;
			for (int i = l; i <= r; i++) {
				sum += arr[i];
			}
			return sum;
		}
		int sum = 0;
		// left part
		for (int i = l; i / bs == lb; i++) {
			sum += arr[i];
		}
		// lb-1 to rb+1
		for (int i = lb + 1; i <= rb - 1; i++) {
			sum += sqrt[i];
		}
		// right part
		for (int i = r; i / bs == rb; i--) {
			sum += arr[i];
		}
		return sum;
	}
    
  	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		  
	    	int bs = (int) Math.sqrt(arr.length)+1; // Size of each block
	  		int[] sqrt = new int[bs];
        	
        	for (int i = 0; i < arr.length; i++) {
        	    int block_idx = i / bs;
        		sqrt[block_idx] += arr[i];
        	}

		    int q = sc.nextInt();
            StringBuilder sb = new StringBuilder();
		    while(q!=0){
		        int l = sc.nextInt();
		        int r = sc.nextInt();
		        sb.append(query(arr,sqrt,bs,l-1,r-1)+" ");
		        q--;
		    }
		    System.out.println(sb);
		    t--;
		}
	}
}
