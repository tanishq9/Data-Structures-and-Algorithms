 public int colorful(int A) {
        int[] nums=new int[String.valueOf(A).length()];
        int index=nums.length-1;
        while(A>0){
            int rem=A%10;
            A/=10;
            nums[index--]=rem;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int prod=1;
            for(int j=i;j<nums.length;j++){
                prod*=nums[j];
                if(set.contains(prod)){
                    return 0;
                }else{
                    set.add(prod);
                }
            }
        }
        return 1;
    }