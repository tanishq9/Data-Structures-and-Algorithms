public class Solution {
    public int solve(ArrayList<Integer> A) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer,int[]> map=new HashMap<>();
        // arr[0] for frequency and arr[1] for first occurance
        for(int i=0;i<A.size();i++){
            map.putIfAbsent(A.get(i),new int[]{0,i});
            int[] arr=map.get(A.get(i));
            arr[0]++;
            if(arr[0]>1){
                min=Math.min(min,arr[1]);
            }
            map.put(A.get(i),arr);
            // System.out.println(A.get(i)+" "+map.get(A.get(i))[0]+" "+map.get(A.get(i))[1]);
        }
        return min!=Integer.MAX_VALUE?A.get(min):-1;
    }
}
