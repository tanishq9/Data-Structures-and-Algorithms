public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> res=new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);
        int n=A.size();
        HashSet<String> set=new HashSet<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] e1,int[] e2){
                return e2[0]-e1[0]; // max heap on sum
            }
        });
        pq.add(new int[]{A.get(n-1)+B.get(n-1),n-1,n-1});
        while(n-->0){
            int[] fr=pq.remove();
            res.add(fr[0]); // add sum to result
            int Aindex=fr[1];
            int Bindex=fr[2];
            fr[1]--;
            if(fr[1]>=0 && fr[2]>=0 && !set.contains(fr[1]+","+fr[2])){
                pq.add(new int[]{A.get(Aindex-1)+B.get(Bindex),Aindex-1,Bindex});
                set.add(fr[1]+","+fr[2]);
            }
            fr[1]++;
            fr[2]--;
            if(fr[1]>=0 && fr[2]>=0 && !set.contains(fr[1]+","+fr[2])){
                pq.add(new int[]{A.get(Aindex)+B.get(Bindex-1),Aindex,Bindex-1});
                set.add(fr[1]+","+fr[2]);
            }
        }
        return res;
    }
}
