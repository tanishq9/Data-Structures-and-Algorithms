https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // DSRB
        // 1. Decision at every step : take element or don't take element
        // 2. Subproblem : suffix array, since after taking decision over the ith element, we have to work on the (i+1)th element
        // 3. Recurrence Relation : f(arr,i+1,sum-arr[i]) and f(arr,i+1,sum)
        // 4. Base Cases : Define while coding (they are the smallest subproblem)
        
        List<List<Integer>> res = new ArrayList<>();
        fun(candidates,0,0,target,new ArrayList<>(),res);
        return res;
    }
    
    // Strategy : Reactive(call without thinking and cover in base cases) and Pro-active(call thinkfully)
    void fun(int[] candidates, int index,int currentSum, int target, List<Integer> temp,List<List<Integer>> res){
        if(index==candidates.length){
            return;
        }
        
        if(currentSum==target){
            // deep copy
            res.add(new ArrayList<>(temp));
            return;
        }
        
        int currentCandidate = candidates[index];  
        // take it proactively (allowed to take it multiple times)
        if((currentSum+currentCandidate)<=target){
            temp.add(currentCandidate);
            fun(candidates,index,currentSum+currentCandidate,target,temp,res);
            temp.remove(temp.size()-1);
        }
        // don't take it
        fun(candidates,index+1,currentSum,target,temp,res);
    }
    
}