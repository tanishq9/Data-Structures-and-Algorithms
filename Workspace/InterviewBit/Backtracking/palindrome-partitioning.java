public class Solution {
    
    static HashSet<ArrayList<String>> set = new HashSet<>();

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        helper(a,0,new ArrayList<>(),res);
        return res;
    }

    void helper(String a, int start,ArrayList<String> temp,ArrayList<ArrayList<String>> res) {
        if(start==a.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=start;i<a.length();i++){
            // we find the correct i to put the first cut
            if(!isPalindrome(a,start,i)){
                continue;
            }
            temp.add(a.substring(start,i+1));
            helper(a,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
        
    }

    boolean isPalindrome(String str, int si, int ei) {
        int lo = si, hi = ei;
        while (lo < hi) {
            if (str.charAt(lo) != str.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}