class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atmostKDistinct(A,K)-atmostKDistinct(A,K-1);
    }
    public int atmostKDistinct(int[] A,int K){
        int start=0,end=0,count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(end<A.length){
            map.put(A[end],map.getOrDefault(A[end],0)+1);
            // shrink window as it is invalid now
            while(map.size()>K){
                map.put(A[start],map.get(A[start])-1);
                if(map.get(A[start])==0){
                    map.remove(A[start]);
                }
                start++;
            }
            // it is valid as it has K different numbers
            if(map.size()<=K){
                count+=(end-start+1);
            }
            // keep expanding
            end++;
        }
        return count;
    } 
    
}