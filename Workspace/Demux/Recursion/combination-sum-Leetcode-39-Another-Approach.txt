class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        f(arr,0,0,target,new ArrayList<>(),res);
        return res;
    }
    
    public void f(int[] arr,int start,int sum,int target,List<Integer> temp,List<List<Integer>> res){
        if(sum==target){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        if(start>=arr.length || sum>target){
            return;
        }
        
        for(int i=start;i<arr.length;i++){
            temp.add(arr[i]);
            f(arr,i,sum+arr[i],target,temp,res);
            temp.remove(temp.size()-1);
        }
        
    }
    
}