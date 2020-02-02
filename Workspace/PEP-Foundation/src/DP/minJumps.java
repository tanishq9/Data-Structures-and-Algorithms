package DP;

public class minJumps {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 3, 0, 0, 0, 1 };
		System.out.println("\n" + minPath(arr));
		long[] d =new long[23];
		ways(d,2);
	}

	private static Integer minPath(Integer[] arr) {
		Integer[] dp = new Integer[arr.length];
		dp[arr.length - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = i + 1; j <= arr[i] + i && j < arr.length; j++) {
				if (dp[j] != null) {
					dp[i] = dp[i] == null ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[0];
	}
	private static void ways(long[] dp,int n){
	    dp[0] = 1;
	    for(long i=1;i<n;i++){
            if((i-1)>=0){
                dp[(int) i]=dp[(int) i]+dp[(int) (i-1)];
            }
            if((i-2)>=0){
                dp[(int) i]=dp[(int) i]+dp[(int) (i-2)];
            }
	    }
	}
}
