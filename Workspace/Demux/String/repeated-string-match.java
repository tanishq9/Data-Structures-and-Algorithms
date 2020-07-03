class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb=new StringBuilder(A);
        int count=1;
        while(sb.length()<B.length()){
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)){
            return count;
        }
        sb.append(A);
        return sb.toString().contains(B)?count+1:-1;
    }
}