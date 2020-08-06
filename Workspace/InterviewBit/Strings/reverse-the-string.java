public class Solution {
    public String solve(String A) {
        ArrayList<String> list=new ArrayList<>();
        int i=0;
        while(i<A.length()){
            StringBuilder temp=new StringBuilder();
            while(i<A.length() && A.charAt(i)!=' '){
                temp.append(A.charAt(i));
                i++;
            }
            list.add(temp.toString());
            // i is at a blank space now
            while(i<A.length() && A.charAt(i)==' '){
                i++;
            }
            // i is at a character now or maybe out of string!
        }
        StringBuilder result=new StringBuilder();
        for(i=list.size()-1;i>=0;i--){
            result.append(list.get(i)+" ");
        }
        return result.toString().trim();
    }
}
