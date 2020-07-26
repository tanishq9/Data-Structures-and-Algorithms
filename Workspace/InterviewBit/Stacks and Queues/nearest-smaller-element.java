public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        stack.push(A.get(0));
        res.add(-1);
        for(int i=1;i<A.size();i++){
            while(stack.size()>0 && stack.peek()>=A.get(i)){
                stack.pop();
            }    
            if(stack.size()>0){
                res.add(stack.peek());
            }else{
                res.add(-1);
            }
            stack.push(A.get(i));
        }
        return res;
    }
}
