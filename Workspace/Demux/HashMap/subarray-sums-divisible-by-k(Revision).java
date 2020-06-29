class Solution {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int rsum=0,count=0;
        map.put(0,1);
        for(int i=0;i<A.length;i++){
            rsum+=A[i];
            rsum=(rsum%K+K)%K;
            if(map.containsKey(rsum)){
                count+=map.get(rsum);
            }
            map.put(rsum,map.getOrDefault(rsum,0)+1);
        }
        return count;
    }
}