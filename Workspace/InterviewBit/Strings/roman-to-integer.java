public class Solution {
    public int romanToInt(String A) {
        // roman numerals are written largest to smallest from left to right
        // XXV is 25, XIX is 19, pattern is if we get char at i smaller than char at i+1 then substract value of that i char
        // Algo : if char at i> char at i+1, then add its contribution to result 
        // else if its smaller than char at i+1 then subtract its contribution from the result
        HashMap<Character,Integer> map=new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);        
        
        int result=0;
        
        for(int i=0;i<A.length()-1;i++){
            if(map.get(A.charAt(i))>=map.get(A.charAt(i+1))){
                result+=map.get(A.charAt(i));
            }else{
                result-=map.get(A.charAt(i));
            }
        }
        result+=map.get(A.charAt(A.length()-1));
        return result;
    }
}
