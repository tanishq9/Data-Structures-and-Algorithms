class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostKOdd(nums,k)-atMostKOdd(nums,k-1);
    }
    public int atMostKOdd(int[] A,int k){
        int start=0,end=0,count=0;
        while(end<A.length){
            if(A[end]%2!=0){
                k--;
            }
            while(k<0){
                if(A[start]%2!=0){
                    k++;
                }
                start++;
            }
            count+=(end-start+1); 
            end++;
        }
        return count;
    }
}