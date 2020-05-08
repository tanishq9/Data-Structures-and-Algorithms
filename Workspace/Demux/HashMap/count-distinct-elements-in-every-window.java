void countDistinct(int A[], int k, int n) {
        // Your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int start=0,end=0;
        while(end<A.length){
            map.put(A[end],map.getOrDefault(A[end],0)+1);
            if(end-start+1==k){
                System.out.print(map.size()+" ");
                map.put(A[start],map.get(A[start])-1);
                if(map.get(A[start])==0){
                    map.remove(A[start]);
                }
                // shrink window after update
                start++;
            }
            // expand window to get to solution
            end++;
        }
    }