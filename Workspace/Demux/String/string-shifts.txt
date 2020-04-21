class Solution {
    public String stringShift(String s, int[][] shift) {
        int totalShift=0;
        for(int[] change:shift){
            int dir=change[0];
            int magnitude=change[1];
            if(dir==0){
                totalShift-=magnitude;
            }else{
                totalShift+=magnitude;
            }
        }
        int n=s.length();
        char[] res=new char[n];
        for(int i=0;i<n;i++){
            int mappedIndex=((i+totalShift)%n+n)%n;
            res[mappedIndex]=s.charAt(i);
        }
        return String.valueOf(res);
    }
}