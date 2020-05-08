class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        // lp[i] is the product of numbers till ith index excluding the ith index i.e [0,i) 
        int[] lp=new int[nums.length];
        lp[0]=1;
        // rp[i] is the product of numbers after ith index till the last index i.e (i,n-1]
        int[] rp=new int[nums.length];
        rp[n-1]=1;
        // fill the lp array
        for(int i=1;i<nums.length;i++){
            lp[i]=nums[i-1]*lp[i-1];
        }
        // fill the rp array
        for(int i=n-2;i>=0;i--){
            rp[i]=nums[i+1]*rp[i+1];
        }
        // now product[i] is the product of numbers [0,i) and (i,n-1]
        int[] product=new int[n];
        for(int i=0;i<n;i++){
            product[i]=lp[i]*rp[i];
        }
        return product;
    }
}