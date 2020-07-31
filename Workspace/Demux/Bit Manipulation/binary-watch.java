class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> list=new ArrayList<>();
        for(int hour=0;hour<12;hour++){
            for(int min=0;min<60;min++){
                if(Integer.bitCount(hour)+Integer.bitCount(min)==num){
                    list.add(String.format("%d:%02d",hour,min));
                }
            }
        }
        return list;
    }
}