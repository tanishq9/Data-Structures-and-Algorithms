public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res=new ArrayList<>();
        int start=0,end=0,gs=-1,ge=-1,max=Integer.MIN_VALUE;
        while(end<A.size()){
            // keep expanding till valid
            int val=A.get(end);
            if(val==0){
                B--;
            }
            // if invalid, then shrink till window becomes valid again
            while(B<0){
                val=A.get(start);
                if(val==0){
                    B++;
                }
                // keep releasing
                start++;
            }
            // if valid i,e B>=0
            if(end-start+1>max){
                gs=start;
                ge=end;
                max=end-start+1;
            }
            
            // acquire more
            end++;
        }
        for(int i=gs;i<=ge;i++){
            res.add(i);
        }
        return res;
    }
}
