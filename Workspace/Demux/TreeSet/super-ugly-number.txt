class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> set=new TreeSet<>();
        set.add((long)1);
        int count=0;
        while(count<=n){
            long el=set.pollFirst();
            count++;
            if(count==n){
                return (int)el;
            }
            for(long p:primes){
                p*=el;
                if(!set.contains(p)){
                    set.add(p);   
                }
            }
                
        }
        return -1;
    }
}