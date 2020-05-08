class Solution {
    class Pair{
        int val;
        int index;
        Pair(int iv,int ii){
            this.val=iv;
            this.index=ii;
        }
    }
        
    public List<Integer> countSmaller(int[] nums) {
        Pair[] pairs=new Pair[nums.length];
        int[] count=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            pairs[i]=new Pair(nums[i],i);
        }
        sort(pairs,count,0,nums.length-1);
        List<Integer> res=new ArrayList<>();
        for(int c:count){
            res.add(c);
        }
        return res;
    }
    
    void sort(Pair[] pairs,int[] count,int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        sort(pairs,count,start,mid);
        sort(pairs,count,mid+1,end);
        merge(pairs,count,start,end,mid);
    }
    
    void merge(Pair[] pairs,int[] count,int start,int end,int mid){
        int i=start,j=mid+1,index=0;
        Pair[] res=new Pair[end-start+1];
        for(int k=0;k<res.length;k++){
            res[k]=new Pair(0,0);
        }
        int rightcount=0;
        while(i<=mid && j<=end){
            if(pairs[i].val>pairs[j].val){
                res[index++]=pairs[j++];
                // update the right count
                rightcount++;
            }else{
                // assign inversion count to array element 
                count[pairs[i].index]+=rightcount;
                res[index++]=pairs[i++];
            }
        }
        while(i<=mid){
            count[pairs[i].index]+=rightcount;
            res[index++]=pairs[i++];
        }
        while(j<=end){
            res[index++]=pairs[j++];
        }
        for(int k=start;k<=end;k++){
            pairs[k]=res[k-start];
        }
    }
    
    
}