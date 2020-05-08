class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==1){
            return Arrays.asList(nums[0]+"");
        }
        List<String> list=new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int start=nums[i];
            while(i+1<nums.length && (nums[i+1]-nums[i])==1){
                i++;
            }
            if(start!=nums[i]){
                list.add(start+"->"+nums[i]);
            }else{
                list.add(start+"");
            }
            i++;
        }
        return list;
    }
}