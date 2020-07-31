class Solution {
    public int totalHammingDistance(int[] nums) {
        int total=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j]&(1<<i))!=0){
                    count++;
                }
            }
            total+=count*(nums.length-count);
        }
        return total;
    }
}