public class Solution {
    public int solve(String s) {
        StringBuilder str=new StringBuilder();
        str.append(s);
        String rev=str.reverse().toString();
        str.reverse().append("#"+rev);
        int[] lps=getLPS(str.toString());
        // System.out.println(str.toString());
        return s.length()-lps[str.length()-1];
    }
    // bcbc#cbcb 
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
