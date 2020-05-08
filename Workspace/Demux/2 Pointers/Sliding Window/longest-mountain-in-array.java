class Solution {
    public int longestMountain(int[] A) {
        int start=0,end=0,max=0;
        while(end<A.length){
            int val=A[end];
            // skip equal values
            while((end+1)<A.length && A[end]==A[end+1]){
                start++;
                end++;
            }
            // uphill
            boolean uphill=false;
            while((end+1)<A.length && A[end]<A[end+1]){
                uphill=true;
                end++;
            }
            // downhill
            boolean downhill=false;
            while((end+1)<A.length && A[end]>A[end+1]){
                downhill=true;
                end++;
            }
            if(uphill==true && downhill==true){
                max=Math.max(max,end-start+1);
            }
            // check for more mountains
            start=end;
            // check if at last element
            if(end==A.length-1){
                break;
            }
        }
        return max;
    }
}