public class Solution {
 
    public int solve(ArrayList<Integer> A, int B) {
        return atMostK(A,B)-atMostK(A,B-1);
    }
 
    int atMostK(ArrayList<Integer> A,int K){
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0,count=0;
        while(j<A.size()){
            map.put(A.get(j),map.getOrDefault(A.get(j),0)+1);
            while(map.size()>K){
                map.put(A.get(i),map.get(A.get(i))-1);
                if(map.get(A.get(i))==0){
                    map.remove(A.get(i));
                }
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    
}