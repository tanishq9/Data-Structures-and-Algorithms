class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates,0,0,target,new ArrayList<>(),res);
        return res;
    }
    void f(int[] arr,int start,int sum,int target,List<Integer> temp,List<List<Integer>> res){
      
        if(sum==target){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum>target || start>=arr.length){
            return;
        }
        
        for(int i=start;i<arr.length;i++){
            if(i!=start && arr[i]==arr[i-1]){
                continue;
            }
            temp.add(arr[i]);
            f(arr,i+1,sum+arr[i],target,temp,res);
            temp.remove(temp.size()-1);
        }
        
    }
}