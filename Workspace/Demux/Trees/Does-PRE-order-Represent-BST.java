import java.util.*;
 
 public class Main {
 
 	 static int index = 0;
 
 	 // This is a functional problem. You have to complete this function.
 	 // It takes as input an integer array. It should return true if the array can represent preorder traversal of a BST, else should return false.
 	 
 	 static int[] getNGE(int[] arr){
        int n=arr.length;
        int[] nge=new int[n];
        Stack<Integer> stack=new Stack<>();
        // initial seed for stack and array
        nge[n-1]=n;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0 && arr[stack.peek()]<=arr[i]){
                // pop kyuki yeh mera next greater ban ne layak nhi hai
                stack.pop();
            }
            nge[i]=stack.size()>0?stack.peek():n;
            stack.push(i);
        }
        return nge;
    }
    
     static boolean helper(int[] pre,int[] nge,int s,int e,int min,int max){
        if(s>e){
            return true;
        }
        int val=pre[s];
        int ngeIndex=nge[s];
        if(val<=min || val>=max){
            return false;
        }
        boolean left=helper(pre,nge,s+1,ngeIndex==pre.length?pre.length-1:ngeIndex-1,min,pre[s]);
        boolean right=helper(pre,nge,ngeIndex,e,pre[s],max);
        return left && right;
     }
 	 
 	 public static boolean preOrder(int[] pre) {
 	 	 // write your code here.
 	 	 return helper(pre,getNGE(pre),0,pre.length-1,Integer.MIN_VALUE,Integer.MAX_VALUE);
 	 }
 
 
 	 public static void main(String[] args) {
 	 	 Scanner sc = new Scanner(System.in);
 	 	 int N = sc.nextInt();
 	 	 int[] arr = new int[N];
 	 	 for(int i=0; i<arr.length; i++){
 	 	 	 arr[i] = sc.nextInt();
 	 	 }
 
 	 	 if(preOrder(arr)){
 	 	 	 System.out.println("Yes");
 	 	 } else{
 	 	 	 System.out.println("No");
 	 	 }
 
 	 }
 	 
 	 
 }