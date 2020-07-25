public class Solution {

    String[][] dict={{"0"},{"1"},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},
                    {"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};


    void helper(String A,int len,String temp,ArrayList<String> res){
        if(temp.length()==len){
            res.add(temp);
            return;
        }
        char cc=A.charAt(0);
        String ros=A.substring(1);
        for(int i=0;i<dict[cc-'0'].length;i++){
            helper(ros,len,temp+dict[cc-'0'][i],res);
        }
    }

    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> res=new ArrayList<>();
        helper(A,A.length(),"",res);
        return res;
    }
}
