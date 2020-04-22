https://leetcode.com/problems/peeking-iterator

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	int cacheElement;
    boolean cacheValid;
    Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator=iterator;
	    cacheValid=false;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(cacheValid==true){
            return cacheElement;
        }
        cacheElement=this.iterator.next();
        cacheValid=true;
        return cacheElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(cacheValid==true){
            cacheValid=false;
            return cacheElement;
        }
        return this.iterator.next();
	}
	
	@Override
	public boolean hasNext() {
        if(cacheValid==true){
            return true;
        }
	    return this.iterator.hasNext();
	}
}