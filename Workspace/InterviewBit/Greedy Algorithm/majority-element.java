public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A){
        int candidate=A.get(0),count=1;
        for(int i=1;i<A.size();i++){
            if(A.get(i)==candidate){
                count++;
            }else{
                count--;
                if(count==0){
                    candidate=A.get(i);
                    count=1;
                }
            }
        }
        return candidate;
    }
}
