https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        TreeMap<Integer,Integer> tmap=new TreeMap<>();
        int rsum=0,min=nums.length+1;
        // 0 is the prefix sum at index -1 (initialization)
        tmap.put(0,-1);
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
            if(tmap.floorKey(rsum-s)!=null){
                min=Math.min(min,i-tmap.get(tmap.floorKey(rsum-s)));
            }
            tmap.put(rsum,i);
        }
        return min==nums.length+1?0:min;
    }
}