public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int i=0,j=A.get(0).size()-1;
        while(i<A.size() && j>=0){
            int element=A.get(i).get(j);
            if(element<B){
                i++;
            }else if(element>B){
                j--;
            }else{
                return 1;
            }
        }
        return 0;
    }
}