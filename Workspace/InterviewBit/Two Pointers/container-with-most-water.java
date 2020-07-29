public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        int p1=0,p2=A.size()-1,max=0;
        while(p1<p2){
            int area=(p2-p1)*Math.min(A.get(p1),A.get(p2));
            max=Math.max(max,area);
            if(A.get(p1)>A.get(p2)){
                p2--;
            }else{
                p1++;
            }
        }
        return max;
    }
}
