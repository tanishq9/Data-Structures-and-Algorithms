class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] interval:intervals){
            list.add(interval);
        }
        list.add(newInterval);
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] i1,int[] i2){
                return i1[0]-i2[0];
            }
        });
        int previousStart=list.get(0)[0];
        int previousEnd=list.get(0)[1];
        ArrayList<int[]> res = new ArrayList<>();
        for(int i=1;i<list.size();i++){
            int currentStart=list.get(i)[0];
            int currentEnd=list.get(i)[1];
            if(currentStart<=previousEnd){
                // merge
                previousEnd=Math.max(previousEnd,currentEnd);
            }else{
                res.add(new int[]{previousStart,previousEnd});
                previousStart=currentStart;
                previousEnd=currentEnd;
            }
        }
        // add the last interval
        res.add(new int[]{previousStart,previousEnd});
        
        int index=0;
        int[][] output = new int[res.size()][2];
        for(int[] interval:res){
            output[index][0]=interval[0];
            output[index][1]=interval[1];
            index++;
        }
        return output;
    }
}