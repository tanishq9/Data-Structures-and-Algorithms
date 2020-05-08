class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        f(nums,new boolean[nums.length],new ArrayList<>(),res);
        return res;
    }
    void f(int[] nums,boolean[] vis,List<Integer> temp,List<List<Integer>> res){
        int i=0;
        // base case
        for(i=0;i<nums.length;i++){
            if(!vis[i]){
                break;
            }
        }
        if(i==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        // visit the unvisited
        for(i=0;i<nums.length;i++){
            if(vis[i]==true){
                continue;
            }
            vis[i]=true;
            temp.add(nums[i]);
            f(nums,vis,temp,res);
            temp.remove(temp.size()-1);
            vis[i]=false;
        }
    }
}