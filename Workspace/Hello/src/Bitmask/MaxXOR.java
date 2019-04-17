package Bitmask;

public class MaxXOR {
	 // method to get maximum xor value in range [L, R]
    static int maxXORInRange(int L, int R)
    {
        // get xor of limits
        int LXR = L ^ R;
      
        //  loop to get msb position of L^R
        int msbPos = 0;
        while (LXR > 0)
        {
            msbPos++;
            LXR >>= 1;
        }
      
        // construct result by adding 1,
        // msbPos times
        int maxXOR = 0;
        int two = 1;
        while (msbPos-- >0)
        {
            maxXOR += two;
            two <<= 1;
        }
      
        return maxXOR;
    }
     
    // main function 
    public static void main (String[] args) 
    {
        int L = 16;
        int R = 20;
        System.out.println(maxXORInRange(L, R));
    }
}