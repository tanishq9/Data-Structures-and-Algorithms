public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        HashSet<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        for(int i=0;i<=A.size()-3;i++){
            if(i>0){
                if(A.get(i)==A.get(i-1)){
                    continue;   
                }
            }
            int j=i+1;
            int k=A.size()-1;
            while(j<k){
                int sum=A.get(i)+A.get(j)+A.get(k);
                if(sum==0){
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(A.get(i));
                    temp.add(A.get(j));
                    temp.add(A.get(k));
                    res.add(temp);
                    while(j<k && A.get(j)==A.get(j+1)){
                        j++;
                    }
                    j++;
                    while(j<k && A.get(k)==A.get(k-1)){
                        k--;
                    }
                    k--;
                }else if(sum>0){
                    while(j<k && A.get(k)==A.get(k-1)){
                        k--;
                    }
                    k--;
                }else{
                    while(j<k && A.get(j)==A.get(j+1)){
                        j++;
                    }
                    j++;
                }
            }
        }
        return res;
    }
}
