class Solution {
    int c;
    public List<Integer> countSmaller(int[] nums) {
        c=0;
        sort(nums,0,nums.length-1);
        System.out.println(c);
        return null;
    }
    
    void sort(int[] nums,int start,int end){
        if(start==end){
            return;
        }
        int mid=start+(end-start)/2;
        sort(nums,start,mid);
        sort(nums,mid+1,end);
        merge(nums,start,end,mid);
    }
    
    void merge(int[] nums,int start,int end,int mid){
        int i=start,j=mid+1,index=0;
        int[] res=new int[end-start+1];
        while(i<=mid && j<=end){
            if(nums[i]>nums[j]){
                res[index++]=nums[j++];
                c+=mid-i+1;
            }else{
                res[index++]=nums[i++];
            }
        }
        while(i<=mid){
            res[index++]=nums[i++];
        }
        while(j<=end){
            res[index++]=nums[j++];
        }
        for(int k=start;k<=end;k++){
            nums[k]=res[k-start];
        }
    }
    
    
}