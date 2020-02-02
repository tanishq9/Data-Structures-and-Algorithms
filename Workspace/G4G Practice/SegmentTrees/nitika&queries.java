/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

	static int[] seg_tree = null;

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    int n = sc.nextInt();
		    int q = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
            int xor = 0;
            for(int i=0;i<n;i++){
                xor=xor^arr[i];
            }
            buildTree(arr); // For building the tree
            while(q!=0){
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(query(arr,l-1,r-1)^xor);
                q--;
            }
		    t--;
		}
		
	}
		
	public static int query(int[] arr,int l,int r){
	    return query(arr,0,0,arr.length-1,l,r);
	}
	
	public static int query(int[] arr,int si,int ss,int se,int qs,int qe){
	    if(se<qs || ss>qe){
	        return 0;
	    }else if(qs<=ss && se<=qe){
	        return seg_tree[si];
	    }else{
	        int mid = (ss+se)/2;
	        int l = query(arr,2*si+1,ss,mid,qs,qe);
	        int r = query(arr,2*si+2,mid+1,se,qs,qe);
	        return l^r;
	    }
	}
	
	public static void buildTree(int[] arr){
	    int h = getCeil(arr.length);
	    int seg_size = (1<<(h+1))-1;
	    seg_tree = new int[seg_size];
	    buildTreeHelper(arr,0,0,arr.length-1);
	}
	
	public static void buildTreeHelper(int[] arr,int si,int ss,int se){
	    if(ss==se){
	        seg_tree[si]=arr[ss];
	        return;
	    }
	    int mid=(ss+se)/2;
	    buildTreeHelper(arr,2*si+1,ss,mid);
	    buildTreeHelper(arr,2*si+2,mid+1,se);
	    seg_tree[si]=seg_tree[2*si+1]^seg_tree[2*si+2];
	}
	
	public static int getCeil(int n){
	    int log = 0;
	    while((1<<log)<n){
	        log++;
	    }
	    return log;
	}

}
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

	static int[] seg_tree = null;

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    int n = sc.nextInt();
		    int q = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
            int xor = 0;
            for(int i=0;i<n;i++){
                xor=xor^arr[i];
            }
            buildTree(arr); // For building the tree
            while(q!=0){
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(query(arr,l-1,r-1)^xor);
                q--;
            }
		    t--;
		}
		
	}
		
	public static int query(int[] arr,int l,int r){
	    return query(arr,0,0,arr.length-1,l,r);
	}
	
	public static int query(int[] arr,int si,int ss,int se,int qs,int qe){
	    if(se<qs || ss>qe){
	        return 0;
	    }else if(qs<=ss && se<=qe){
	        return seg_tree[si];
	    }else{
	        int mid = (ss+se)/2;
	        int l = query(arr,2*si+1,ss,mid,qs,qe);
	        int r = query(arr,2*si+2,mid+1,se,qs,qe);
	        return l^r;
	    }
	}
	
	public static void buildTree(int[] arr){
	    int h = getCeil(arr.length);
	    int seg_size = (1<<(h+1))-1;
	    seg_tree = new int[seg_size];
	    buildTreeHelper(arr,0,0,arr.length-1);
	}
	
	public static void buildTreeHelper(int[] arr,int si,int ss,int se){
	    if(ss==se){
	        seg_tree[si]=arr[ss];
	        return;
	    }
	    int mid=(ss+se)/2;
	    buildTreeHelper(arr,2*si+1,ss,mid);
	    buildTreeHelper(arr,2*si+2,mid+1,se);
	    seg_tree[si]=seg_tree[2*si+1]^seg_tree[2*si+2];
	}
	
	public static int getCeil(int n){
	    int log = 0;
	    while((1<<log)<n){
	        log++;
	    }
	    return log;
	}

}

