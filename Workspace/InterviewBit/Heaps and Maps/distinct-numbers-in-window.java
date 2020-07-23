public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0;
        while(j<A.size()){
            // update the map 
            map.put(A.get(j),map.getOrDefault(A.get(j),0)+1);
            if(j-i+1==B){
                result.add(map.size());
                // update the map 
                map.put(A.get(i),map.get(A.get(i))-1);
                if(map.get(A.get(i))==0){
                    map.remove(A.get(i));
                }
                // update the window
                i++;
            }
            // expand the window
            j++;
        }
        return result;
        
    }
}
