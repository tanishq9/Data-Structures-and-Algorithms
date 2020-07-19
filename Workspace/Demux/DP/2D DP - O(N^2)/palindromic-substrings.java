class Solution {
    public int countSubstrings(String s) {
        boolean[][] isPalindrome=new boolean[s.length()][s.length()];
        int count=0;
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=i+gap;j<s.length();i++,j++){
                if(gap==0){
                    isPalindrome[i][j]=true;
                }else if(gap==1){
                    isPalindrome[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    if(s.charAt(i)==s.charAt(j) && isPalindrome[i+1][j-1]){
                        isPalindrome[i][j]=true;
                    }
                }
                if(isPalindrome[i][j]==true){
                    count++;
                }
            }
        }
        return count;
    }
}