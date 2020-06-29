class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer,Integer> tmap=new TreeMap<>();
        for(int i=0;i<difficulty.length;i++){
            tmap.put(difficulty[i],Math.max(tmap.getOrDefault(difficulty[i],0),profit[i]));
        }
        int max=0;
        // update keys incase the lower difficulty job has higher profit
        for(int key:tmap.keySet()){
            max=Math.max(max,tmap.get(key));
            tmap.put(key,max);
        }
        
        int sum=0;
        for(int w:worker){
            Integer floorKey=tmap.floorKey(w);           
            if(floorKey!=null){
                sum+=tmap.get(floorKey);
            }
        }
        return sum;
    }
}