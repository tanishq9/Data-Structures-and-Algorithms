public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int i=0,total=0;
        while(i<A.size()){
            while(i+1<A.size() && A.get(i)>A.get(i+1)){
                i++;
            }
            int buyingPoint=i;
            // find the selling point now
            i++;
            while(i+1<A.size() && A.get(i)<A.get(i+1)){
                i++;
            }
            int sellingPoint=i;
            if(buyingPoint<A.size() && sellingPoint<A.size()){
                // System.out.println(buyingPoint+" "+sellingPoint);
                total+=A.get(sellingPoint)-A.get(buyingPoint);
            }
            // perform the next transaction
            i++;
        }
        return total;
    }
}
