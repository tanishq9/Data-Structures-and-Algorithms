public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        
        if(B>A.size()){
            Collections.sort(A,new Comparator<Integer>(){
                public int compare(Integer i1,Integer i2){
                    return i2-i1;     
                }
            });
            return A;
        }
        
        int n = A.size();
        int pos[] = new int[n+1];
        
        for(int i=0;i<n;i++)
        {
            pos[A.get(i)] = i;
        }
        
        for(int i=0;i<n && B>0;i++)
        {
            if(A.get(i) == n - i)
            {
                continue;
            }
            B--;
            int val = pos[n-i];
            
            pos[A.get(i)] = val;
            pos[n-i] = i;
            
            int temp = A.get(val);
            A.set(val,A.get(i));
            A.set(i,temp);
        }
        
        return A;

    }
}
