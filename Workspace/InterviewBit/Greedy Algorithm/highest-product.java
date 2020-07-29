public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        Collections.sort(A);
        int n=A.size();
        int p1=A.get(0)*A.get(1)*A.get(n-1); // 2 most -ve and 1 most +ve
        int p2=A.get(n-3)*A.get(n-2)*A.get(n-1); // 3 most +ve
        return Math.max(p1,p2);
    }
}
