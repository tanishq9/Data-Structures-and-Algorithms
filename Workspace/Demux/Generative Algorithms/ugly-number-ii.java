https://leetcode.com/problems/ugly-number-ii/

class Solution {
    // generative algorithm
    
    // can do it using treeset also
    // first() -> O(1), pollFirst() -> O(1)
    // https://stackoverflow.com/questions/14379515/computational-complexity-of-treeset-methods-in-java
    
    // or if we want to use heap then to tackle duplicates
    // we can use a set 
    
    public int nthUglyNumber(int n) {
        TreeSet<Long> tset=new TreeSet<>();
        tset.add((long)1);
        int count=0;
        while(count<=n){
            long min=tset.first();
            tset.pollFirst();
            count++;
            if(count==n){
                return (int)min;
            }
            tset.add(min*2);tset.add(min*3);tset.add(min*5);
        }
        // code will reach here
        return -1;
    }
}