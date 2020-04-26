class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return new int[0];
        }
        // DLL Approach 
        LinkedList<Integer> dll=new LinkedList<>();
        int i=0, index=0;
        int[] res=new int[nums.length-k+1];
        // we will store the indexes of elements
        while(i<nums.length){
            // remove the indexes which are not required in the current window
            while(dll.size()>0 && dll.getFirst()<(i-k+1)){
                dll.removeFirst();
            }
            // now we have a valid window, make sure the greatest element is at the front
            while(dll.size()>0 && nums[dll.getLast()]<nums[i]){
                dll.removeLast();
            }
            dll.addLast(i);
            if((i-k+1)>=0){
                // as the greatest element was at the first of dll, we will add it to res array
                res[index++]=nums[dll.getFirst()];
            }
            // expand window
            i++; 
        }
        return res;
    }
}