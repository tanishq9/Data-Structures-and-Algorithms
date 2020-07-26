public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        // dequeue of indexes
        LinkedList<Integer> q=new LinkedList<>();
        int i=0;
        while(i<A.size()){
            // pop all out of range indices
            while(q.size()>0 && i-q.getFirst()>=B){
                q.removeFirst();
            }
            // remove all invalid candidates from queue starting from back
            // don't directly compare with front element, start removing from the back
            // because it is a valid index and therefore has to be at its right place in the dq
            while(q.size()>0 && A.get(i)>A.get(q.getLast())){
                q.removeLast();
            }
            q.addLast(i);
            if(i+1>=B){
                res.add(A.get(q.getFirst()));
            }
            i++;
        }
        return res;
    }
}
