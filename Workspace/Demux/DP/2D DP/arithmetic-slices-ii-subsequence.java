class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // map of common difference and number of arthimetic sequence of this difference having length 2 or more and ending at index i
        HashMap<Long,Integer>[] arr=new HashMap[A.length];
        for(int i=0;i<A.length;i++){
            arr[i]=new HashMap<>();
        }
        int count=0;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<=i-1;j++){
                long diff=(long)A[i]-(long)A[j];
                if(arr[j].containsKey(diff)){
                    count+=arr[j].get(diff);
                    arr[i].put(diff,arr[i].getOrDefault(diff,0)+arr[j].get(diff)+1);
                }else{
                    arr[i].put(diff,arr[i].getOrDefault(diff,0)+1);
                }
                
            }
        }
        // consider test case : [0,2,2,4,6] for understanding
        return count;
    }
}