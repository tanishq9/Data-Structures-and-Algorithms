public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String str) {
        int index=0;
        while(index<str.length() && str.charAt(index)==0){
            index++;
        }
        // if all spaces are left then return 0
        if(str.length()==0){
            return 0;
        }
        int sign=1,i=0;
        if(str.charAt(0)=='-'){
            sign=-1;
            // setting i=1 so that we can skip this sign character
            i=1;
        }else if(str.charAt(0)=='+'){
            i=1;
        }
        long num=0;
        while(i<str.length()){
            // if we encounter space then break
            if(str.charAt(i)==' '){
                break;
            }
            int ascii=str.charAt(i)-'0';
            // only considering digits, if not then break from loop
            if(ascii>=0 && ascii<=9){
                num=num*10+ascii;
                // if the long number is execeeding INT range then return that INT bound
                // multiply by sign to get the original number
                num*=sign;
                if(num>=Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(num<=Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                // revert to only positive number, why ? consider -44, if we consider -ve sign then that will interfere with num=num*10+ascii, that is why we are only concerned about the absolute value
                num*=sign;
            }else{
                break; 
            }
            i++;
        }
        num*=sign;
        return (int)num;
    }
}
