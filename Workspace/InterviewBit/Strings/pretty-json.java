public class Solution {
    public ArrayList<String> prettyJSON(String A) {
        ArrayList<String> result=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        // each stack element tells us how much we need to indent the current line
        stack.push(0);
        int i=0;
        while(i<A.length()){
            char cc=A.charAt(i);
            if(cc==' '){
                i++;
                continue;
            }
            StringBuilder sb=new StringBuilder();
            // modify stack and push element on basis of current bracket
            if(cc=='{' || cc=='['){
                // add the spaces before start
                int space=stack.peek();
                while(space-->0){
                    sb.append("\t");
                }
                sb.append(cc);
                // since, we got an opening bracket, so we will indent more
                stack.push(stack.peek()+1);
                // continue traversing
                i++;
                if(i<A.length() && A.charAt(i)==','){
                    sb.append(",");
                    // continue traversing
                    i++;
                }
            }
            else if(cc=='}' || cc==']'){
                // since, we got a closing bracket, so we won't indent more, infact move to previous indentation
                stack.pop();
                // add the spaces before start
                int space=stack.peek();
                while(space-->0){
                    sb.append("\t");
                }
                sb.append(cc);
                // continue traversing
                i++;
                if(i<A.length() && A.charAt(i)==','){
                    sb.append(",");
                    // continue traversing
                    i++;
                }
            }
            else{
                // add the spaces before start
                int space=stack.peek();
                while(space-->0){
                    sb.append("\t");
                }
                // else it will be for normal strings   
                while(i<A.length() && A.charAt(i)!=',' && A.charAt(i)!='{' && A.charAt(i)!='[' && A.charAt(i)!='}' && A.charAt(i)!=']'){
                    sb.append(A.charAt(i++));   
                }
                if(i<A.length() && A.charAt(i)==','){
                    sb.append(",");
                    // move to the next element (string or numeric)
                    i++;
                }
                // rest in all cases, 'i' will be pointing at the next opening/closing bracket
            }
            result.add(sb.toString());
        }
        return result;
    }
}
