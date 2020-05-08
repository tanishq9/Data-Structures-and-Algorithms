class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0]>=target){
            return 0;
        }
        // fftt pattern
        // last f
        // pred(x) : arr[x] >= target
        int lo=0,hi=nums.length-1,mid;
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(nums[mid]>=target){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        // sanity check
        if(!(nums[lo]>=target)){
            return lo+1;
        }else{
            return -1;
        }
    }
}