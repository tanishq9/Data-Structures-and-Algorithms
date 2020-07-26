public class Solution {
    public int solve(String A) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<A.length();i++){
            char cc=A.charAt(i);
            if(cc=='('){
                st.push(cc);
            }else{
                if(st.size()>0 && st.peek()=='('){
                    st.pop();
                }else{
                    return 0;
                }
            }
        }
        return st.size()>0?0:1;
    }
}
