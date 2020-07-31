class Solution {
    public boolean hasAlternatingBits(int n) {
        int pb=-1;
        while(n>0){
            int cb=n&1;
            if(pb!=-1 && cb==pb){
                return false;
            }
            pb=cb;
            n>>=1;
        }
        return true;
    }
}