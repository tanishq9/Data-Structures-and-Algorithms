package Array;

public class NGE3 {
	 public int nextGreaterElement(int num) {
	        char[] arr=String.valueOf(num).toCharArray();
	        int n=arr.length;
	        int i1=-1,i2=-1;
	        for(int i=n-1;i>=1;i--){
	            if(arr[i-1]<arr[i]){
	                i1=i-1;
	                break;
	            }
	        }
	        if(i1==-1){
	            return -1;
	        }
	        for(int i=n-1;i>=i1;i--){
	            if(arr[i]>arr[i1]){
	                i2=i;
	                break;
	            }
	        }
	        // swap
	        char temp=arr[i1];   
	        arr[i1]=arr[i2];
	        arr[i2]=temp;
	        // reverse
	        reverse(arr,i1+1,n-1); 
	        // 32 bit => Cannot exceed Integer.MAX_VALUE
	        long val=Long.parseLong(new String(arr));
	        if(val>=Integer.MAX_VALUE){
	            return -1;
	        }else{
	            return (int)val;
	        }
	    }
	    void reverse(char[] arr,int s,int e){
	        while(s<=e){
	            char temp=arr[s];   
	            arr[s]=arr[e];
	            arr[e]=temp;
	            s++;
	            e--;
	        }
	    }
}
