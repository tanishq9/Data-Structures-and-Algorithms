public class Solution {
    public int braces(String A) {
        // given A is a balanced parenthesis
        Stack<Character> stack=new Stack<>();
        int op=0,p=0;
        for(int i=0;i<A.length();i++){
            char cc=A.charAt(i);
            if(cc=='(' || cc=='+' || cc=='-' || cc=='*' || cc=='/'){
                stack.push(cc);
            }else if(cc==')'){
                if(stack.size()>0 && stack.peek()=='('){
                    // no expression between these 2 braces, therefore redundant
                    return 1;
                }else if(stack.size()>0 && stack.peek()!='('){
                    // else we remove this valid brace expression
                    while(stack.size()>0 && stack.peek()!='('){
                        stack.pop();
                    }
                    // now pop the closing brace
                    stack.pop();
                }
            }
        }
        return 0; 
    }
}
