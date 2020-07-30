public class Solution {
    public int isPrime(int A) {
        if(A==1){
            return 0;
        }
        // prime number has 2 factors only which are 1 and the number itself
        // O(rootN) time complexity
        for(int i=2;i*i<=A;i++){
            if(A%i==0){
                return 0;
            }
        }
        return 1;
    }
}
