class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        // i+2 because to consider a triangle 3 sides are needed
        for(int i=0;i<=(nums.length-3);i++){
            int k=i+2;
            for(int j=i+1;j<=(nums.length-2) && nums[i]!=0;j++){
                // keep decrementing k until we get valid triangle
                while(k<nums.length && nums[k]<nums[i]+nums[j]){
                    k++;
                }
                count+=(k-j-1);
            }
        }
        return count;
    }
}

// I think solution#3 should be O(n^3), anybody?
// how come inner loop takes 2N? as you've mentioned 1 + 2 + 3 + ... +n iterations gives (n+n^2)/2 in total but not 2n.
// I see why you might think that, with the three nested loops, but you'll notice the while loop will not iterate over all elements each time. Instead, all runs through this while loop during one iteration of the outer for loop will together cover all elements.
/*For instance, with i = 0, j = 1, k will run from 2 to a1; with i = 0, j = 2, k will run from a1 to a2; with i = 0, j = 3, k will run from a2 to a3, ... In total, with i = 0, j will run from 1 to n once, and k will run from 2 to n once, making for a runtime of O(2n) = O(n) for each iteration of the outer loop. Since there are n such iterations, the entire process has a runtime of O(n²).
*/
