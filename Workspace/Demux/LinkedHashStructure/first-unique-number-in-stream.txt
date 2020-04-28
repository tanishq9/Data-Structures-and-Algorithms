class FirstUnique {
    LinkedHashSet<Integer> set;
    HashSet<Integer> repeated;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
        repeated = new HashSet<>();
        // init the set
        for(int value:nums){
            if(!repeated.contains(value)){
                set.add(value);
                repeated.add(value);
            }else{
                set.remove(value);
            }
        }
    }
    
    public int showFirstUnique() {
        if(set.iterator().hasNext()){
            return set.iterator().next();
        }else{
            return -1;
        }
    }
    
    public void add(int value) {
        if(!repeated.contains(value)){
            set.add(value);
            repeated.add(value);
        }else{
            set.remove(value);
        }
    }
        
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */