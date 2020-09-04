class Solution {
    public int maxVowels(String s, int k) {
        int i=0,j=0,max=0,count=0;
        while(j<s.length()){
            char cc=s.charAt(j);
            if(cc=='a' || cc=='e' || cc=='i' || cc=='o' || cc=='u'){
                count++;
            }
            if(j-i+1==k){
                max=Math.max(max,count);
                cc=s.charAt(i);
                if(cc=='a' || cc=='e' || cc=='i' || cc=='o' || cc=='u'){
                    count--;
                }
                i++;
            }
            j++;
        }
        return max;
    }

}