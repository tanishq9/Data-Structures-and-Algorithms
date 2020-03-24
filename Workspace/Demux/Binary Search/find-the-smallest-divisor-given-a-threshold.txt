class Solution {
    
    public int predicate(int[] nums,int k){
        int sum=0;
        for(int i:nums){
            sum+=Math.ceil((double)i/k);
        }
        return sum;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int lo=1,hi=max,mid;
        // fffttt
        // first t 
        // pred(x) : nums[x] <= threshold
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(predicate(nums,mid)<=threshold){
                hi=mid;    
            }else{
                lo=mid+1;
            }
        }
        // sanity check
        if(predicate(nums,lo)<=threshold){
            return lo;
        }else{
            return -1;
        }
    }
}