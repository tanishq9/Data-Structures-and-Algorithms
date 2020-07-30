public class Solution {
    public String convertToTitle(int a) {
        StringBuilder sb=new StringBuilder();
        // a is a number in excel formed using 3 chars namely, char1,char2 and char3
        // we need to add 1 to each char as the indexing is from 0 to 25 for char
        // this is how we will obtain the column number, we will use similar approach to get column title
        // a = (char1+1)*26^2 + (char2+1)*26^1 + (char3+1)*26^0   ----> For example
        // subtract 1 from both sides
        // a-1 = (char1+1)*26^2 + (char2+1)*26^1 + char3 
        // (a-1)%26 = char3
        // a/26 = (char1+1)*26^1 + (char2+1)*26^0
        // Again, (a-1)%26 = char2 and (a-1)/26 = (char1+1)*26^0
        // Finally, (a-1)%26 = char3 and therefore we have got the answer as : char1,char2,char3
        // So, we have to subtract 1 for getting the last character and also to get the remaining number
        
        while(a>0){
            sb.append((char)(65+(a-1)%26));
            a=(a-1)/26;
        }
        return sb.reverse().toString();
    }
}
