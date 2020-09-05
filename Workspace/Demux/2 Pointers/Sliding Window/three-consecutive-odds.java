class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=0,i=0,j=0;
        while(j<arr.length){
            if(arr[j]%2==1){
                count+=1;
            }
            if(j-i+1==3){
                if(count==3){
                    return true;
                }
                if(arr[i]%2==1){
                    count--;
                }
                i++;
            }
            j++;
        }
        return false;
    }
}