public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        int current=1;
        for(int i=0;i<A.length();i++){
            char cc=A.charAt(i);
            if(cc=='D'){
                stack.push(current);
                current+=1;
            }else{
                stack.push(current);
                current+=1;
                while(stack.size()>0){
                    res.add(stack.pop());
                }
            }
        }
        stack.push(B);
        while(stack.size()>0){
            res.add(stack.pop());
        }
        return res;
    }
}
