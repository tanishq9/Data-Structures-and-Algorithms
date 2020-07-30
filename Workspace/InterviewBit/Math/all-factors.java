public class Solution {
    // return factors in sorted order in O(root(n))
    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> res1=new ArrayList<>();
        LinkedList<Integer> res2=new LinkedList<>();
        for(int i=1;i*i<=A;i++){
            if(A%i==0){
                res1.add(i);
                if(i!=A/i){
                    res2.addFirst(A/i);
                }
            }
        }
        res1.addAll(res2);
        return res1;
    }
    
    // return factors in sorted order in O(root(n)) -> Alternate Solution
    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=1;i*i<=A;i++){
            if(A%i==0){
                res.add(i);
            }
        }
        for(int i=res.size()-1;i>=0;i--){
            int num=res.get(i);
            if(num!=A/num){
                res.add(A/num);
            }
        }
        return res;
    }
    
    
}
