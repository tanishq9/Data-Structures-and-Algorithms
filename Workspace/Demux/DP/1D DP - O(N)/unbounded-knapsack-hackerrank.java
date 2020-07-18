static int unboundedKnapsack(int k, int[] arr) {
        int[] dp=new int[k+1];
        dp[0]=1;
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i];j<=k;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        for(int i=k;i>=0;i--){
            if(dp[i]>0){
                return i;
            }
        }
        return -1;
    }