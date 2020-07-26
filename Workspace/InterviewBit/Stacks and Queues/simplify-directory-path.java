public class Solution {
    public String simplifyPath(String A) {
        // single dot : ignore
        // double dot : pop
        // / : continue
        Stack<String> stack=new Stack<>();
        int i=0;
        while(i<A.length()){
            char cc=A.charAt(i);
            if(cc=='/'){
                i++;
                continue;
            }else if(cc=='.'){
                int dotCount=1;
                i++;
                // check for further dots
                while(i<=A.length()-1 && A.charAt(i)=='.'){
                    dotCount++;
                    i++;
                }
                if(dotCount==2){
                    if(stack.size()>0){
                        stack.pop();
                    }
                }else if(dotCount==1 || dotCount>2){
                    // do nothing
                }
                continue;
            }else{
                String str="";
                while(i<A.length() && A.charAt(i)!='.' && A.charAt(i)!='/'){
                    str+=A.charAt(i++);
                }
                stack.push(str);
                continue;
            }
        }
        ArrayList<String> temp=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        while(stack.size()>0){
            temp.add(stack.pop());
        }
        Collections.reverse(temp);
        for(String str:temp){
            sb.append("/"+str);
        }
        if(sb.length()==0){
            return "/";
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }
}
