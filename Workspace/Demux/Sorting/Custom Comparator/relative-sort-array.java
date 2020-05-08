class Solution {
    HashMap<Integer,Integer> map;   
    
    class myC implements Comparator<Integer>{
        public int compare(Integer e1,Integer e2){
            if(map.containsKey(e1) && map.containsKey(e2)){
                return map.get(e1)-map.get(e2);    
            }else if(map.containsKey(e1)){
                return -1;
            }else if(map.containsKey(e2)){
                return 1;
            }else{
                return e1-e2;
            }
        }
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        map=new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }
        Integer[] arr = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,new myC());
        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}