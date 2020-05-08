public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int rsum=0,count=0;
        map.put(rsum,1);
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
            if(map.containsKey(rsum-k)){
                count+=map.get(rsum-k);
            }
            map.put(rsum,map.getOrDefault(rsum,0)+1);
        }
        return count;
    }