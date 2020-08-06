public class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> map=new LinkedHashMap<>();
        // LinkedHashMap is used to maintain the insertion order
        // Have added the 7 roman numerals represented by 7 different characters
        // and roman numerals where subtraction is used 
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");
        StringBuilder sb=new StringBuilder();
        for(int key:map.keySet()){
            while(num-key>=0){
                sb.append(map.get(key));
                num-=key;
            }
        }
        return sb.toString();
    }
}
