/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	private static int isPossible(int[] arr, int targetSum) {
    	int[][] table = new int[arr.length + 1][targetSum + 1];
    	// Meaning of cell table[i][j] : Is it possible to reach target 'j' using
    	// elements
    	// from 'i' elements from the array
    	for (int i = 0; i < table.length; i++) {
    		for (int j = 0; j < table[0].length; j++) {
    			// Zero target with zero elements
    			if (i == 0 && j == 0) {
    				table[i][j] = 1;
    			}
    			// Zero target with 1 and all elements
    			else if (j == 0) {
    				table[i][j] = 1;
    			}
    			// Target more than zero cannot be achieved by 0 elements considered
    			else if (i == 0) {
    				table[i][j] = 0;
    			} else {
    				// We can reach that target without that element so leave the current element
    				if (table[i - 1][j] == 1) {
    					table[i][j] = 1;
    				}
    				// We can also reach the target by considering the current element and rest of
    				// elements equal to Target-currentElement
    				else if ((j - arr[i - 1] >= 0) && table[i - 1][j - arr[i - 1]] == 1) {
    					table[i][j] = 1;
    				}
    			}
    		}
    	}
    	return table[arr.length][targetSum];
    }
	
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t=sc.nextInt();
		while(t!=0){
		    int n = sc.nextInt();
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    int sum=0;
		    for(int i=0;i<n;i++){
		        sum+=arr[i];
		    }
		    if(sum%2==0){
    		    if(isPossible(arr,sum/2)==1){
    		        System.out.println("YES");
    		    }else{
    		        System.out.println("NO");
    		    }    
		    }
		    else{
		        System.out.println("NO");
		    }
		    t--;
		}
	}
}
