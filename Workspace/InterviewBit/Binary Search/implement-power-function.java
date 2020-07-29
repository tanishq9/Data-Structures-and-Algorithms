public class Solution {
    public int pow(int x, int n, int d) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return (x%d+d)%d;
        }
        long temp=pow(x,n/2,d);
        temp=(temp%d+d)%d;
        temp=(temp*temp)%d;
        if(n%2==0){
            return (int)(temp)%d;
        }else{
            return (int)(((x%d+d)%d)*temp)%d;
        }
    }
}
