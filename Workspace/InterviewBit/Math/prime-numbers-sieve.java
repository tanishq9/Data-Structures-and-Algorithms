public class Solution {
    // FACT : 0 and 1 are not prime
    public ArrayList<Integer> sieve(int A) {
        boolean[] primes=new boolean[A+1];
        for(int i=3;i<=A;i+=2){
            primes[i]=true;
        }
        primes[2]=true;
        // running the loop for rootN times because if a number has to be struck 
        // it will be struck before rootN, same approach for all prime number questions
        for(int i=3;i*i<=A;i+=2){
            if(primes[i]==true){
                // strike all multiples of this number
                // loop can also start from i*i
                for(int j=2*i;j<=A;j+=i){
                    primes[j]=false;
                }    
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=2;i<=A;i++){
            if(primes[i]==true){
                res.add(i);
            }
        }
        return res;
    }
}
