/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int cnt=q.size();
            TreeLinkNode prev=null;
            while(cnt-->0){
                TreeLinkNode fr=q.removeFirst();
                if(fr.left!=null){
                    q.add(fr.left);
                }
                if(fr.right!=null){
                    q.add(fr.right);
                }
                if(prev!=null){
                    prev.next=fr;
                }
                prev=fr;
            }
        }
    }
}
