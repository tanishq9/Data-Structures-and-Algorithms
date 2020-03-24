class Solution {
public:
    int findMin(vector<int>& nums) {
        int lo=0,hi=nums.size()-1;
        // predicate of form : fffttt
        // pred(x) : nums[x] < nums[0]
        // last f
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<nums[0]){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(nums[lo]<nums[0]){
            return nums[lo];
        }else{
            return nums[0];
        }
    }
};