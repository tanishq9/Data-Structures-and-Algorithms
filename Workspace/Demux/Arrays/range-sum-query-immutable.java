class NumArray {
    int[] cum;
    public NumArray(int[] nums) {
        cum=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i>=1){
                cum[i]=cum[i-1];
            }
            cum[i]+=nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i>=1){
            return cum[j]-cum[i-1];   
        }else{
            return cum[j];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */