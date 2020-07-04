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
    
    
    class BSTIterator{
        Stack<TreeNode> stack;
        BSTIterator(TreeNode root){
            stack=new Stack<>();
            fill(root);
        }
        void fill(TreeNode root){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
        }
        boolean hasNext(){
            return stack.size()>0;
        }
        int next(){
            TreeNode top=stack.pop();
            fill(top.right);
            return top.val;
        }
        int peek(){
            return stack.peek().val;
        }
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        BSTIterator bst1=new BSTIterator(root1);
        BSTIterator bst2=new BSTIterator(root2);
        ArrayList<Integer> list=new ArrayList<>();
        while(bst1.hasNext() && bst2.hasNext()){
            int peek1=bst1.peek(),peek2=bst2.peek();
            if(peek1>peek2){
                list.add(peek2);
                bst2.next();
            }else{
                list.add(peek1);
                bst1.next();
            }
        }
        while(bst1.hasNext()){
            list.add(bst1.next());
        }
        while(bst2.hasNext()){
            list.add(bst2.next());
        }
        return list;        
    }
}