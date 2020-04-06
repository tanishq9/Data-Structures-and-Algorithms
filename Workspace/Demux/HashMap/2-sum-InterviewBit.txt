public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<A.size();i++){
            if(map.containsKey(A.get(i))){
                ArrayList<Integer> val=map.get(A.get(i));
                val.add(i);
                map.put(A.get(i),val);
            }else{
                ArrayList<Integer> val=new ArrayList<>();
                val.add(i);
                map.put(A.get(i),val);
            } 
        } 
        int min2=Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++){
            int t=B-A.get(i);
            if(map.containsKey(t)){
                ArrayList<Integer> val=map.get(t);
                int i1=i;
                int i2=-1;
                for(int index:val){
                    if(index!=i){
                        i2=index;
                        break;
                    }
                }
                if(i2!=-1){
                    if(min2>i2 && i1<i2){
                        min2=i2;
                        res.clear();
                        res.add(i1+1);
                        res.add(i2+1);
                    }    
                }
            }
        }
        return res;