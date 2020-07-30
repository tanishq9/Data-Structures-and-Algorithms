public class Solution {
    public String findDigitsInBinary(int A) {
        if(A==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        while(A>0){
            sb.append(A%2);
            A=A/2;
        }
        return sb.reverse().toString();
    }
}
