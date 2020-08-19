public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int r=A.get(0).get(0); // cost of painting current house with color red such that previous house is not painted red
        int b=A.get(0).get(1); // cost of painting current house with color blue such that previous house is not painted blue
        int g=A.get(0).get(2); // cost of painting current house with color green such that previous house is not painted green
        for(int i=1;i<A.size();i++){
            int newR=Math.min(b,g)+A.get(i).get(0);
            int newB=Math.min(r,g)+A.get(i).get(1);
            int newG=Math.min(r,b)+A.get(i).get(2);
            r=newR;
            b=newB;
            g=newG;
        }
        return Math.min(r,Math.min(b,g));
    }
}
