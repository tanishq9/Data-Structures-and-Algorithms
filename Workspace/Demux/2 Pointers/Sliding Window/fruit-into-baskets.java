class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int start=0,end=0,max=0;
        while(end<tree.length){
            // acquire the current 'type' of fruit
            map.put(tree[end],map.getOrDefault(tree[end],0)+1);
            // make the 'Invalid' window as 'Valid' again
            while(map.size()>2){
                map.put(tree[start],map.get(tree[start])-1);
                if(map.get(tree[start])==0){
                    map.remove(tree[start]);
                }
                start++;
                // 1 1 3 1 3 1 2 2 2 ...
            }
            // consider the valid window
            max=Math.max(max,end-start+1);
            // expand the window further
            end++;
        }
        return max;
    }
}