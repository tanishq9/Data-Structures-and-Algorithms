class GFG {
	
	static class MedianPQ{
	    // FOR LARGER ELEMENTS
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();    
	    // FOR SMALLER ELEMENTS
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	  
	    void add(int val)
	    {
	        if(maxHeap.size()>0 && maxHeap.peek()>val){
	            maxHeap.add(val);
	        }else{
	            minHeap.add(val);
	        }     
	        balance();
	    }
	    
	    void balance(){
	        if(maxHeap.size()-minHeap.size()==2){
	            int val = maxHeap.peek();
	            maxHeap.remove();
	            minHeap.add(val);
	        }else if(maxHeap.size()-minHeap.size()==-2){
	            int val = minHeap.peek();
	            minHeap.remove();
	            maxHeap.add(val);
	        }
	    }
	    
	    int peek()
	    {
	        if(minHeap.size()>maxHeap.size()){
	            return minHeap.peek();
	        }else if(minHeap.size()<maxHeap.size()){
	            return maxHeap.peek();
	        }else{
	            return (maxHeap.peek()+minHeap.peek())/2;
	        }
	    }
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    MedianPQ mpq = new MedianPQ();
		while(n-->0){
		    mpq.add(sc.nextInt());
		    System.out.println(mpq.peek());
		}
	}
}
