public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res=new StringBuilder();
        int i=a.length()-1,j=b.length()-1,ci=0,cj=0,carry=0;
        while(i>=0 || j>=0){
            if(i<0){
                ci=0;
            }else{
                ci=a.charAt(i--)-'0';
            }
            if(j<0){
                cj=0;
            }else{
                cj=b.charAt(j--)-'0';
            }
            int sum=ci+cj+carry;
            res.insert(0,sum%2+"");
            carry=sum/2;
        }
        if(carry==1){
            res.insert(0,"1");
        }
        return res.toString();
    }
}
