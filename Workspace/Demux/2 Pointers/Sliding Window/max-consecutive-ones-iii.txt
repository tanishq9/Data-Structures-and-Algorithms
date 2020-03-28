class Solution {
    public int longestOnes(int[] A, int K) {
        int start=0,end=0,max=Integer.MIN_VALUE;
        while(end<A.length){
            int num=A[end];
            if(num==0){
                K--;
            }
            // if invalid
            while(K<0){
                num=A[start];
                if(num==0){
                    K++;
                }
                // keep releasing
                start++;
            }
            // if valid, then update maximum length
            max=Math.max(max,end-start+1);
           
            // acquire more
            end++;
        }
        return max;
    }
}