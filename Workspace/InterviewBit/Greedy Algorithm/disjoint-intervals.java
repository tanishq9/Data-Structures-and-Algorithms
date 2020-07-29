public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<int[]> list=new ArrayList<>();
        // build the list
        for(ArrayList<Integer> e:A){
            list.add(new int[]{e.get(0),e.get(1)});
        }
        // sort on basis of start point
        Collections.sort(list,new Comparator<int[]>(){
           public int compare(int[] one,int[] two){
               return one[0]-two[0];
           } 
        });
        Stack<int[]> stack=new Stack<>();
        stack.push(list.get(0));
        for(int i=1;i<list.size();i++){
            int[] peek=stack.peek();
            int ps=peek[0];
            int pe=peek[1];
            // System.out.println(ps+" "+pe);
            int cs=list.get(i)[0];
            int ce=list.get(i)[1];
            if(ps<=cs && ce<=pe){
                // complete overlap
                stack.pop();
                stack.push(new int[]{cs,ce});
            }else if(pe==cs){
                // partial overlap
                continue;
            }else if(cs>pe){
                // insert new
                stack.push(new int[]{cs,ce});                
            }
        }
        return stack.size();
    }
}
