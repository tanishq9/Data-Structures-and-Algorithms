https://leetcode.com/problems/valid-parenthesis-string

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> remainingBrackets=new Stack<>();
        Stack<Integer> stars=new Stack<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char cc=arr[i];
            if(cc=='('){
                remainingBrackets.push(i);
            }else if(cc==')'){
                if(remainingBrackets.size()>0 && arr[remainingBrackets.peek()]=='('){
                    remainingBrackets.pop();
                }else{
                    remainingBrackets.push(i);
                }
            }else{
                stars.push(i);
            }
        }
        // insufficient brackets to balance
        if(remainingBrackets.size()>stars.size()){
            return false;
        }
        // check if the stars we have currently have can be used to balance the string
        while(stars.size()>0 && remainingBrackets.size()>0){
            int remainingBracketsPeek = remainingBrackets.peek();
            int starsPeek = stars.peek();
            if(arr[remainingBracketsPeek]=='('){
                if(starsPeek>remainingBracketsPeek){
                    // it means we can put a closing bracket there
                    stars.pop();
                    remainingBrackets.pop();
                }else{
                    // it means we can put nothing in front of this opening bracket to balance it
                    return false;
                }
            }else{
                if(starsPeek>remainingBracketsPeek){
                    // it means we will pop from stars stack and look for an index which is before )'s index
                    stars.pop();
                }else{
                    // we have got that index, now we will pop both
                    stars.pop();
                    remainingBrackets.pop();
                }
            }
        }
        // if the stars stack can be used to balance all remainingBrackets then only return true
        return remainingBrackets.size()==0;
    }
}