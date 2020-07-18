class Solution {
    public int longestArithSeqLength(int[] A) {
        // this array of hashmap will be used to keep track of
        // common difference and its length ending at ith index
        HashMap<Integer,Integer>[] arr=new HashMap[A.length];
        for(int i=0;i<A.length;i++){
            arr[i]=new HashMap<>();
        }
        int max=0;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<=i-1;j++){
                int diff=A[i]-A[j];
                if(arr[j].containsKey(diff)){
                    // become part of that sequence
                    arr[i].put(diff,arr[j].get(diff)+1);
                }else{
                    arr[i].put(diff,2);
                }
                max=Math.max(max,arr[i].get(diff));
            }
            /*for(int key:arr[i].keySet()){
                System.out.println(key+" "+arr[i].get(key));
            }
            System.out.println();*/
        }
        return max;
    }
}