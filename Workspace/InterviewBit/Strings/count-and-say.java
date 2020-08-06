public class Solution {
    public String countAndSay(int A) {
        int n=1;
        StringBuilder sb=new StringBuilder("1");
        while(n!=A){
            String temp=sb.toString();
            sb.setLength(0);
            
            int j=0;
            while(j<temp.length()){
                char cc=temp.charAt(j);
                j++;
                int count=1;
                while(j<temp.length() && temp.charAt(j)==cc){
                    count++;
                    j++;
                }
                sb.append(count+""+cc);
            }
            
            n++;
        }
        return sb.toString();
    }
}
