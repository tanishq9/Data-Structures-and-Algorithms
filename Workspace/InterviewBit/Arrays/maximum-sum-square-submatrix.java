public class Solution {
    public int solve(int[][] A, int B) {
        int n=A.length,max=Integer.MIN_VALUE;
        for(int left=0;left<n;left++){
            int[] temp=new int[n];
            for(int right=left;right<n;right++){
                for(int k=0;k<n;k++){
                    temp[k]+=A[k][right];
                }
                if(right-left==B-1){
                    // System.out.println(Arrays.toString(temp));
                    int sum=0,i=0,j=0;
                    while(j<n){
                        sum+=temp[j];
                        if(j-i+1==B){
                            max=Math.max(max,sum);
                            sum-=temp[i];
                            i++;
                        }
                        j++;
                    }
                }
            }
        }
        return max;
    }
}/* 5 5
1 1 1 1 1
2 2 2 2 2
3 8 6 7 3
4 4 4 4 4
5 5 5 5 5     
3*/