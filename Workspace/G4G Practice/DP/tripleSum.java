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
		    int x = sc.nextInt();
		    int[] arr = new int[n];
		    
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    
		    Arrays.sort(arr);
		    boolean flag = false; 
	      
            for(int i=0;i<arr.length-2;i++){
               int l=i+1;
               int r=arr.length-1;
               while(l<r){
                   if(arr[i]+arr[l]+arr[r]==x){
                       flag=true;
                       break;
                   }else if(arr[i]+arr[l]+arr[r]>x){
                       r--;
                   }else{
                       l++;
                   }
               }
            }
            
            if(flag==true){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
            
		    t--;
		}
	}
}
