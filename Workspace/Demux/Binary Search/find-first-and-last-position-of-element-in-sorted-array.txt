class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        // find the lower bound
        // pred(x) : a[x] >= target
        // first T
        if(nums.size()==0){
            return {-1,-1};
        }
        int lo=0,hi=nums.size()-1,mid;
        vector<int> res;
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(nums[mid]>=target){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        // sanity check
        if(nums[lo]==target){
            res.push_back(lo);
        }else{
            res.push_back(-1);
        }
        
        // pred(x) : a[x]>target
        // last F
        lo=0,hi=nums.size()-1;
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(nums[mid]>target){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        if(nums[lo]==target){
            res.push_back(lo);
        }else{
            res.push_back(-1);
        }
        return res;
    }
};