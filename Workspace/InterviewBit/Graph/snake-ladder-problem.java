public class Solution {
    public int snakeLadder(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer,Integer> ladderMap=new HashMap<>();
        HashMap<Integer,Integer> snakeMap=new HashMap<>();
        for(ArrayList<Integer> e:A){
            ladderMap.put(e.get(0),e.get(1));
        }
        for(ArrayList<Integer> e:B){
            snakeMap.put(e.get(0),e.get(1));
        }
        LinkedList<int[]> q=new LinkedList<>();
        boolean[] vis=new boolean[101];
        q.add(new int[]{1,0});
        while(q.size()>0){
            int[] fr=q.remove();
            int cell=fr[0];
            int steps=fr[1];
            if(vis[cell]){
                continue;
            }
            vis[cell]=true;
            if(cell==100){
                return steps;
            }
            for(int move=1;move<=6;move++){
                int newCell=cell+move;
                if(newCell>100){
                    continue;
                }
                if(!vis[newCell]){
                    if(ladderMap.containsKey(newCell)){
                        newCell=ladderMap.get(newCell);
                    }else if(snakeMap.containsKey(newCell)){
                        newCell=snakeMap.get(newCell);
                    }
                    q.addLast(new int[]{newCell,steps+1});
                }
            }
        }
        return -1;
    }
}
