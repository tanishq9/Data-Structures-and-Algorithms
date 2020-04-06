class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer i1,Integer i2){
                String s1=i1+""+i2;
                String s2=i2+""+i1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb=new StringBuilder();
        boolean allZeros=true;
        for(int num:list){
            if(num!=0){
                allZeros=false;
            }
            sb.append(num);   
        }
        return allZeros==true?"0":sb.toString();
    }
}