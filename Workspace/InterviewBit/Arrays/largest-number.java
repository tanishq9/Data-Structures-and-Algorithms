public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        Collections.sort(A,new Comparator<Integer>(){
            public int compare(Integer i1,Integer i2){
                String s1=i1+""+i2;
                String s2=i2+""+i1;
                if(s1.compareTo(s2)>0){
                    return -1;
                }else{
                    return 1;
                }
            } 
        });
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<A.size() && A.get(i)==0){
            i++;
        }
        if(i==A.size()){
            return "0";
        }
        i=0;
        while(i<A.size()){
            sb.append(A.get(i));
            i++;
        }
        return sb.toString();
    }
}
