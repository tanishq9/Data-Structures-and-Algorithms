public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer> map=new HashMap<>();
        /*
        int[] prefix=new int[A.size()];
        prefix[0]=A.get(0);
        for(int i=1;i<A.size();i++){
            prefix[i]=A.get(i)^prefix[i-1];
        }
        */
        
        int count=0,rxor=0;
        map.put(0,1);
        for(int i=0;i<A.size();i++){
            rxor^=A.get(i);
            count+=map.getOrDefault(rxor^B,0);
            map.put(rxor,map.getOrDefault(rxor,0)+1);
        }
        return count;
    }
}
