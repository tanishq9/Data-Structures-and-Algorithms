class Solution {
    public int firstUniqChar(String s) {
        int[] freq=new int[26];
        boolean[] unique=new boolean[26];
        Arrays.fill(unique,true);
        int[] index=new int[26];
        Arrays.fill(index,-1);
        for(int i=0;i<s.length();i++){
            char cc=s.charAt(i);
            freq[cc-'a']++;
            // if frequency is more than once then set unique to false
            if(freq[cc-'a']>1){
                unique[cc-'a']=false;
            }
            // update index if character is found for first time in string
            if(index[cc-'a']==-1){
                index[cc-'a']=i;
            }
        }
        int min=Integer.MAX_VALUE;
        // unique = true, then return index of that character
        for(int i=0;i<26;i++){
            // index[i]!=-1 implies character is present in string
            // freq[i]==1 implies character appears only once thus unique
            if(index[i]!=-1 && freq[i]==1){
                min=Math.min(min,index[i]);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
