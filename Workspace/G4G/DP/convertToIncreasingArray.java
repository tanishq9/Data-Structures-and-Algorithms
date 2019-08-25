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
            int[] arr = new int[n];
            int[] lis = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                lis[i]=1;
            }
            int max=0;
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(arr[i]>arr[j] && (i-j)<=(arr[i]-arr[j])){
                        lis[i]=Math.max(lis[i],lis[j]+1);
                    }
                }
                max=Math.max(max,lis[i]);
            }
            System.out.println(n-max);
		    t--;
		}
	}
}
