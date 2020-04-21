class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack=new Stack<>();
        String s1=getModifiedString(stack,S); 
        String s2=getModifiedString(stack,T);
        return s1.equals(s2);
    }
    String getModifiedString(Stack<Character> stack, String input){
        for(int i=0;i<input.length();i++){
            char cc=input.charAt(i);
            if(cc=='#'){
                if(stack.size()>0){
                    stack.pop();
                }
            }else{
                stack.push(cc);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(stack.size()>0){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}