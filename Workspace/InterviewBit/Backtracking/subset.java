public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        helper(A,0,new ArrayList<>(),res);
        return res;
    }
    void helper(ArrayList<Integer> list,int si,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i=si;i<list.size();i++){
            temp.add(list.get(i));
            helper(list,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}
