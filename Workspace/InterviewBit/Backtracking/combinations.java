public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=A;i++){
            list.add(i);
        }
        helper(list,new ArrayList<Integer>(),res,0,B);
        return res;
    }
    void helper(ArrayList<Integer> list,ArrayList<Integer> temp,
                    ArrayList<ArrayList<Integer>> res,int si,int B){
        
        if(temp.size()==B){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=si;i<list.size();i++){
            temp.add(list.get(i));
            helper(list,temp,res,i+1,B);
            temp.remove(temp.size()-1);
        }
        
        
    }
    
}
