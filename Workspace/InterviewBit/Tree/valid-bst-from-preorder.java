public class Solution {
    
    int[] getNGE(ArrayList<Integer> A,int n){
        int[] nge=new int[n];
        Stack<Integer> stack=new Stack<>();
        stack.push(n-1);
        nge[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0 && A.get(i)>=A.get(stack.peek())){
                stack.pop();
            }
            nge[i]=stack.size()>0?stack.peek():n;
            stack.push(i);
        }
        return nge;
    }
    
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int[] nge=getNGE(A,n);
        boolean isPossible=helper(A,nge,n,0,n-1,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return isPossible==true?1:0;
    }
    // return 0 if bst cannot be formed; return 1 if bst can be formed
    boolean helper(ArrayList<Integer> A,int[] nge,int n,int s,int e,int min,int max){
        if(s>e){
            return true;
        }
        // if the current node is not within the min and max it should be in then return 0
        if(A.get(s)<min || A.get(s)>max){
            return false;
        }
        int ngeIndex=nge[s];
        boolean left=helper(A,nge,n,s+1,ngeIndex==n?n-1:ngeIndex-1,min,A.get(s));
        boolean right=helper(A,nge,n,ngeIndex,e,A.get(s),max);
        return left && right;
    }
    
}
