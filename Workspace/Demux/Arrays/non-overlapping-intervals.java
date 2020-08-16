class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // to choose an interval compare it with its previous valid interval
        // if start of both is same then skip current and continue 
        // if start of current is more than end of prev then consider it
        // to make sure the above logic works, we will sort on start point and then end point
        Arrays.sort(intervals,new Comparator<int[]>(){
           public int compare(int[] i1,int[] i2){
               if(i1[0]!=i2[0]){
                   return i1[0]-i2[0];
               }
               return i1[1]-i2[1];
           } 
        });
        // counting invalid intervals
        int index=1,count=0,v=0;
        while(index<intervals.length){
            // check for overlap with previous valid interval
            int cs=intervals[index][0];
            int ce=intervals[index][1];
            int vs=intervals[v][0];
            int ve=intervals[v][1];
            if(cs>=ve && cs!=vs){
                // current interval is the latest valid interval now
                v=index;
            }else{
                // there is an overlap
                // choose between current and previous valid interval
                if(ce<ve){
                    v=index;
                }
                count++;
            }
            index++;
        }
        return count;
    }
}