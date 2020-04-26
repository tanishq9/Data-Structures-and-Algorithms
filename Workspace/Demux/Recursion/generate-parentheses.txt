https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        f(n,0,0,new StringBuilder(),res);
        return res;
    }
    void f(int n,int op,int cl,StringBuilder sb,List<String> res){
        if(op==cl && op==n){
            // deep copy
            res.add(sb.toString());
            return;
        }
        if(op<n){
            sb.append("(");
            op+=1;
            f(n,op,cl,sb,res);
            op-=1;
            sb.deleteCharAt(sb.length()-1);
        }
        if(cl<op){
            sb.append(")");
            cl+=1;
            f(n,op,cl,sb,res);
            cl-=1;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}