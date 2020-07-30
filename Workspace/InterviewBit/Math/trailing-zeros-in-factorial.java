public class Solution {
    // The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5.
    // If we can count the number of 5s and 2s, our task is done.
    // We can easily observe that the number of 2s in prime factors is always more than or equal to the number of 5s. 
    // So if we count 5s in prime factors, we are done. 
    // How to count total number of 5s in prime factors of n!? 
    // A simple way is to calculate floor(n/5)
    // For example, 7! has one 5, 10! has two 5s. 
    // It is not done yet, there is one more thing to consider. 
    // Numbers like 25, 125, etc have more than one 5. 
    // For example if we consider 28!, we get one extra 5 and number of 0s become 6. 
    // Handling this is simple, first divide n by 5 and remove all single 5s, then divide by 25 to remove extra 5s and so on.
    public int trailingZeroes(int A) {
        int pow=5,count=0;
        while(A/pow>0){
            count+=Math.floor(A/pow);
            pow*=5;
        }
        return count;
    }
}