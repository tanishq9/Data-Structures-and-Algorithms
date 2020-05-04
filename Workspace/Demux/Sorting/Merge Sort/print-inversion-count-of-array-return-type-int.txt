class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int total=sort(nums,0,nums.length-1);
        System.out.println(total);
        return null;
    }
    
    int sort(int[] nums,int start,int end){
        if(start==end){
            return 0;
        }
        int mid=start+(end-start)/2;
        int fh=sort(nums,start,mid);
        int sh=sort(nums,mid+1,end);
        return fh+sh+merge(nums,start,end,mid);
    }
    
    int merge(int[] nums,int start,int end,int mid){
        int i=start,j=mid+1,index=0;
        int[] res=new int[end-start+1];
        int c=0;
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
        return c;
    }
    
    
}