class Solution {
    public int hammingDistance(int x, int y) {
        int count=0;
        for(int i=0;i<32;i++){
            int mask=1<<i;
            if((x&mask)!=0 && (y&mask)==0){
                count++;
            }else if((x&mask)==0 && (y&mask)!=0){
                count++;
            }
        }
        return count;
    }
}