class Solution {
    
    public int predicate(int[] arr,int mid){
        int sum=0;
        for(int num:arr){
            if(num>mid){
                sum+=mid;
            }else{
                sum+=num;
            }
        }
        return sum;
    }
    
    public int findBestValue(int[] arr, int target) {
        if(arr==null || arr.length==0){
            return -1;
        }
        int lo=0,hi=Integer.MIN_VALUE,mid,val1=-1,val2=-1;
        for(int num:arr){
            hi=Math.max(hi,num);
        }
        // ss : [0,max(arr)]
        // fftt : last f for closest smaller
        // pred(x) : arr[x] > target  
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(predicate(arr,mid) > target){
                hi=mid-1;
            }else{
                val1=mid;
                lo=mid;
            }
        }
        // sanity check
        if(!(predicate(arr,val1)>target)){
            val1=lo;
        }
        for(int num:arr){
            hi=Math.max(hi,num);
        }
        // ss : [0,max(arr)]
        // fftt : first t for closest greater equal
        // pred(x) : arr[x] >= target
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(predicate(arr,mid)>=target){
                hi=mid;
                val2=mid;
            }else{
                lo=mid+1;
            }
        }
        if(predicate(arr,val2)>=target){
            val2=lo;
        }
        if(Math.abs(predicate(arr,val1)-target)<=Math.abs(predicate(arr,val2)-target)){
            return val1;
        }else{
            return val2;
        }
    }
}