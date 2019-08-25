
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	
        int t = Integer.parseInt(br.readLine()); 
    	while(t!=0){
    	    
		    int n = Integer.parseInt(br.readLine()); 
		    int[] arr = new int[n];

		    String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
            
		    for(int i=0;i<n;i++){
		        arr[i] = Integer.parseInt(strs[i]); 
		    }
	
		    for(int i=1;i<n;i+=2){
		        if(i>=1 && arr[i]>arr[i-1]){
		            arr[i]=arr[i-1]^arr[i];
		            arr[i-1]=arr[i-1]^arr[i];
		            arr[i]=arr[i-1]^arr[i];
		        }
		        if(i<=(n-2) && arr[i]>arr[i+1]){
		            arr[i]=arr[i-1]^arr[i];
		            arr[i-1]=arr[i-1]^arr[i];
		            arr[i]=arr[i-1]^arr[i];   
		        }
		    }
		    StringBuffer sb = new StringBuffer();
		    for(int element:arr){
		       sb.append(element+" ");
		    }
		    System.out.println(sb);
		    t--;
		}
	}
}
