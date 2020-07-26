public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        // map of number and its first index in resultant array
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            int num=A.get(i);
            if(!map.containsKey(num)){
                res.add(num);
                map.put(num,i);
            }else{
                res.set(map.get(num),num+1);
                // only consider the first occurence
                if(!map.containsKey(num+1) || map.get(num)<map.get(num+1)){
                    map.put(num+1,map.get(num));
                }
                res.add(num);
                map.put(num,i);
            }
        }
        return res;
    }
}
