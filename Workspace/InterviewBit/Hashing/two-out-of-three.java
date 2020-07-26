public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        HashMap<Integer,Integer> map3=new HashMap<>();
        
        HashSet<Integer> set=new HashSet<>();

        // For A
        for(int e:A){
            map1.put(e,1);
        }
        // For B
        for(int e:B){
            map2.put(e,1);
        }
        // For C
        for(int e:C){
            map3.put(e,1);
        }
        for(int key:map1.keySet()){
            if(map2.containsKey(key) || map3.containsKey(key)){
                set.add(key);
            }
        }
        for(int key:map2.keySet()){
            if(map1.containsKey(key) || map3.containsKey(key)){
                set.add(key);
            }
        }
        for(int key:map3.keySet()){
            if(map1.containsKey(key) || map2.containsKey(key)){
                set.add(key);
            }
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}
