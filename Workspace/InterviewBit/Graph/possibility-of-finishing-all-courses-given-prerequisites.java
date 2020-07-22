public class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        if(B.size()>A){
            return 0;
        }
        int[] indegree=new int[A+1];
        for(int i=0;i<C.size();i++){
            indegree[C.get(i)]++;
        }
        LinkedList<Integer> q=new LinkedList<>();
        for(int i=1;i<=A;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(q.size()>0){
            int fr=q.removeFirst();
            count++;
            for(int i=0;i<B.size();i++){
                if(fr==B.get(i)){
                    indegree[C.get(i)]--;
                    if(indegree[C.get(i)]==0){
                        q.add(C.get(i));
                    }
                }
            }
        }
        return count==A?1:0;
    }
}
