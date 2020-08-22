public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        HashSet<Integer> rowSet=new HashSet<>();
        HashSet<Integer> colSet=new HashSet<>();
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.get(i).size();j++){
                if(a.get(i).get(j)==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.get(i).size();j++){
                if(rowSet.contains(i) || colSet.contains(j)){
                    a.get(i).set(j,0);
                }
            }
        }
    }
}
