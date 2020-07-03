class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int i=0,totalLen=str.length();
        while(i<str.length()/2){
            int currLen=i+1;
            if(totalLen%currLen==0){
                // possible multiple
                boolean flag=true;
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(j)!=str.charAt(j%currLen)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}