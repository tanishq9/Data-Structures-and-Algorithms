public class Solution {
    public int longestValidParentheses(String A) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        stack.push(-1);
        for(int i=0;i<A.length();i++){
            char cc=A.charAt(i);
            if(cc=='('){
                stack.push(i); 
            }else{
                if(stack.size()>0 && stack.peek()>=0 && A.charAt(stack.peek())=='('){
                    stack.pop();
                    max=Math.max(max,i-stack.peek());
                }else{
                    stack.push(i);
                }
            }
        }
        return max;
    }
}
