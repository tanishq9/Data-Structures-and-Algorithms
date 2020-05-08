class Solution {
    // generative algorithm
    
    // use min heap approach
    
    // heap takes O(1) to getMin() , O(logn) to pop() i.e deleteMin() and O(logn) to insert
    // set takes O(1) to insert(), O(1) to delete() and O(1) to remove(), but to get min, we will have to 
    // use treeset and it also takes O(1) to get firstKey() i.e min and takes O(logn) to delete
    // set won't work because we have to maintain an order, so treeset can be used
    
    // can do it using treeset also
    // first() -> O(1), pollFirst() -> O(1)
    // https://stackoverflow.com/questions/14379515/computational-complexity-of-treeset-methods-in-java
    
    // or if we want to use heap then to tackle duplicates
    // we can use a set 
    
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        HashSet<Long> set=new HashSet<>();
        pq.add((long)1);
        int count=0;
        // G-R-M-W-A
        while(count<=n){
            // get
            long min=pq.peek();
            // remove
            pq.remove();
            // mark
            if(set.contains(min)){
                continue;
            }else{
                set.add(min);
            }
            // work
            count++;
            if(count==n){
                return (int)min;
            }
            // add 
            pq.add(min*2);pq.add(min*3);pq.add(min*5);
        }
        // code will reach here 
        return -1;
    }
}