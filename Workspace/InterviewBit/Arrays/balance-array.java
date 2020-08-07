public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int[] prefixSumOdd=new int[n];
        int[] prefixSumEven=new int[n];
        int[] suffixSumOdd=new int[n];
        int[] suffixSumEven=new int[n];
        prefixSumEven[0]=A.get(0);
        for(int i=1;i<n;i++){
            prefixSumOdd[i]=prefixSumOdd[i-1]+(i%2!=0?A.get(i):0);
            prefixSumEven[i]=prefixSumEven[i-1]+(i%2==0?A.get(i):0);
        }
        if(n%2==0){
            suffixSumOdd[n-1]=A.get(n-1);            
        }else{
            suffixSumEven[n-1]=A.get(n-1);
        }
        for(int i=n-2;i>=0;i--){
            suffixSumOdd[i]=suffixSumOdd[i+1]+(i%2!=0?A.get(i):0);
            suffixSumEven[i]=suffixSumEven[i+1]+(i%2==0?A.get(i):0);
        }
        int count=0;
        for(int i=0;i<n;i++){
            int oddIndexSum=0,evenIndexSum=0;
            if(i>=1){
                oddIndexSum+=prefixSumOdd[i-1];
                evenIndexSum+=prefixSumEven[i-1];
            }
            if(i<=n-2){
                oddIndexSum+=suffixSumEven[i+1];
                evenIndexSum+=suffixSumOdd[i+1];
            }
            if(oddIndexSum==evenIndexSum){
                count++;
            }
        }
        return count;
    }
    
    
    // Array       2 1 6 4
    // prsumEven : 2 2 8 8
    // prsumOdd  : 0 1 1 5
    // sufEven   : 8 6 6 0
    // sufOdd    : 5 5 4 4
    // after removal : 
    // suffix odd will be suffix even and suffix even will be suffix odd
    // even sum = prefixEven[index-1]+suffixOdd[index+1]
    // odd sum = prefixOdd[index-1]+suffixEven[index+1]
}
