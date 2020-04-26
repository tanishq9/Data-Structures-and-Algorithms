https://leetcode.com/problems/maximum-score-after-splitting-a-string/

class Solution {
    public int maxScore(String s) {
        int n =s.length();
        int[] z=new int[n];
        int[] o=new int[n];
        for(int i=0;i<n;i++){
            char cc=s.charAt(i);
            if(cc=='0'){
                z[i]=1;
            }else if(cc=='1'){
                o[i]=1;
            }
        }
        for(int i=1;i<n;i++){
            z[i]+=z[i-1];
        }
        for(int i=1;i<n;i++){
            o[i]+=o[i-1];
        }
        
        int max=0;
        for(int i=0;i<=n-2;i++){
            int lz=z[i];
            int ro=o[n-1]-o[i];
            max=Math.max(max,lz+ro);
        }
        return max;
    }
}