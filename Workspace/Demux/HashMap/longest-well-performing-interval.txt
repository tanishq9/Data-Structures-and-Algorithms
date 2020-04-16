class Solution {
    public int longestWPI(int[] hours) {
        int max=0;
        int rsum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        // runningSum, its occurance 
        map.put(rsum,-1);
        for(int i=0;i<hours.length;i++){
            rsum+=hours[i]>8?1:-1;
            if(rsum>0){
                max=i+1;
            }else{
                max=Math.max(max,i-map.getOrDefault(rsum-1,hours.length));
                map.putIfAbsent(rsum,i);
            }
        }
        return max;
    }
}

    