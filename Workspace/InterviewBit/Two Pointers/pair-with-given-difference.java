public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int i=0,j=1;
        B=B<0?-B:B;
        while(i<A.size() && j<A.size()){
            if(i!=j){
                if(A.get(j)-A.get(i)<B){
                    j++;
                }else if(A.get(j)-A.get(i)>B){
                    i++;
                }else{
                    return 1;
                }
            }else{
                j++;
            }
        }
        return 0;
    }

    // Used Math.abs here instead of B conversion
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int i=0,j=1;
        while(i<A.size() && j<A.size()){
            if(i!=j){
                if(A.get(j)-A.get(i)<Math.abs(B)){
                    j++;
                }else if(A.get(j)-A.get(i)>Math.abs(B)){
                    i++;
                }else{
                    return 1;
                }
            }else{
                j++;
            }
        }
        return 0;
    }
}
