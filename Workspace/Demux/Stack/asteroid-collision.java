class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int ast:asteroids){
            if(ast>0){
                stack.push(ast);
            }else{
                while(stack.size()>0 && stack.peek()>=0 && ast<0 && stack.peek()<Math.abs(ast)){
                    stack.pop();
                }
                if(stack.size()==0 || stack.peek()<0){
                    stack.push(ast);
                }else if(stack.peek()+ast==0){
                    stack.pop();
                }
            }
        }
        int[] res=new int[stack.size()];
        int index=stack.size()-1;
        while(stack.size()>0){
            res[index--]=stack.pop();
        }
        return res;
    }
}