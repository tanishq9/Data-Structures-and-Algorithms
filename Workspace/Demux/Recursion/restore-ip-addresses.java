class Solution {
    public List<String> restoreIpAddresses(String A) {
        // 0-255.0-255.0-255.0-255
        ArrayList<String> result=new ArrayList<>();
        f(A,A.length(),0,"",result);
        return result;
    }
    
    void f(String str,int len,int currentCuts,String temp,ArrayList<String> result){
        if(currentCuts>4){
            return;
        }
        if(str.length()==0 && currentCuts==4){
            // System.out.println(temp);
            result.add(temp.substring(0,temp.length()-1));    
            return;
        }
        // it cannot be like : 01.something or 001.something, only 0.something, nothing after it
        if(str.length()>0 && str.charAt(0)=='0'){
            f(str.substring(1),len,currentCuts+1,temp+0+".",result);
            return;
        }
        for(int cutSize=0;cutSize<=2;cutSize++){
            // finding a valid substring
            if(cutSize<str.length()){
                // proactively making a valid cut
                String leftCutString=str.substring(0,cutSize+1);                
                if(Integer.valueOf(leftCutString)<=255){
                    f(str.substring(cutSize+1),len,currentCuts+1,temp+leftCutString+".",result);
                }
            }
        }
    }
    
}
