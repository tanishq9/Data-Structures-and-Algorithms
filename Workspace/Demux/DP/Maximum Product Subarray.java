class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==0){return 0;}
        int max=nums[0];
        int[] minProduct=new int[n];
        int[] maxProduct=new int[n];
        minProduct[0]=nums[0];
        maxProduct[0]=nums[0];
        // minProduct[i] : min product till index i
        // maxProduct[i] : max product till index i
        // either the current element or current element*previous_max_product
        for(int i=1;i<n;i++){
            minProduct[i]=Math.min(nums[i]*maxProduct[i-1], nums[i]*minProduct[i-1]);
            minProduct[i]=Math.min(nums[i], minProduct[i]);
            
            maxProduct[i]=Math.max(nums[i]*minProduct[i-1], nums[i]*maxProduct[i-1]);
            maxProduct[i]=Math.max(nums[i], maxProduct[i]);
            
            max=Math.max(max,maxProduct[i]);
        }
        return max;
    }
}