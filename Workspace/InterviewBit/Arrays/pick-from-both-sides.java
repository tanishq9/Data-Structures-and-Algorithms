public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n=A.size(),sum=0;
        for(int i=0;i<=B-1;i++){
            sum+=A.get(i);
        }
        int max=sum;
        for(int i=B-1,j=n-1;i>=0;i--,j--){
            sum-=A.get(i);
            sum+=A.get(j);
            max=Math.max(max,sum);
        }
        return max;
    }
    
    /*public int solveTLE_O(N2)(ArrayList<Integer> A, int B) {
        int n=A.size(),max=Integer.MIN_VALUE;
        // B-k elements from start and k elements from the end
        for(int k=0;k<=B;k++){
            int fromStart=B-k,indexStart=0;
            int fromEnd=k,indexEnd=n-1;
            int sum=0;
            while(fromStart-->0){
                sum+=A.get(indexStart++);
            }
            while(fromEnd-->0){
                sum+=A.get(indexEnd--);
            }
            max=Math.max(max,sum);
        }
        return max;
    }*/
}
