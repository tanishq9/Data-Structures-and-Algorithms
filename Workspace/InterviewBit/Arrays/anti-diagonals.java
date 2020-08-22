public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.size();j++){
                if(!map.containsKey(i+j)){
                    map.put(i+j,new ArrayList<>());
                }
                map.get(i+j).add(A.get(i).get(j));
            }
        }
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}
