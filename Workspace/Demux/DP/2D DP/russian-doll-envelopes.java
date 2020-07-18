class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] e1,int[] e2){
                if(e1[0]!=e2[0]){
                    return e1[0]-e2[0];
                }
                return e1[1]-e2[1];
            }
        });
        int[] lis=new int[envelopes.length];
        int max=0;
        for(int i=0;i<lis.length;i++){
            lis[i]=1;
            for(int j=i-1;j>=0;j--){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]
                        && lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                }
            }
            max=Math.max(max,lis[i]);
        }
        return max;
    }
}

/*

w,h
5,4 6,4 6,7 2,3 
// sort accn to width and height
2,3 5,4 6,4 6,7 
// find lis for both width,height

*/