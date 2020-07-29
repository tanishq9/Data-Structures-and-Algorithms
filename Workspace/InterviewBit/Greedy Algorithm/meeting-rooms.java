public class Solution {
    // solve both start and end time -> same logic for min platforms
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int[] start=new int[A.size()];
        int[] end=new int[A.size()];
        int index=0;
        for(ArrayList<Integer> e:A){
            start[index]=e.get(0);
            end[index]=e.get(1);
            index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        // we will maintain a counter to keep track of number of rooms needed at a point of time
        // we will check that if a meeting has started before ending the previous meeting
        int rooms=0,max=0;
        int i=0,j=0; 
        while(i<start.length && j<end.length){
            if(start[i]<end[j]){
                // then room needed 
                rooms++;
                i++;
                max=Math.max(max,rooms);
            }else{
                rooms--;
                j++;
            }
        }
        return max;
    }
}
