public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        int i,j,ival=a.get(0),jval=a.get(0);
        for(i=1,j=1;j<a.size();j++){
            jval=a.get(j);
            if(ival!=jval){
                a.set(i,jval);
                i++;
                ival=jval;
            }
        }
        
        return i;
    }
}
