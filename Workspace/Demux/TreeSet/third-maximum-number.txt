class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> tset=new TreeSet<>();
        // time complexity is O(n*(3log3)) ~ O(n)
        for(int num:nums){
            if(!tset.contains(num)){ // log3
                if(tset.size()==3){ // 1
                    if(tset.first()<num){ // 1
                        tset.pollFirst(); // 1
                        tset.add(num); // log3
                    }
                }else{
                    tset.add(num); // log3
                }       
            }
        }
        if(tset.size()<3){
            return tset.last(); // 1
        }
        tset.pollLast(); // 1
        tset.pollLast(); // 1
        return tset.first(); // 1
    }
}