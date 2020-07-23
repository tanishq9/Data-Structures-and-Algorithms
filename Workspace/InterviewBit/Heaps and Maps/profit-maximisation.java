public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int e:A){pq.add(e);}
        int sum=0;
        while(B-->0){
            sum+=pq.peek();
            pq.add(pq.remove()-1);
        }
        return sum;
    }
}
