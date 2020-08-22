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
 
class Data { 
    int leftDepth, rightDepth, time; 
    boolean contains; 
  
    Data() { 
        contains = false; 
        leftDepth = rightDepth = 0; 
        time = -1; 
    } 
} 
 
public class Solution {
    
    int ans = 0;
    
    public int solve(TreeNode A, int B) {
        burnTree(A, new Data(), B);
        return ans;
    }
    
    private void burnTree(TreeNode node, Data data, int target) {
        if (node == null) return;
  
        // If current node is leaf 
        if (node.left == null && node.right == null) {
            // If current node is the first burnt node 
            if (node.val == target) { 
                data.contains = true; 
                data.time = 0; 
            } 
            return; 
        } 
  
        // Information about left child 
        Data leftData = new Data(); 
        burnTree(node.left, leftData, target); 
  
        // Information about right child 
        Data rightData = new Data(); 
        burnTree(node.right, rightData, target); 
  
        // If left subtree contains the fired node then 
        // time required to reach fire to current node 
        // will be (1 + time required for left child) 
        data.time = (leftData.contains) ? (leftData.time + 1) : -1; 
  
        // If right subtree contains the fired node then 
        // time required to reach fire to current node 
        // will be (1 + time required for right child) 
        if (data.time == -1) 
            data.time = (rightData.contains) ? (rightData.time + 1) : -1; 
  
        // Storing(true or false) if the tree rooted at 
        // current node contains the fired node 
        data.contains = (leftData.contains || rightData.contains); 
  
        // Calculate the maximum depth of left subtree 
        data.leftDepth = (node.left == null) ? 0 : (1 + Math.max(leftData.leftDepth, leftData.rightDepth)); 
  
        // Calculate the maximum depth of right subtree 
        data.rightDepth = (node.right == null) ? 0 : (1 + Math.max(rightData.leftDepth, rightData.rightDepth)); 
  
        // Calculating answer 
        if (data.contains) { 
  
            // If left subtree exists and 
            // it contains the fired node 
            if (leftData.contains) {
                // calculate result 
                ans = Math.max(ans, data.time + data.rightDepth); 
            } 
  
            // If right subtree exists and it 
            // contains the fired node 
            if (rightData.contains) {
                // calculate result 
                ans = Math.max(ans, data.time + data.leftDepth); 
            } 
        } 
    }
}