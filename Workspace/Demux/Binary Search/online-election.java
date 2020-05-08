class TopVotedCandidate {
    int[] winning,times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.winning=new int[times.length];
        this.times=times;
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxFreq=1,maxEle=persons[0];
        for(int i=0;i<times.length;i++){
            int freq=map.getOrDefault(persons[i],0)+1;
            if(freq>=maxFreq){
                maxFreq=freq;
                maxEle=persons[i];
            }
            winning[i]=maxEle;
            map.put(persons[i],freq);
        }
    }
        
    public int q(int t) {
        // last false : f*t* // ffftt 
        // predicate : pred(x) : arr[i]>t
        int lo=0,hi=this.times.length-1,mid;
        while(lo<hi){
            mid=lo+(hi-lo+1)/2;
            if(this.times[mid]>t){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        return winning[lo];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */