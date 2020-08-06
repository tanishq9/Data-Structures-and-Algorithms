public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        // KMP
        // GET THE LPS ARRAY
        // USE THIS LPS ARRAY TO CHECK FOR SUBSTRING B IN A
        int[] lps=getLPS(B);
        int i=0,j=0;
        while(j<A.length()){
            while(j<A.length() && i<B.length() && A.charAt(j)==B.charAt(i)){
                i++;
                j++;
            }
            if(i==B.length()){
                return j-i;
            }else{
                // mismatch
                // we will look for which character in pattern string i.e A, we should now continue matching from
                if(i>0){
                    i=lps[i-1];                    
                }else{
                    j++;
                }
            }
            
        }
        return -1;
    }
    // lps : abcdabc 
    //       0000123
    // longest proper prefix which is also longest proper suffix
    int[] getLPS(String str){
        int[] lps=new int[str.length()];
        lps[0]=0; // lps[0] i.e longest proper prefix which is also a proper suffix is of length 0 for 1st character(cannot include it as 'proper')
        int i=0,j=1;
        while(j<str.length()){
            if(str.charAt(i)==str.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }else{
                if(i>0){
                    i=lps[i-1];
                }else{
                    j++;
                }
            }
        }
        return lps;
    }
}
