class Solution {
    public void moveZeroes(int[] nums) {
        int leftMostZero=0,p=0;
        // p1 keeps track of first 
        while(p<nums.length){
            if(nums[leftMostZero]!=0 && nums[p]!=0){
                leftMostZero++;
                p++;
            }else if(nums[leftMostZero]==0 && nums[p]==0){
                p++;
            }else if(nums[leftMostZero]==0 && nums[p]!=0){
                nums[leftMostZero]=nums[p];
                nums[p]=0;
                leftMostZero++;
                p++;
            }else{
                leftMostZero++;
                p++;
            }
        }
    }
}