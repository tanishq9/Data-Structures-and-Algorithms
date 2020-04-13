class Solution {
    public String simplifyPath(String path) {
        // use stack, simply push the string to the stack
        // if you get '..' then pop thr peek element from stack
        // if stack is empty and we get .., then do nothing as root is the last directory name
        // so we cant go one level above it
        
        Stack<String> stack=new Stack<>();
        char[] arr=path.toCharArray();
        StringBuilder sb=new StringBuilder();
        int i=0; // only 1 pointer for traversal of the array
        while(i<arr.length){
            while(i<arr.length && arr[i]=='/'){
                i++;
            }
            if(i==arr.length){
                break;
            }
            // to push the string
            sb=new StringBuilder();
            while(i<arr.length && arr[i]!='/'){
                sb.append(arr[i++]);
            }
            if(sb.toString().equals("..")){
                if(stack.size()>0){
                    stack.pop();
                }
            }else if(sb.toString().equals(".")){
                continue;
            }else{
                stack.push(sb.toString());
            }
        } 
        ArrayList<String> list=new ArrayList<>();
        while(stack.size()>0){
            list.add(stack.pop());
        }
        sb=new StringBuilder("/");
        for(i=list.size()-1;i>=0;i--){
            sb.append(list.get(i)+"/");
        }
        if(sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}