class Node{
    Node left; // if the i-1 th bit is 0
    Node right; // if the i-1 th bit is 1
    Node(){
        left=null;
        right=null;
    }
}

class Solution {
    Node root;
    public int findMaximumXOR(int[] nums) {
        root=new Node();
        // init bit tree
        // takes O(32) for each number
        for(int num:nums){
            Node currNode=root;
            for(int i=31;i>=0;i--){
                int currBit=(num >> i) & 1;
                if(currBit==0){
                    if(currNode.left==null){
                        currNode.left=new Node();
                    }
                    currNode=currNode.left;
                }else{
                    if(currNode.right==null){
                        currNode.right=new Node();
                    }
                    currNode=currNode.right;
                }
            }
        }
        // greedily find the max xor pair for each element 
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            int curr=0;
            Node currNode=root;
            for(int i=31;i>=0;i--){
                int currBit=(num >> i) & 1;
                if(currBit==0){
                    // if current bit is 0 then look for a 1 bit
                    // because tabhi xor max hoga uss ith bit ke liye
                    if(currNode.right!=null){
                        currNode=currNode.right;
                        curr+=Math.pow(2,i);
                    }else{
                        currNode=currNode.left;
                    }
                }else{
                    // if current bit is 1 then look for a 0 bit
                    // because tabhi xor max hoga uss ith bit ke liye
                    if(currNode.left!=null){
                        currNode=currNode.left;
                        curr+=Math.pow(2,i);
                    }else{
                        currNode=currNode.right;
                    }
                }
            }
            max=Math.max(max,curr);
        }
        return max;
    }
}