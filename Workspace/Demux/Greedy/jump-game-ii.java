class Solution {
    public int jump(int[] A) {
        if(A.length==1){
            return 0;
        }
        int i=0,min=0;
        while(true){
            int jump=A[i];
            // If I take a jump and can reach the last index then return from here
            if(i+jump>=A.length-1){
                return min+1; // +1 for current jump
            }
            // If maximum jump that can be taken is 0 then it is no way from it forward so return -1
            if(jump==0){
                return -1;
            }
            // choose the best position to jump to from current spot on basis of which cells takes me farthest
            int bestCandidate=i+1;
            int bestCandidateDistance=i+1+A[i+1];
            for(int j=i+2;j<A.length && j<=i+jump;j++){
                if(j+A[j]>bestCandidateDistance){
                    bestCandidate=j;
                    bestCandidateDistance=j+A[j];
                }
            }
            // making the greedy choice and choosing the cell which takes me farthest
            i=bestCandidate;
            min+=1;
        }
    }
}