class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int start=0,end=0,max=Integer.MIN_VALUE,total_val=0;
        while(end<customers.length){
            // keep expanding till we get a valid solution
            int grumpy_state=grumpy[end];
            if(grumpy_state==1){
                total_val+=customers[end];
            }
            // if invalid, window size > 3
            if((end-start+1)>X){
                if(grumpy[start]==1){
                    total_val-=customers[start];
                }
                start++;
            }
            // since it is valid 
            if((end-start+1)<=X){
                max=Math.max(max,total_val);   
            }
            end++;
        }
        total_val=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                total_val+=customers[i];
            }
        }
        return total_val+max;
    }
}