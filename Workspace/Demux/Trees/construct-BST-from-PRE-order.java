/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int[] getNGE(int[] arr){
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
    
    TreeNode helper(int[] pre,int[] nge,int s,int e){
        if(s>e){
            return null;
        }
        int ngeIndex=nge[s];
        TreeNode root=new TreeNode(pre[s]);
        root.left=helper(pre,nge,s+1,ngeIndex==pre.length?pre.length-1:ngeIndex-1);
        root.right=helper(pre,nge,ngeIndex,e);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,getNGE(preorder),0,preorder.length-1);
    }
}