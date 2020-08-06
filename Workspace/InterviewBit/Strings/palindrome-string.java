public class Solution {
    public int isPalindrome(String A) {
        StringBuilder sb=new StringBuilder();
        for(char cc:A.toCharArray()){
            int index=(int)cc;
            if(index>=65 && index<=90){
                sb.append((char)(index+32));
            }else if(index>=97 && index<=122){
                sb.append(cc);
            }else if(index>=48 && index<=57){
                sb.append(cc);
            }
        }
        // System.out.println(sb.toString());
        int i=0,j=sb.length()-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }
}
