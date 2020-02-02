
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    System.out.println(largest(arr,k));
 		}
	}
	
	static class Pair{
	    int sp;
	    int ep;
	    Pair(int isp,int iep){
	        this.sp=isp;
	        this.ep=iep;
	    }
	}
	
	public static int largest(int[] arr,int k){
	    int[] presum = new int[arr.length];
	    int sum=0;
	    for(int i=0;i<arr.length;i++){
	        sum=(sum%k+arr[i]%k)%k;
	        presum[i]=(sum+k)%k;
	    }
	    for(int i=0;i<presum.length;i++){
	        //System.out.print(presum[i]+" ");
	    }
	    //System.out.println();
	    HashMap<Integer,Pair> map = new HashMap<>();
	    for(int i=0;i<k;i++){
	        map.put(i,new Pair(-1,-1));
	    }
	    map.get(0).sp=0;
	    for(int key:map.keySet()){
	        //System.out.println(key+" "+map.get(key));
	    }
	   
	    int osp=-1;
	    int oep=-2;
	    //return 1;
	    for(int i=0;i<presum.length;i++){
	        int key = presum[i];
	        Pair curr = map.get(key);
	        // Element occured first time
	        if(curr.sp==-1){
	            curr.sp=i+1;
	        }else{
            // Element occured once more,update the ending point
	            curr.ep=i;
	        }
	        if((oep-osp)<(curr.ep-curr.sp)){
	            osp=curr.sp;
	            oep=curr.ep;
	        }
	    }
	    return oep-osp+1;
	}
	
}
