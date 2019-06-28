package Array;

public class plusOne {
	public int[] plus1(int[] digits) {
        int carry=0;
        for(int i=digits.length-1;i>=0;i--){
            int new_digit=digits[i]+carry+(i==digits.length-1?1:0);
            digits[i]=new_digit%10;
            carry=new_digit/10;
            if(carry==0){
                break;
            }
        } 
        if(carry!=0){
            int[] nn=new int[digits.length+1];
            nn[0]=carry;
            return nn;
        }
        
        return digits;
    }
}
