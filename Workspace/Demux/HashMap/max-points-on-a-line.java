class Solution {
    public int gcd(int num1,int num2){
        return num2==0?num1:gcd(num2,num1%num2);   
    }
    public int maxPoints(int[][] points) {
        if(points.length==0){
            return 0;
        }
        int max=1;
        HashMap<String,Integer> map=new HashMap<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            int local=1;
            int duplicate=0;
            for(int j=i+1;j<n;j++){ 
                int dx=points[i][0]-points[j][0];
                int dy=points[i][1]-points[j][1];
                if(dx==0 && dy==0){
                    duplicate++;
                    continue;
                }
                // construct the string
                int f=gcd(dx,dy);    
                // so that 4,6 is normalized to 2,3 i.e most reduced form
                // example : 1,1 is ith point and 2,2 & 3,3 are jth points and
                // they all lie on the same line but
                // their dx,dy pair for then will be 1,1 and 2,2 
                // so we need to normalize 2,2 by finding its gcd which is 2
                // and then dx,dy will now be 1,1 for the pair 2,2
                dx/=f;dy/=f;
                String key=dy+"/"+dx;
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }else{
                    map.put(key,2);
                }
                local=Math.max(local,map.get(key));
            }
            max=Math.max(max,local+duplicate);
            map.clear();
        }
        return max;
    }
}