public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        // element and its first occurrance map
        map.put(0,-1);
        int rsum=0;
        int max=0;
        int maxi=-1;
        int maxj=-1;
        for(int i=0;i<A.size();i++){
            rsum+=A.get(i);
            if(map.containsKey(rsum)){
                if(max<i-map.get(rsum)){
                    max=i-map.get(rsum);
                    maxi=map.get(rsum);
                    maxj=i;
                }
                max=Math.max(max,i-map.get(rsum));
            }
            map.putIfAbsent(rsum,i);
        }
        for(int i=maxi+1;i<=maxj;i++){
            res.add(A.get(i));
        }
        return res;
    }
}
