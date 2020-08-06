public class Solution {
    public String longestPalindrome(String A) {
        if(A.length()==0){
            return "";
        }
        int maxLen=0,startMax=0,endMax=0;
        boolean[][] lps=new boolean[A.length()][A.length()];
        for(int gap=0;gap<A.length();gap++){
            for(int i=0,j=i+gap;j<A.length();i++,j++){
                if(gap==0){
                    lps[i][j]=true;
                }else if(gap==1){
                    if(A.charAt(i)==A.charAt(j)){
                        lps[i][j]=true;
                    }
                }else{
                    if(A.charAt(i)==A.charAt(j) && lps[i+1][j-1]==true){
                        lps[i][j]=true;
                    }
                }
                if(lps[i][j]==true){
                    int currentLen=j-i+1;
                    if(currentLen>maxLen){
                        maxLen=currentLen;
                        startMax=i;
                        endMax=j;
                    }
                }
            }
        }
        return A.substring(startMax,endMax+1);
    }
}
