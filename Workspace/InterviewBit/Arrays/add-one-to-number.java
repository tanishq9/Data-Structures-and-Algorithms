public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n=A.size(),i=n-1,sum=0,carry=0;
        ArrayList<Integer> res=new ArrayList<Integer>();
        while(i>=0){
            int cd=A.get(i);
            sum=cd+carry;
            if(i==n-1){
                sum+=1;
            }
            res.add(sum%10);
            // carry for the next digit
            carry=sum/10;
            i--;
        }
        if(carry>=1){
            res.add(carry);
        }
        Collections.reverse(res);
        i=0;
        while(i<res.size() && res.get(0)==0){
            res.remove(0);
            i++;
        }
        return res;
    }
}
