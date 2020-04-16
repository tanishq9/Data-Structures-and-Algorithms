class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length())        
            return "0";
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
           while(stack.size()>0 && k>0 && stack.peek()>num.charAt(i)){
               stack.pop();
               k--;
           }
            stack.push(num.charAt(i));
        }
        while(k-->0){
            stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(stack.size()>0){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}