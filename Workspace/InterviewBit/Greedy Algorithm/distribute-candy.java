public class Solution {
    public int candy(ArrayList<Integer> A) {
        int sum=0;
        int[] candies=new int[A.size()];
        Arrays.fill(candies,1);
        for(int i=1;i<A.size();i++){
            if(A.get(i)>A.get(i-1)){
                candies[i]=candies[i-1]+1;
            }
        }
        for(int i=A.size()-2;i>=0;i--){
            if(A.get(i)>A.get(i+1)){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        for(int i=0;i<A.size();i++){
            sum+=candies[i];
        }
        return sum;
    }
}
