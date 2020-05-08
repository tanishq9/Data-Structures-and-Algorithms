  public int maxDistToClosest(int[] seats) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                set.add(i);
            }
        }
        int maxi=-1,max=0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==0){
                int closestPersonDiff=0;
                if(set.floor(i)!=null && set.ceiling(i)!=null){
                    closestPersonDiff=Math.min(i-set.floor(i),set.ceiling(i)-i);
                }else if(set.floor(i)!=null){
                    closestPersonDiff=i-set.floor(i);
                }else if(set.ceiling(i)!=null){
                    closestPersonDiff=set.ceiling(i)-i;
                }
                if(closestPersonDiff>max){
                    max=closestPersonDiff;
                    maxi=i;
                }
            }
        }
        return max;
    }