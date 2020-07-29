public class Solution {
    public int seats(String A) {
        ArrayList<Integer> x_position=new ArrayList<>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='x'){
                x_position.add(i);
            }
        }
        int MOD=10000003;
        int median=x_position.size()/2;
        // therefore if median is 5 and size of x's array is 6 then
        // the range to fit all x together will be [3,4,5,6,7] i.e [3,7], we will try that
        int jumps=0;
        for(int i=0;i<x_position.size();i++){
            int oldPosition=x_position.get(i);
            int newPosition=x_position.get(median)-median+i;
            jumps=(jumps%MOD+Math.abs(newPosition-oldPosition)%MOD)%MOD;
        }
        return jumps%MOD;
    }
}
