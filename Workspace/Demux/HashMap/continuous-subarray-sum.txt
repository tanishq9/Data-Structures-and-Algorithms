class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int rsum=0,max=0,rem=0;
        // keep track of remainder and last occurance 
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
            if(k!=0){
                rsum=(rsum+k%k)%k;
            }
            if(map.containsKey(rsum)){
                if(i-map.get(rsum)>=2){
                    return true;
                }
            }
            map.putIfAbsent(rsum,i);    
        }
        return false;
    }
}