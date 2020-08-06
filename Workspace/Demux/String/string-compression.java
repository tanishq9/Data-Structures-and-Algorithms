class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        StringBuilder sb=new StringBuilder();
        int i=0,j=0;
        while(j<chars.length){
            char cc=chars[i];
            int count=1;
            j++;
            while(j<chars.length && chars[j]==cc){
                j++;
                count++;
            }
            if(count==1){
                sb.append(cc);
            }else{
                sb.append(cc+""+count);                
            }
            i=j;
        }
        for(i=0;i<sb.length();i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}