class Solution {
    public void sortColors(int[] nums) {
        int[] freq=new int[3];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int index=0;
        for(int i=0;i<3;i++){
            int occ=freq[i];
            while(occ-->0){
                nums[index++]=i;    
            }
        }
    }
}