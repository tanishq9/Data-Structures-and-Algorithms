public class Solution {
    public int solve(ArrayList<Integer> A) {
        // Approach : Consider the length of the array and observe how many times an element will be included in total subarrays
        // if even length then array element at every index will be included even length number of times and hence its xor contribution will be 0
        // if odd length then array element at odd index will contribute 1 to total xor of all subarrays
        int n=A.size();
        int res=0;
        if(n%2==0){
            return 0;
        }
        for(int i=0;i<n;i+=2){
            res^=A.get(i);
        }
        return res;
    }
}