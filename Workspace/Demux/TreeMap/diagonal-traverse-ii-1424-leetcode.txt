class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        int count=0;
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                count++;
                int key=i+j;
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(nums.get(i).get(j));
            }
        }
        int[] res=new int[count];
        int index=0;
        while(map.size()>0){
            int key=map.firstKey();
            ArrayList<Integer> l=map.get(key);
            for(int i=l.size()-1;i>=0;i--){
                res[index++]=l.get(i);
            }
            map.pollFirstEntry();
        }
        return res;
    }
}