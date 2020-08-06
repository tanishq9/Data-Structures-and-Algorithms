class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        if(str.length()==0){
            return 0;
        }
        int sign=1;
        if(str.charAt(0)=='-'){
            sign=-1;
            str=str.substring(1);
        }else if(str.charAt(0)=='+'){
            str=str.substring(1);
        }
        int i=0;
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