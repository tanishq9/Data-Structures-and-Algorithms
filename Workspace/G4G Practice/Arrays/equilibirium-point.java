import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    while(t-->0){
	        int n=Integer.parseInt(br.readLine());
	        int[] arr=new int[n];
	        int lsum=0;
	        String[] str=br.readLine().split("\\s+");
	        for(int i=0;i<n;i++){
	            arr[i]=Integer.valueOf(str[i]);
	            lsum+=arr[i];
	        }
	        int rsum=0;
	        boolean flag=false;
	        for(int i=n-1;i>=0;i--){
	            lsum-=arr[i];
	            if(lsum==rsum){
	                flag=true;
	                System.out.println(i+1);
	                break;
	            }
	            rsum+=arr[i];
	        }
	        if(flag==false){
	            System.out.println(-1);
	        }
	    }
	 }
}