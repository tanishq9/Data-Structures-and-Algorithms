class Solution {
    
    // gcd(a,b) = gcd(|a|,|b|)
    int g(int n1,int n2){
        return n2==0?n1:g(n2,n1%n2);
    }
    
    public boolean checkStraightLine(int[][] coordinates) {
        int prevX=coordinates[0][0];
        int prevY=coordinates[0][1];
        int diffX=0,diffY=0;
        for(int i=2;i<coordinates.length;i++){
            int[] curr=coordinates[i];
            int dx=prevX-curr[0];
            int dy=prevY-curr[1];
            int gcd=g(dx,dy);
            dx/=gcd;
            dy/=gcd;
            if(diffX==0 && diffY==0){
                diffX=dx;
                diffY=dy;
            }
            if(diffX!=dx || diffY!=dy){
                return false;
            }
        }
        return true;
    }
    
}