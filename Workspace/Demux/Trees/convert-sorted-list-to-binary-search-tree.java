/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode node;
    // using inorder to save on time complexity
    TreeNode helper(int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode midNode;
        TreeNode left=helper(start,mid-1);
        midNode = new TreeNode(node.val);
        midNode.left=left;
        node=node.next;
        TreeNode right=helper(mid+1,end);      
        midNode.right=right;
        return midNode;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        node=head;
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return helper(0,len-1);   
    }
}