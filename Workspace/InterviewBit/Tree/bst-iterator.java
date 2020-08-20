/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    Stack<TreeNode> stack;
    public Solution(TreeNode root) {
        stack=new Stack<>();
        fillStack(root);
    }
    
    void fillStack(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()>0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode peek=stack.pop();
        fillStack(peek.right);
        return peek.val;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
