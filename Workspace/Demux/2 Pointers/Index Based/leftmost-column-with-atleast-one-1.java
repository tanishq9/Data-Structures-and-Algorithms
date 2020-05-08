/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions() {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        // In(O(N+M)) time complexity
        List<Integer> dims=binaryMatrix.dimensions();
        int n=dims.get(0);
        int m=dims.get(1);
        int i=0,j=m-1;
        int ans=-1;
        while(i<n && j>=0){
            int current=binaryMatrix.get(i,j);
            if(current==0){
                // matlab uss row mei answer nhi hai
                i++;
            }else{
                // matlab iss row mei answer hai, toh isse 
                // bhi pehle koi 1 aata hai issi row mei
                // voh check karte hai
                // update answer and move j leftwards for
                // a better solution if exists
                ans=j;
                j--;
            }
        }
        return ans;
    }
}