public class Solution {
    public String solve(String A, int B) {
        int j=0;
        StringBuilder sb=new StringBuilder();
        while(j<A.length()){
            char cc=A.charAt(j);
            j++;
            int count=1;
            String temp=cc+"";
            // check for consecutive characters
            while(j<A.length() && A.charAt(j)==cc){
                j++;
                count++;
                temp+=cc;
            }
            if(count>B || count<B){
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}
