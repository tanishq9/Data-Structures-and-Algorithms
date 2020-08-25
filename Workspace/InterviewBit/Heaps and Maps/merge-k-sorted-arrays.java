public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] e1,int[] e2){
                return A.get(e1[0]).get(e1[1])-A.get(e2[0]).get(e2[1]);
            }
        });
        for(int i=0;i<A.size();i++){
            // index in A list, index of element
            pq.add(new int[]{i,0});
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(pq.size()>0){
            int[] peek=pq.remove();
            res.add(A.get(peek[0]).get(peek[1]));
            if(peek[1]+1<A.get(peek[0]).size()){
                pq.add(new int[]{peek[0],peek[1]+1});
            }
        }
        return res;
    }
}
