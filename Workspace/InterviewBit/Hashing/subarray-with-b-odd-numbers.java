public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0,rsum=0;
        map.put(rsum,1);
        for(int i=0;i<A.size();i++){
            if(A.get(i)%2==1){
                rsum+=1;
            }else{
                rsum+=0;
            }
            count+=map.getOrDefault(rsum-B,0);
            map.put(rsum,map.getOrDefault(rsum,0)+1);
        }
        return count;
    }
}
