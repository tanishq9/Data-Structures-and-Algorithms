class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        // i.e at the peek of the heap, we will have to minimum elements
        // we wish to build a min heap of size k such that at the top of the
        // heap, we have the kth largest element
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        // O(nlogk) time complexity 
        // O(k) space complexity 
        for(int num:nums){
            if(pq.size()==k){
                if(num>pq.peek()){
                    pq.remove();
                    pq.add(num);
                }  
            }else{
                pq.add(num);
            }
        }
        return pq.peek();
    }
}