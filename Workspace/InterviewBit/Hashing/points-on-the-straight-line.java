public class Solution {
    int gcd(int num1,int num2){
        return num2==0?num1:gcd(num2,num1%num2);   
    }
    
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int[][] points=new int[a.size()][a.size()];
        if(points.length==0){
            return 0;
        }
        for(int i=0;i<points.length;i++){
            points[i][0]=a.get(i);
            points[i][1]=b.get(i);
        }
        int max=0;
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
                int f=gcd(dx,dy);    
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
