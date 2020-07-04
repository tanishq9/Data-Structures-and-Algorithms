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
class BSTIterator {
    
    Stack<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.stack=new Stack<>();
        // init the stack
        fill(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode next=stack.pop();
        // after popping the smallest node at that point 
        // push its just next larger node into the stack
        // it can be done by traversing to the extreme left
        // of its right node
        fill(next.right);
        return next.val;
    }
    
    public void fill(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */