public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A);
        Collections.sort(B);
        int n=A.size();
        HashSet<String> set=new HashSet<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] one,int[] two){
                return two[0]-one[0];
            }
        }); 
        ArrayList<Integer> res=new ArrayList<>();
        pq.add(new int[]{A.get(n-1)+B.get(n-1),n-1,n-1});
        while(C-->0){
            int[] fr=pq.remove();
            res.add(fr[0]);
            int aIndex=fr[1];
            int bIndex=fr[2];
            fr[1]--;
            if(fr[1]>=0 && fr[2]>=0 && !set.contains(fr[1]+","+fr[2])){
                pq.add(new int[]{A.get(fr[1])+B.get(fr[2]),fr[1],fr[2]});
                set.add(fr[1]+","+fr[2]);
            }
            fr[1]++;
            fr[2]--;
            if(fr[1]>=0 && fr[2]>=0 && !set.contains(fr[1]+","+fr[2])){
                pq.add(new int[]{A.get(fr[1])+B.get(fr[2]),fr[1],fr[2]});
                set.add(fr[1]+","+fr[2]);
            }
        }
        return res;
    }
}
