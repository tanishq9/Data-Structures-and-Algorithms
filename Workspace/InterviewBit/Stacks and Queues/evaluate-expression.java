public class Solution {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack=new Stack<>();
        for(String str:A){
            if(str.equals("+")){
                int op1=stack.pop();
                int op2=stack.pop();
                stack.push(op2+op1);
            }else if(str.equals("-")){
                int op1=stack.pop();
                int op2=stack.pop();
                stack.push(op2-op1);
            }else if(str.equals("*")){
                int op1=stack.pop();
                int op2=stack.pop();
                stack.push(op2*op1);
            }else if(str.equals("/")){
                int op1=stack.pop();
                int op2=stack.pop();
                stack.push(op2/op1);
            }else{
                int val=Integer.valueOf(str);
                stack.push(val);
            }
        }
        return stack.peek();
    }
}
