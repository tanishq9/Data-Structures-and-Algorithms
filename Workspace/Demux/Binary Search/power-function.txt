  public int pow(int x, int n, int d) {
        return (int)p((long)x,(long)n,(long)d);
    }
    public long p(long x,long n,long d){
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return (x%d+d)%d;
        }
        long temp=p(x,n/2,d);
        temp=(temp%d+d)%d;
        temp=(temp*temp)%d;
        if(n%2==0){
            return (temp)%d;
        }else{
            return (((x%d+d)%d)*temp)%d;
        }
    }