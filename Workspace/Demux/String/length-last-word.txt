public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        int len=0;
        char[] arr=A.toCharArray();
        for(int i=0;i<arr.length;i++){
            char cc=arr[i];
            if(cc!=' '){
                len++;
            }else{
                while(i<arr.length && arr[i]==' '){
                    i++;
                }
                if(i==arr.length){
                    return len;
                }
                i--;
                len=0;
            }
        }
        return len;
    }
}
