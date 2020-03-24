class Solution {
public:
    int peakIndexInMountainArray(vector<int>& A) {
        // last f
        int lo=0,hi=A.size()-1;
        while(lo<hi){
            int mid=lo+(hi-lo+1)/2;
            if(A[mid]<A[mid-1]){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        return lo;
    }
};