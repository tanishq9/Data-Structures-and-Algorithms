/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	
		int t = Integer.parseInt(br.readLine()); 
	  
		while(t!=0){
		      // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
        
            int n = Integer.parseInt(strs[0]); 
            int k = Integer.parseInt(strs[1]);
		    
            int[] arr = new int[n];
		    
		    line = br.readLine(); 
            strs = line.trim().split("\\s+"); 
        
		    for(int i=0;i<n;i++){
		        arr[i] = Integer.parseInt(strs[i]); 
		    }
		    
		    Stack<Integer> stack = new Stack<>();
		    int[] ngei = new int[n];
		    ngei[n-1] = n; // n implies out of bounds i.e no ge
		    stack.push(n-1);
		    for(int i=n-2;i>=0;i--){
		        while(stack.size()>0 && arr[i]>arr[stack.peek()]){
		            stack.pop();
		        }
		        if(stack.size()>0){
		            ngei[i]=stack.peek();
		        }else{
		            ngei[i]=n;
		        }
		        stack.push(i);
		    }
		    StringBuffer sb = new StringBuffer();
		    int j=0;
		    for(int i=0;i<n-k+1;i++){
		        if(j<i){
		            j=i;
		        }
		        while(ngei[j]<i+k){
		            j=ngei[j];
		        }
		        sb.append(arr[j]+" ");
		    }
		    System.out.println(sb);
		    t--;
		}
	}
}
