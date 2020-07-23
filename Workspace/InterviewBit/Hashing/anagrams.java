public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        HashMap<String,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<A.size();i++){
            char[] arr=A.get(i).toCharArray();
            int[] freq=new int[256];
            for(int k=0;k<arr.length;k++){
                freq[arr[k]]+=1;
            }
            String key="";
            for(int k=0;k<256;k++){
                key+=(freq[k]+"#");
            }
            if(!map.containsKey(key)){
                ArrayList<Integer> list=new ArrayList<>();
                list.add(i+1);
                map.put(key,list);
            }else{
                ArrayList<Integer> list=map.get(key);
                list.add(i+1);
                map.put(key,list);
            }
        }
        for(String key:map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
