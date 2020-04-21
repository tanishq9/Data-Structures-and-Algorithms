class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String domain:cpdomains){
            String[] part1=domain.trim().split(" ");
            String[] part2=part1[1].trim().split("\\.");
            StringBuilder sb=new StringBuilder();
            for(int i=part2.length-1;i>=0;i--){
                sb.insert(0,part2[i]);
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+Integer.valueOf(part1[0]));
                sb.insert(0,".");
            }
        }
        List<String> list=new ArrayList<>();
        for(String key:map.keySet()){
            list.add(map.get(key)+" "+key);
        }
        return list;
    }
}