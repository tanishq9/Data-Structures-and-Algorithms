/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
    	
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	
		int t = Integer.parseInt(br.readLine()); 
	  
		while(t!=0){
		    int n = Integer.parseInt(br.readLine()); 
  
		    int[] arr = new int[n];
		    
		      // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
            
		    for(int i=0;i<n;i++){
		        arr[i] = Integer.parseInt(strs[i]); 
		    }
		    
		    int ms=arr[0],cs=arr[0];
		    for(int i=1;i<n;i++){
		        cs=Math.max(arr[i],cs+arr[i]);
		        ms=Math.max(cs,ms);
		    }
		    // StringBuffer for large output printing , not useful in this case
		    // just for demo
		    StringBuffer sb = new StringBuffer();
		    sb.append(ms);
		    System.out.println(sb);
		    
		    t--;
		}
	}
}
