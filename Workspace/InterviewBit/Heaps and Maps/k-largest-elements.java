public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<A.size();i++){
            if(pq.size()==B){
                if(pq.peek()<A.get(i)){
                    pq.remove();
                    pq.add(A.get(i));
                }
            }else{
                pq.add(A.get(i));
            }
        }
        while(pq.size()>0){
            list.add(pq.remove());
        }
        return list;
    }
}
