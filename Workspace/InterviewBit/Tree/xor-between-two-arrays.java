public class Solution {
    class Node{
        Node left; // for 0 bit
        Node right; // for set bit
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Node root=new Node();
        // Since we want to maximize the xor. If two numbers have different bits at position 31, then their xor will be greater than numbers that have similar bits at position 31 but different bits at position 0
        for(int e:A){
            Node current=root;
            for(int i=31;i>=0;i--){
                if((e&(1<<i))!=0){
                    // if bit is set
                    if(current.right==null){
                        current.right=new Node();
                    }
                    current=current.right;
                }else{
                    // if bit is not set
                    if(current.left==null){
                        current.left=new Node();
                    }
                    current=current.left;
                }
            }
        }
        int max=0;
        for(int e:B){
            Node current=root;
            int total=0;
            for(int i=31;i>=0;i--){
                if((e&(1<<i))!=0){
                    // this bit is set
                    // go towards left to maximise xor
                    if(current.left!=null){
                        current=current.left;
                        total+=1<<i;
                    }else{
                        current=current.right;
                    }
                }else{
                    // this bit is not set
                    // go towards right to maximise xor
                    if(current.right!=null){
                        current=current.right;
                        total+=1<<i;
                    }else{
                        current=current.left;
                    }
                }
            }
            max=Math.max(max,total);
        }
        return max;
    }
}
