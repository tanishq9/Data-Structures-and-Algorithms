public class Solution {
    public int solve(String[] A) {
        int i=0;
        Arrays.sort(A);
        int j=A.length-1;
        while(j-i>=2){
            int mid=(i+j)/2;
            Double d1=Double.valueOf(A[i]);
            Double d2=Double.valueOf(A[j]);
            Double d3=Double.valueOf(A[mid]);
            if(d1+d2+d3>2){
                j--;
            }else if(d1+d2+d3<1){
                i++;
            }else{
                return 1;
            }
        }
        return 0;
    }
}
