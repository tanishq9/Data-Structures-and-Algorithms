public class Solution {
    public int nTriang(ArrayList<Integer> A) {
        Collections.sort(A);
        int count=0,mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<=A.size()-3;i++){
            int k=i+2;
            for(int j=i+1;j<=A.size()-2;j++){
                while(k<A.size() && A.get(k)<A.get(i)+A.get(j)){
                    k++;
                }
                count=(count%mod+(k-j-1)%mod)%mod;
            }
        }
        return count%mod;
    }
}
