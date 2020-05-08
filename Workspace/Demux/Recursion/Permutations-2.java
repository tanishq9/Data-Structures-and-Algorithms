class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        gen(nums,new ArrayList<>(),res,new boolean[nums.length]);
        return res;
    }
    
    void gen(int[] nums,ArrayList<Integer> list,List<List<Integer>> res,boolean[] vis){
        
        int i=0;
        for(i=0;i<vis.length;i++){
            if(!vis[i]){
                break;
            }
        }
        if(i==vis.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(i=0;i<nums.length;i++){
            if(vis[i]==true || (i>0 && nums[i]==nums[i-1] && vis[i-1]==false)){
                continue;
            }
            vis[i]=true;
            list.add(nums[i]);
            gen(nums,list,res,vis);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    } 
    
}