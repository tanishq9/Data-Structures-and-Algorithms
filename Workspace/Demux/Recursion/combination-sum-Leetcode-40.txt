class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates,0,0,target,new ArrayList<>(),res);
        return res;
    }
    void f(int[] arr,int index,int sum,int target,List<Integer> temp,List<List<Integer>> res){
       
        if(sum==target){
            // deep copy
            res.add(new ArrayList<>(temp));
            return;  
        }
        
        if(index==arr.length){
            return;
        }
        
        if(sum>target){
            return;
        }
        
        System.out.println(sum);
        // count occurances
        int occ=0,i=index,j=index;
        while(i<arr.length){
            if(i!=index && arr[i]!=arr[i-1]){
                break;
            }
            i++;
            occ++;
        }
        // i would have reached the unique element
        // taking 0 occurances of current element
        f(arr,i,sum,target,temp,res);
        
        // now consider 1 to number of occurances and take them 1 by 1 
        for(int k=1;k<=occ;k++){
            int num=k;
            while(num-->0){
                sum+=arr[j];
                temp.add(arr[j]);
            }
            f(arr,i,sum,target,temp,res);
            num=0;
            while(num!=k){
                sum-=arr[j];
                temp.remove(temp.size()-1);
                num++;
            }
        }
        
    }
}