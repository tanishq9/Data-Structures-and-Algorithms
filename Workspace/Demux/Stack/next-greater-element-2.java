class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==0){
            return new int[0];
        }
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int[] res=new int[nums.length];
        stack.push(-1);
        for(int i=2*n-2;i>=0;i--){
            while(stack.size()>0 && stack.peek()<=nums[i%n]){
                stack.pop();
            }
            res[i%n]=stack.size()>0?stack.peek():-1;
            stack.push(nums[i%n]);   
        }        
        return res;
    }
}