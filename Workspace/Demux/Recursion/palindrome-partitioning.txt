class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        f(s,0,new ArrayList<>(),res);
        return res;
    }
    
    // take U Forward suffix array approach
    // for loop mei se recursive calls
    void f(String s,int start,List<String> temp,List<List<String>> res){
        if(start==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(!ispalin(s,start,i)){
                continue;
            }
            temp.add(s.substring(start,i+1));
            f(s,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
    
    boolean ispalin(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    
}