https://leetcode.com/problems/prison-cells-after-n-days

https://drive.google.com/file/d/1jl_Ex9ko_u5qkWaFSg09qa_9Ih_HhpT0/view?usp=sharing

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] temp=new int[cells.length];
        String present="";
        for(int i=0;i<8;i++){
            temp[i]=cells[i];
            present+=cells[i]+"";
        }

        HashMap<String,Integer> map=new HashMap<>();
        map.put (present,0);
        int day=1;
        while(day<=N){       
            // deep copy of previous day cells
            for(int j=0;j<8;j++){
                temp[j]=cells[j];
            }
            // update cells
            for(int j=0;j<8;j++){
                if(j==0 || j==7){
                    cells[j]=0;
                }else{
                    if(temp[j-1]==temp[j+1]){
                        cells[j]=1;
                    }else{
                        cells[j]=0;
                    }
                }
            }
            // check in map
            present="";
            for(int j=0;j<8;j++){
                present+=cells[j]+"";
            }
            if(map.containsKey(present)){
                break; 
            }else{
                map.put(present,day);
            }
            day++;
        }
        
        if(day>N){
            return cells;
        }
        
        // There is a cycle
        // map.get(present) is the starting point of cycle
        // N is the total days
        // N - map.get(present) is the remaining number of days
        // and these remaining days form a cycle
        // So, if we have already traveled K days outside the cycle
        // then we have to traverse N-K days more inside the cycle
        // and since its a cycle, we will take its modulus with cycle length
        // the length of cycle is : day - map.get(present), here day is that
        // day where we have got a repeated state and we break from the loop
        // and map.get(present) is the first occurrance of the present day
        // i.e it is the start of the cycle, so we take mod of remaining days
        // i.e N-k inside the cycle with the length of cycle 
        int remainingSteps = N-map.get(present);
        int cycleLength = day-map.get(present);
        int offset = remainingSteps%cycleLength;
        for(int i=0;i<offset;i++){
            // deep copy of previous day cells
            for(int j=0;j<8;j++){
                temp[j]=cells[j];
            }
            // update cells
            for(int j=0;j<8;j++){
                if(j==0 || j==7){
                    cells[j]=0;
                }else{
                    if(temp[j-1]==temp[j+1]){
                        cells[j]=1;
                    }else{
                        cells[j]=0;
                    }
                }
            }
        }
        return cells;
    }
    
}