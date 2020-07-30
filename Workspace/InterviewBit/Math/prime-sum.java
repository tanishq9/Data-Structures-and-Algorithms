public class Solution {
    public ArrayList<Integer> primesum(int A) {
        boolean[] primes=new boolean[A];
        ArrayList<Integer> nums=new ArrayList<>();
        for(int i=3;i<A;i+=2){
            primes[i]=true;
        }
        nums.add(2);
        for(int i=3;i<A;i+=2){
            if(primes[i]==true){
                for(int j=2*i;j<A;j+=i){
                    primes[j]=false;
                }
            }
            if(primes[i]==true){
                nums.add(i);
            }
        }
        // System.out.println(nums);
        // find the pair using binary search
        for(int i=0;i<nums.size();i++){
            int other=find(nums,A-nums.get(i));
            if(other!=Integer.MAX_VALUE){
                ArrayList<Integer> res=new ArrayList<>();
                res.add(nums.get(i));
                res.add(other);
                return res;
            }
        }
        return null;
    }
    
    int find(ArrayList<Integer> nums,int num){
        int lo=0,mid=0,hi=nums.size()-1;
        // a[x]>=num 1 9  -9
        // f f f t t t t : first true
        while(lo<hi){
            mid=lo+(hi-lo)/2;
            if(nums.get(mid)>=num){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if(lo>=0 && lo<nums.size() && nums.get(lo)==num){
            return nums.get(lo);
        }
        return Integer.MAX_VALUE;
    }
    
}
