class Solution {
    
    class Pair{
        int val;
        int freq;
        Pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        // O(n)
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair one,Pair two){
                return one.freq-two.freq;
            }
        });
        // O(nlogk)
        for(int key:count.keySet()){
            pq.add(new Pair(key,count.get(key)));
            if(pq.size()>k){
                pq.remove();
            }
        }
        // O(k)
        int[] res=new int[pq.size()];
        int index=0;
        while(pq.size()>0){
            res[index++]=pq.remove().val;
        }
        // overall : O(nlogk), better than previous solution of O(nlogn)
        return res;
    }
}