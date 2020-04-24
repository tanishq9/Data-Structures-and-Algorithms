class MedianFinder {

    /** initialize your data structure here. */
    
    // Left part mei smaller elements ka sabse greatest i.e max heap
    // Right part mei larger elements ka sabse smallest i.e min heap
    // inn dono heaps ko use krke we will get the median
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // add logic : push to the maxheap, offer it to minheap and if size of minheap>maxheap, pop it from minheap and add it to maxheap
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        
        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }else{
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */