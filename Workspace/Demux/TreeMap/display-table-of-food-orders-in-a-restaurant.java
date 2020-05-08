https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer,TreeMap<String,Integer>> table=new TreeMap<>();
        TreeSet<String> fitems=new TreeSet<>();
        for(List<String> list:orders){
            int tn=Integer.valueOf(list.get(1));
            String fi=list.get(2);
            fitems.add(fi);
            if(table.containsKey(tn)){
                TreeMap<String,Integer> oldMap=table.get(tn);
                oldMap.put(fi,oldMap.getOrDefault(fi,0)+1);
                table.put(tn,oldMap);
            }else{
                // init new map and add table number
                TreeMap<String,Integer> newMap=new TreeMap<>();
                newMap.put(fi,newMap.getOrDefault(fi,0)+1);
                table.put(tn,newMap);
            }
        }
        List<List<String>> res=new ArrayList<>();
        // add to list
        List<String> list=new ArrayList<>();
        list.add("Table");
        for(String str:fitems){
            list.add(str);
        }
        res.add(list);
        // add table orders to list
        for(Integer k:table.keySet()){
            list=new ArrayList<>();
            list.add(k+"");
            for(String str:fitems){
                list.add(table.get(k).getOrDefault(str,0)+"");
            }
            res.add(list);
        }
        return res;        
    }
}