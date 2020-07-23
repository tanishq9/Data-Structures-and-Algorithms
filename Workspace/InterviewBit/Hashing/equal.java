public class Solution {
    
    class Pair{
        int i,j;
        Pair(int ii,int ij){
            this.i=ii;
            this.j=ij;
        }
    }
    
    // sorting logic
    class myC implements Comparator<ArrayList<Integer>>{
        public int compare(ArrayList<Integer> one,ArrayList<Integer> two){
            int c=one.get(0)-two.get(0);
            if(c==0){
                c=one.get(1)-two.get(1);
            }
            if(c==0){
                c=one.get(2)-two.get(2);
            }
            if(c==0){
                c=one.get(3)-two.get(3);
            }
            return c;
        }
    }
    
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        HashMap<Integer,Pair> map=new HashMap<>();
        for(int i=0;i<A.size();i++){
            for(int j=i+1;j<A.size();j++){
                int sum=A.get(i)+A.get(j);
                if(map.containsKey(sum)){
                    Pair p=map.get(sum);
                    ArrayList<Integer> list=new ArrayList<>();
                    // maintain order of a1<=b1<=c1<=d1
                    // where all a1,b1,c1,d1 are indexes
                    if(p.i<p.j && p.i<i && i<j && p.j!=i && p.j!=j){
                        list.add(p.i);
                        list.add(p.j);
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }
                }else{
                    map.put(sum,new Pair(i,j));
                }
            }
        }
        Collections.sort(res,new myC());
        return res.get(0)!=null?res.get(0):null;
    }
}
