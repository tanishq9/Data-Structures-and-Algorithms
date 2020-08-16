public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.size();i++){
            dp.add(new ArrayList<>());
            for(int j=0;j<a.get(i).size();j++){
                dp.get(i).add(Integer.MAX_VALUE);
            }
        }
        dp.get(0).set(0,a.get(0).get(0));
        for(int i=1;i<a.size();i++){
            for(int j=0;j<a.get(i).size();j++){
                if(j<a.get(i-1).size()){
                    dp.get(i).set(j,dp.get(i-1).get(j));
                }
                if(j-1>=0){
                    dp.get(i).set(j,Math.min(dp.get(i).get(j),dp.get(i-1).get(j-1)));
                }
                dp.get(i).set(j,dp.get(i).get(j)+a.get(i).get(j));
                if(i==a.size()-1){
                    min=Math.min(min,dp.get(i).get(j));                
                }
            }
        }
        return min==Integer.MAX_VALUE?dp.get(0).get(0):min;
    }
}
