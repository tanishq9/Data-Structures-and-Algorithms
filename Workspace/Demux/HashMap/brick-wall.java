https://leetcode.com/problems/brick-wall/submissions/

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // map : x coordinate of the wall and how many times we can cross through it
        // the more number of times we can cross through the x-coordinate, the lesser
        // number of times we will hit the brick
        HashMap<Integer,Integer> map=new HashMap<>();
        int xr=0;
        // find the right boundary
        for(int i=0;i<wall.get(0).size();i++){xr+=wall.get(0).get(i);}
        for(List<Integer> list:wall){
            int x=0;
            for(int i=0;i<list.size();i++){
                x+=list.get(i);
                map.put(x,map.getOrDefault(x,0)+1);
            }
        }
        int min=wall.size();
        for(int key:map.keySet()){
            if(key!=xr){
                int xCrossed = map.get(key);
                int xHit = wall.size()-xCrossed;
                min=Math.min(min,xHit);   
            }
        }
        return min;
    }
}