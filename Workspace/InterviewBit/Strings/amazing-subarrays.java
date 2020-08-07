public class Solution {
    public int solve(String A) {
        int n=A.length();
        int count=0,mod=10003;
        // summation of all (n-position of vowels)
        for(int index=0;index<n;index++){
            char cc=A.charAt(index);
            if(cc=='a' || cc=='A' || cc=='e' || cc=='E' || cc=='i' || cc=='I'
                    || cc=='o' || cc=='O' || cc=='u'|| cc=='U'){
                count=(count%mod+(n-index)%mod)%mod;            
            }
        }
        return count%mod;
    }
}
