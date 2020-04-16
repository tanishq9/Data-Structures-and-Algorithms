class Solution {
    public int findMaxLength(int[] nums) {
        int cz=0;
        int co=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        // first index : pehli baar voh difference kaha dekha tha
        // map will be (diff,firstIndex)
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(curr==0){
                cz++;
            }else{
                co++;
            }
            int diff = cz-co;
            if(map.containsKey(diff)){
                // update max length
                max=Math.max(max,i-map.get(diff));
            }
            else if(!map.containsKey(diff)){
                // update diff map if seeing a diff for first time
                map.put(diff,i);
            }
        }
        return max;
    }
}