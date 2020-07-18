class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            char cc=s.charAt(i);
            if(cc=='('){
                stack.push(i);
            }else if(cc==')'){
                if(stack.size()>0 && s.charAt(stack.peek())=='('){
                    stack.pop();
                    if(stack.size()>0){
                        max=Math.max(max,i-stack.peek());                        
                    }else{
                        max=Math.max(max,i+1);
                    }
                }else{
                    stack.push(i);
                }
            }
        }
        return max;
    }
}