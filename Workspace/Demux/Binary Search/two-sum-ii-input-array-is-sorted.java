class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length;i++){
            int index = search(numbers,i,target-numbers[i]);
            if(index != -1){
                return new int[]{i+1,index+1};
            }
        }
        return new int[]{-1,-1};
    }
    
    public int search(int[] nums,int indexCurrent,int target){
        // fftt : first t
        // pred(x) : arr[x] >= target
        int lo=0,hi=nums.length-1,mid;
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(nums[mid]>target){
                hi=mid;
            }else if(nums[mid]<target){
                lo=mid+1;
            }else{
                if(mid!=indexCurrent && nums[mid]==target){
                    return mid;
                }else{
                    lo=mid+1;
                }
            }
        }
        // sanity check
        if(lo!=indexCurrent && nums[lo]==target){
            return lo;
        }
        return -1;
    }
    
    
}