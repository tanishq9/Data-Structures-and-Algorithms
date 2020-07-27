public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        int n=A.size();
        boolean[] start=new boolean[n];
        HashSet<Integer> set=new HashSet<>();
        for(int e:A){
            set.add(e);
        }
        for(int i=0;i<n;i++){
            if(!set.contains(A.get(i)-1)){
                start[i]=true;
            }
        }
        int max=1;
        for(int i=0;i<n;i++){
            if(start[i]){
                int len=1;
                int val=A.get(i);
                while(set.contains(val+1)){
                    len++;
                    val+=1;
                }
                max=Math.max(max,len);
            }
        }
        return max;
    }
}
