public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> res=new ArrayList<String>();
        helper(0,0,A,new StringBuilder(),res);
        return res;
    }
    
    void helper(int op,int cl,int n,StringBuilder sb,ArrayList<String> res){
        if(op==cl && op==n){
            res.add(new String(sb.toString()));
            return;
        }
        if(op<n){
            sb.append("(");
            helper(op+1,cl,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(op>cl){
            sb.append(")");
            helper(op,cl+1,n,sb,res);
            sb.deleteCharAt(sb.length()-1);            
        }
    }
    
}
