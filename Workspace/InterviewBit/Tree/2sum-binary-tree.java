/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    class NormalIterator{
        Stack<TreeNode> stack;
        NormalIterator(TreeNode root) {
            stack=new Stack<>();
            fillStack(root);
        }
        
        void fillStack(TreeNode root){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
        }
    
        public boolean hasNext() {
            return stack.size()>0;
        }
    
    
        public int getVal(){
            return stack.peek().val;
        }
        
        public int next() {
            TreeNode peek=stack.pop();
            // the next smaller will be the most left element in its RIGHT node
            fillStack(peek.right);
            return peek.val;
        }
    }
    
    class ReverseIterator{
        Stack<TreeNode> stack;
        ReverseIterator(TreeNode root) {
            stack=new Stack<>();
            fillStack(root);
        }
        
        void fillStack(TreeNode root){
            while(root!=null){
                stack.push(root);
                root=root.right;
            }
        }
    
        public boolean hasNext() {
            return stack.size()>0;
        }
    
        public int getVal(){
            return stack.peek().val;
        }
    
        public int next() {
            TreeNode peek=stack.pop();
            // the next larger will be the most right element in its LEFT node
            fillStack(peek.left);
            return peek.val;
        }
    }
    
    // USING O(h) space and O(n) time
    public int t2Sum(TreeNode A, int B) {
        NormalIterator i1=new NormalIterator(A);
        ReverseIterator i2=new ReverseIterator(A);
        
        while(i1.hasNext() && i2.hasNext() && i1.getVal()<i2.getVal()){
            // System.out.println(i1.getVal()+" "+i2.getVal());
            if(i1.getVal()+i2.getVal()<B){
                i1.next();
                // System.out.println("Moving i1");
                // get next larger element using normal iterator
            }else if(i1.getVal()+i2.getVal()>B){
                i2.next();
                // System.out.println("Moving i2");
                // get next smaller element using reverse iterator
            }else{
                return 1;
            }
        }
        return 0;
        
    }
}
