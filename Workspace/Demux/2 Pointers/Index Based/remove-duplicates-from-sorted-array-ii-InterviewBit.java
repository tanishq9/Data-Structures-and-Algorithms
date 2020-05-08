public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        int i,j,ival=a.get(0),jval,ivalOccurance=1;
        for(i=1,j=1;j<a.size();j++){
            jval=a.get(j);
            if(ival!=jval){
                a.set(i,jval);
                ival=jval;
                ivalOccurance=1;
                i++;
            }else{
                if(ivalOccurance<2){
                    a.set(i,ival);
                    ivalOccurance+=1;
                    i++;
                }
            }
        }
        return i;
    }
}
