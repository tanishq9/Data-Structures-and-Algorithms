public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        if(A.size()==0){
            return 0;
        }
        int n=A.size();
        int m=A.get(0).size();
        int count=0;
        for(int left=0;left<m;left++){
            int[] temp=new int[n];
            for(int right=left;right<m;right++){
                for(int i=0;i<n;i++){
                    temp[i]+=A.get(i).get(right);
                }
                count+=get(temp);
            }
        }
        return count;
    }
    int get(int[] temp){
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0,rsum=0;
        map.put(0,1);
        for(int i=0;i<temp.length;i++){
            rsum+=temp[i];
            if(map.containsKey(rsum)){
                // got a 0 zero sum submatrix
                count+=map.get(rsum);
            }
            map.put(rsum,map.getOrDefault(rsum,0)+1);
        }
        return count;
    }
}
