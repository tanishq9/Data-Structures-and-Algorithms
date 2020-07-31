public class Solution {
    class Node{
        Node left; // for the 0th bit
        Node right; // for the 1st bit
        int val;
        Node(){
            this.left=null;
            this.right=null;
            this.val=0;
        }
    }
    
    void insertInTree(int e){
        Node current=root;
        for(int i=31;i>=0;i--){
            // incase it's a setbit
            if((e&(1<<i))!=0){
                if(current.right!=null){
                    // move along
                    current=current.right;
                }else{
                    // make a new node and move along it
                    current.right=new Node();
                    current=current.right;
                }
            }else{
                if(current.left!=null){
                    // move along
                    current=current.left;
                }else{
                    // make a new node and move along it
                    current.left=new Node();
                    current=current.left;
                }
            }
        }
        current.val=e; // store the value at the leafNode
    }
    
    int getMinXOR(int e){
        int min=Integer.MAX_VALUE;
        Node current=root;
        int xor=0;
        for(int i=31;i>=0;i--){
            int bit=(e&(1<<i))!=0?1:0;
            if(bit==0){
                if(current.left!=null){
                    // move along
                    current=current.left;
                }else{
                    current=current.right;
                }
            }else{
                if(current.right!=null){
                    // move along
                    current=current.right;
                }else{
                    current=current.left;
                }
            }
        }
        min=Math.min(min,current.val^e);
        return min;
    }
    
    Node root;
    
    public int findMinXor(ArrayList<Integer> A) {
        root=new Node();
        // We find the min counterpart for each element of the arraylist
        // We find it by traversing in the most similar direction starting from the most significant bit
        int min=Integer.MAX_VALUE;
        insertInTree(A.get(0));
        for(int i=1;i<A.size();i++){
            min=Math.min(min,getMinXOR(A.get(i)));
            // Insert element e into the Tree
            insertInTree(A.get(i));
        }
        return min;
    }
}