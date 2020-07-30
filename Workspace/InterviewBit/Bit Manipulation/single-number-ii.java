public class Solution {
    public int singleNumber(final List<Integer> A) {
        // We calculate the number of set bits at each position i.e [0..31] 
        // and then take %3 at every position, if at any position bits[i]%3 == 1
        // it implies this bit occurred only once and was contributed by single element
        int[] bits=new int[32];
        for(int i=0;i<A.size();i++){
            int num=A.get(i);
            int index=0;
            while(num>0){
                bits[index++]+=num%2;
                num/=2;
            }
        }
        int res=0;
        for(int i=0;i<32;i++){
            bits[i]%=3;
            res+=bits[i]*Math.pow(2,i);
        }
        return res;
    }
}
