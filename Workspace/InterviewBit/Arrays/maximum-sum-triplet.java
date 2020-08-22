public class Solution {
    public int solve(ArrayList<Integer> A) {
        // int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
        int n=A.size();
        TreeSet<Integer> tset=new TreeSet<>();
        int[] maxR=new int[n];
        maxR[n-1]=A.get(n-1);
        for(int i=n-2;i>=0;i--){
            maxR[i]=Math.max(maxR[i+1],A.get(i));
        }
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<=n-3;i++){
            if(maxR[i+1]>A.get(i) && tset.lower(A.get(i))!=null){
                maxSum=Math.max(maxSum,tset.lower(A.get(i))+A.get(i)+maxR[i+1]);
            }
            tset.add(A.get(i));
        }
        return maxSum;
    }
}
