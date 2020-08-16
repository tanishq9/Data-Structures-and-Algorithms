public class Solution {
    public int jump(ArrayList<Integer> A) {
        if(A.size()==1){
            return 0;
        }
        int i=0,min=0;
        while(true){
            int jump=A.get(i);
            // If I take a jump and can reach the last index then return from here
            if(i+jump>=A.size()-1){
                return min+1; // +1 for taking that jump
            }
            // If maximum jump that can be taken is 0 then there is no way from it forward so return -1
            if(jump==0){
                return -1;
            }
            int bestCandidate=i+1;
            int bestCandidateDistance=i+1+A.get(i+1);
            for(int j=i+2;j<A.size() && j<=i+jump;j++){
                if(j+A.get(j)>bestCandidateDistance){
                    bestCandidate=j;
                    bestCandidateDistance=j+A.get(j);
                }
            }
            // making the greedy choice and choosing the cell which takes me farthest
            i=bestCandidate;
            min+=1;
        }
    }
}
