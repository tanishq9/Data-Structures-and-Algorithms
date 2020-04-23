https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {

    /** Initialize your data structure here. */
    
    // hashmap and arraylist will be used
    // hashmap to store (element,index in array)
    // arraylist to store elements
    // we need arraylist becoz the range of elements is not fixed
    // so we need to index elements
    
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    // int index;
    
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        // index=0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // ADD to both MAP and LIST
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);   
            // index++;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            // UPDATE THE LIST
            int indexToBeRemoved=map.get(val);
            // swap last element of list with the item to be removed
            // then decrease the size of list
            int elementAtLastIndex = list.get(list.size()-1);
            list.set(indexToBeRemoved,elementAtLastIndex);
            list.remove(list.size()-1);
            
            // UPDATE THE MAP
            map.put(elementAtLastIndex,indexToBeRemoved);
            map.remove(val);
            
            // UPDATE THE INDEX
            // index--;
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */