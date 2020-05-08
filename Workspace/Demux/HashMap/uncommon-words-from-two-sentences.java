class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> list = new ArrayList<>();
       
        HashMap<String,Integer> mapA=new HashMap<>();
        HashMap<String,Integer> mapB=new HashMap<>();
        for(String str:A.split(" ")){
            mapA.put(str,mapA.getOrDefault(str,0)+1);
        }
        for(String str:B.split(" ")){
            mapB.put(str,mapB.getOrDefault(str,0)+1);
        }
        for(String keyA:mapA.keySet()){
            if(mapA.get(keyA)==1){
                if(!mapB.containsKey(keyA)){
                    list.add(keyA);
                }  
            }  
        }
        for(String keyB:mapB.keySet()){
            if(mapB.get(keyB)==1){
                if(!mapA.containsKey(keyB)){
                    list.add(keyB);
                }  
            } 
        }
        String[] strs=new String[list.size()];
        for(int i=0;i<strs.length;i++){
            strs[i]=list.get(i);
        }
        return strs;
    }
}