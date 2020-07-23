/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    TreeNode getMid(ListNode node,int shifts){
        ListNode temp=node;
        while(shifts-->0){
            temp=temp.next;
        }
        return new TreeNode(temp.val);
    }
    
    TreeNode helper(ListNode node,int start,int end){
        if(start>end){
            return null;
        }
        int m=(start+end)/2;
        TreeNode mid=getMid(node,m);
        mid.left=helper(node,start,m-1);
        mid.right=helper(node,m+1,end);
        return mid;
    }
    
    public TreeNode sortedListToBST(ListNode a) {
        // get mid node and recur on left and right side
        ListNode temp=a;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return helper(a,0,len-1);
    }
}
