class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        fun(nums,0,new ArrayList<>(),res);
        return res;
    }
    // decision : take or dont take
    // subproblem is a suffix array
    void fun(int[] nums,int i,List<Integer> temp,List<List<Integer>> res){
        // base case
        if(i==nums.length){
            // doing a deep copy and not a shallow copy
            res.add(new ArrayList<>(temp));
            return;
        }
        // recursive relation
        // decision : remove it
        fun(nums,i+1,temp,res);
        // decision : take it
        temp.add(nums[i]);
        fun(nums,i+1,temp,res);
        temp.remove(temp.size()-1);
    }
}