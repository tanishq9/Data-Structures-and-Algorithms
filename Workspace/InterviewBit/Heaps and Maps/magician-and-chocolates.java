public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int mod=(int)Math.pow(10,9)+7;
        for(int e:B){
            pq.add(e);
        }
        long sum=0;
        while(A-->0){
            sum=(sum%mod+pq.peek()%mod)%mod;
            pq.add((int)Math.floor(pq.remove()/2));
        }
        return (int)sum;
    }
}
