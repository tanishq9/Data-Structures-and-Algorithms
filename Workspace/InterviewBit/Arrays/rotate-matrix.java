public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n=a.size();
        // 1. Do Transpose
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
            }
        }
        // 2. Swap columns from left to right
        int i=0,j=n-1;
        while(i<j){
            for(int k=0;k<n;k++){
                int temp=a.get(k).get(i);
                a.get(k).set(i,a.get(k).get(j));
                a.get(k).set(j,temp);
            }
            i++;
            j--;
        }
    }
}
