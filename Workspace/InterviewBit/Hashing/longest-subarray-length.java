public class Solution {
    public int solve(ArrayList<Integer> A) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int rsum=0;
        // init map
        map.put(0,-1);
        int max=0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)==0){
                rsum+=-1;
            }else{
                rsum+=1;
            }
            if(map.containsKey(rsum-1)){
                max=Math.max(max,i-map.get(rsum-1));                
            }
            if(!map.containsKey(rsum)){
                map.put(rsum,i);
            }
        }
        return max;
    }
}
