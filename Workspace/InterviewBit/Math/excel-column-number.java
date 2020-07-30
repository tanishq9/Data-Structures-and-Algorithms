public class Solution {
    public int titleToNumber(String A) {
        int res=0;
        for(int i=0;i<A.length();i++){
            char cc=A.charAt(i);
            res+=(cc-'A'+1)*Math.pow(26,A.length()-i-1);
        }
        return res;
    }
}