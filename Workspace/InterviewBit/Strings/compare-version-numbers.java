import java.math.BigInteger;
public class Solution {
    public int compareVersion(String A, String B) {
        int i=0,j=0;
        while(i<A.length() || j<B.length()){
            // If one version is shorter in length then its contribution will be 
            // counted as 0 for further iterations 
            String ABeforeDot="0";
            String BBeforeDot="0";
            while(i<A.length() && A.charAt(i)!='.'){
                ABeforeDot+=A.charAt(i++);
            } 
            while(j<B.length() && B.charAt(j)!='.'){
                BBeforeDot+=B.charAt(j++);
            } 
            BigInteger b1=new BigInteger(ABeforeDot);
            BigInteger b2=new BigInteger(BBeforeDot);
            int diff=b1.compareTo(b2);
            if(diff!=0){
                return diff>0?1:-1;
            }
            i++; // skip past the dot to further process number
            j++; // skip past the dot to further process number
        }
        return 0;
    }
}
