package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class topKFrequentWords {
	class Pair implements Comparable<Pair>{
        String val;
        int freq;
        Pair(String val,int freq){
            this.val=val;
            this.freq=freq;
        }
        public int compareTo(Pair o){
            if(this.freq<o.freq){
                return 1;
            }else if(this.freq>o.freq){
                return -1;
            }else{
                return this.val.compareTo(o.val)>0?1:-1;
            }
       }
    }
    
 	 public List<String> topKFrequent(String[] words, int k) {
 	 
 	    HashMap<String, Integer> count = new HashMap();
        for (String word: words) {
          count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(String key:count.keySet()){
            pq.add(new Pair(key,count.get(key)));
        }
        ArrayList<String> top_k = new ArrayList();
        while(k-->0){
            top_k.add(pq.remove().val);
        }
        return top_k;
        
 	 }
}
