https://leetcode.com/problems/time-based-key-value-store

class TimeMap {

    /** Initialize your data structure here. */
    HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key,new TreeMap<>());
        
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> tmap=map.get(key);
        Integer t = tmap.floorKey(timestamp);
        return t!=null ? tmap.get(t):"";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */