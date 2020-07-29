public class Solution {
    public int removeElement(ArrayList<Integer> a, int b) {
        int c=0;
        // i pointer keeps track of first 'b' integer 
        // j pointer replaces i pointer value if is !'b' integer
        int i=0,j=0;
        for(;j<a.size();j++){
            if(a.get(j)!=b){
                a.set(i,a.get(j));
                i++;
            }
        }
        int k=i;
        while(k<a.size()){
            a.remove(k++);
        }
        return i;
    }
}
