public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        helper(A,new boolean[A.size()],new ArrayList<Integer>(),res);
        return res;
    }
    void helper(ArrayList<Integer> A,boolean[] vis,
                    ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> res){
        
        if(temp.size()==A.size()){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0;i<A.size();i++){
            if(!vis[i]){
                vis[i]=true;
                temp.add(A.get(i));
                helper(A,vis,temp,res);
                vis[i]=false;
                temp.remove(temp.size()-1);
            }
        }
        
    }
}
