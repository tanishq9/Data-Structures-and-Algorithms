public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        int n=A.size(),max=A.get(n-1);
        res.add(max);
        for(int i=n-2;i>=0;i--){
            if(A.get(i)>max){
                res.add(A.get(i));
            }
            max=Math.max(max,A.get(i));
        }
        return res;
    }
}
