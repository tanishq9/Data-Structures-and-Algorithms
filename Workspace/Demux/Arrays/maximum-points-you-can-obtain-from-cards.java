https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards

class Solution {
    // Product after self approach
    public int maxScore(int[] nums, int k) {
        int n=nums.length;
        // cumLeftSum[i] means aage se i number of elements
        ArrayList<Integer> cumLeftSum=new ArrayList<>();
        cumLeftSum.add(0);
        // cumRightSum[2] means piche se 2 elements
        ArrayList<Integer> cumRightSum=new ArrayList<>();
        cumRightSum.add(0);
        // fill the left sum array
        for(int i=1;i<=n;i++){
            cumLeftSum.add(nums[i-1]+cumLeftSum.get(i-1));
        }
        // fill the right sum array
        for(int i=n-1;i>=0;i--){
            cumRightSum.add(nums[i]+cumRightSum.get(n-i-1));
        } 
        
        System.out.println(cumLeftSum);
        System.out.println(cumRightSum);
        
        // find max sum
        int max=0;
        for(int i=0;i<=k;i++){
            max=Math.max(max,cumLeftSum.get(i)+cumRightSum.get(k-i));
        }
        return max;
    }
    
}