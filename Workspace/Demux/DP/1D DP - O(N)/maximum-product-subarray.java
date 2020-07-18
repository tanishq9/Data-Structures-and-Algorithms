public int maxProduct(int[] nums) {
        int[] maxPositive=new int[nums.length];
        int[] maxNegative=new int[nums.length];
        // maxPositive[i] -> maximum +ve product subarray ending at i
        // maxNegative[i] -> maximum -ve product subarray ending at i
        maxPositive[0]=nums[0];
        maxNegative[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            maxPositive[i]=Math.max(nums[i],Math.max(maxPositive[i-1]*nums[i],maxNegative[i-1]*nums[i]));
            maxNegative[i]=Math.min(nums[i],Math.min(maxPositive[i-1]*nums[i],maxNegative[i-1]*nums[i]));
            max=Math.max(max,maxPositive[i]);
        }
        return max;
    }