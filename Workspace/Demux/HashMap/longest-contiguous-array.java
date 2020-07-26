class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int count0=0,count1=0,max=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num==0){
                count0++;
            }else if(num==1){
                count1++;
            }
            int diff=count0-count1;
            if(map.containsKey(diff)){
                max=Math.max(max,i-map.get(diff));
            }else{
                map.put(diff,i);
            }
        }
        return max;
    }
}