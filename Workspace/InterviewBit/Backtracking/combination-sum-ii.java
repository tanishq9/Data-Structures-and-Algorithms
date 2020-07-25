public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        helper(A,B,0,new ArrayList<>(),new boolean[A.size()],res);
        return res;
    }
    
    void helper(ArrayList<Integer> A,int target,int si,ArrayList<Integer> temp,boolean[] vis,ArrayList<ArrayList<Integer>> res){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=si;i<A.size();i++){
            if(i>0 && A.get(i)==A.get(i-1) && !vis[i-1]){
                continue;
            }
            vis[i]=true;
            temp.add(A.get(i));
            helper(A,target-A.get(i),i+1,temp,vis,res);
            vis[i]=false;
            temp.remove(temp.size()-1);
        }
        
    }
}
