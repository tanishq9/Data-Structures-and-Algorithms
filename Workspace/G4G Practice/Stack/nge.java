/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    int[] nge = new int[n];
		    nge[n-1]=-1;
		    Stack<Integer> stack = new Stack<>();
		    stack.push(arr[n-1]);
		    for(int i=n-2;i>=0;i--){
		        while(stack.size()>0 && arr[i]>stack.peek()){
		            stack.pop();
		        }
		        if(stack.size()>0){
     		        nge[i]=stack.peek();   
		        }else{
		            nge[i]=-1;
		        }
		        stack.push(arr[i]);
		    }
		    for(int i=0;i<n;i++){
		        System.out.print(nge[i]+" ");
		    }
		    System.out.println();
		}
	}
}
