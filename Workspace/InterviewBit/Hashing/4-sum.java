public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Collections.sort(A);
        for(int i=0;i<=A.size()-4;i++){
            if(i>0 && A.get(i)==A.get(i-1)){
                continue;
            }
            for(int j=i+1;j<=A.size()-3;j++){
                if(j>i+1 && A.get(j)==A.get(j-1)){
                    continue;
                }
                int p1=j+1;
                int p2=A.size()-1;
                int target=B-A.get(i)-A.get(j);
                while(p1<p2){
                    if(A.get(p1)+A.get(p2)==target){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(A.get(i));
                        temp.add(A.get(j));
                        temp.add(A.get(p1));
                        temp.add(A.get(p2));
                        res.add(temp);
                        while(p1<p2 && A.get(p1)==A.get(p1+1)){
                            p1++;
                        }
                        while(p1<p2 && A.get(p2)==A.get(p2-1)){
                            p2--;
                        }
                        p1++;
                        p2--;
                    }else if(A.get(p1)+A.get(p2)>target){
                        while(p1<p2 && A.get(p2)==A.get(p2-1)){
                            p2--;
                        }
                        p2--;
                    }else{
                        while(p1<p2 && A.get(p1)==A.get(p1+1)){
                            p1++;
                        }
                        p1++;
                    }
                }
            }
        }
        return res;
    }
}
