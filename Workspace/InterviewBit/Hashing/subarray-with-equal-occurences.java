public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C) {
        HashMap<Integer,Integer> map=new HashMap<>();
        // map of difference between occurrance of B and C element & that count ki kitni baar yeh difference pehle aur aaya hai
        map.put(0,1);
        int countB=0,countC=0,count=0;
        for(int i=0;i<A.size();i++){
            int num=A.get(i);
            if(num==B){
                countB++;
            }else if(num==C){
                countC++;
            }
            int diff=countB-countC;
            count+=map.getOrDefault(diff,0);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return count;
    }
}
