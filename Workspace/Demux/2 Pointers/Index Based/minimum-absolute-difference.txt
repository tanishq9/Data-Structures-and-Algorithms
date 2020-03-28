class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        List<List<Integer>> result=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            minDiff=Math.min(minDiff,arr[i]-arr[i-1]);
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]+minDiff==arr[i+1]){
                result.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return result;
    }
}