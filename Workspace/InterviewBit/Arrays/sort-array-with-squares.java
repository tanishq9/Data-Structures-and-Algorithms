public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<A.size();i++){
            res.add(0);
        }
        int index=A.size()-1,i=0,j=A.size()-1;
        while(index>=0){
            int val1=A.get(i)*A.get(i);
            int val2=A.get(j)*A.get(j);
            if(val1>val2){
                i++;
                res.set(index,val1);
            }else{
                j--;
                res.set(index,val2);
            }
            index--;
        }
        return res;
    }
}
