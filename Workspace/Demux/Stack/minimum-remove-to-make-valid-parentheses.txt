class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);
            if(cc==')'){
                if(stack.size()>0 && s.charAt(stack.peek())=='('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }else if(cc=='('){
                stack.push(i);
            }
        }
        StringBuilder sb=new StringBuilder(s);
        while(stack.size()>0){
            int index = stack.pop();
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }
}