class Solution {
    
    HashMap<Character,Integer> map;
    
    class myC implements Comparator<Character>{
        public int compare(Character c1,Character c2){
            if(map.containsKey(c1) && map.containsKey(c2)){
                return map.get(c1)-map.get(c2);
            }else if(map.containsKey(c1)){
                return -1;
            }else if(map.containsKey(c2)){
                return 1;
            }else{
                return (int)(c1-c2);
            }
        }
    }
    
    public String customSortString(String S, String T) {
        map=new HashMap<>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),i);
        }
        ArrayList<Character> list=new ArrayList<>();
        for(char cc:T.toCharArray()){
            list.add(cc);
        }
        Collections.sort(list,new myC());
        StringBuilder sb=new StringBuilder();
        for(char cc:list){
            sb.append(cc);
        }
        return sb.toString();
    }
}