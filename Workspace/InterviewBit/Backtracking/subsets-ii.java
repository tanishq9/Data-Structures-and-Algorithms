public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
    Collections.sort(A);
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        helper(A,0,new boolean[A.size()],new ArrayList<>(),res);
        return res;
    }
    void helper(ArrayList<Integer> list,int si,boolean[] vis,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i=si;i<list.size();i++){
            if(i>0 && list.get(i)==list.get(i-1) && !vis[i-1]){
                continue;
            }
            vis[i]=true;
            temp.add(list.get(i));
            helper(list,i+1,vis,temp,res);
            vis[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}
