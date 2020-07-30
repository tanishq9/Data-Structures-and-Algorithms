public class Solution {
    public int gcd(int A, int B) {
        return B==0?A:gcd(B,A%B);
    }
}
