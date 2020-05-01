class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        fun(nums,0,new ArrayList<>(),res);
        return res;
    }
    // descision using : take start point method
    void fun(int[] nums, int start, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            fun(nums,i+1,list,res);
            list.remove(list.size()-1);
        }
        
    }
    
}