public class Solution {
     public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int distance = 0;
        for (int i = 1; i < A.size(); i++) {
            int pointA = Math.abs(A.get(i) - A.get(i - 1));
            int pointB = Math.abs(B.get(i) - B.get(i - 1));
            distance += Math.max(pointA, pointB);
        }
        return distance;
    }
}
