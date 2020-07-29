public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int res=Integer.MAX_VALUE;
        for(int i=0;i<=A.size()-3;i++){
            int j=i+1;
            int k=A.size()-1;
            while(j<k){
                int sum=A.get(i)+A.get(j)+A.get(k);
                if(sum>target){
                    while(j<k && A.get(k)==A.get(k-1)){
                        k--;
                    }
                    k--;
                }else if(sum<target){
                    while(j<k && A.get(j)==A.get(j+1)){
                        j++;
                    }
                    j++;
                }else{
                    return target;
                }
            }
        }
        return res;
    }
}
