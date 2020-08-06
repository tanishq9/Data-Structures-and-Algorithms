public class Solution {
    
    public String longestCommonPrefix(ArrayList<String> A) {
        if(A.size()==1){
            return A.get(0);
        }
        String prev="";
        int index=0;
        boolean firstTime=true;
        while(index<A.size()){
            String str1="",str2="";
            if(firstTime==true){
                str1=A.get(0);
                str2=A.get(1);
                index+=2;
                firstTime=false;
            }else{
                str1=A.get(index);
                index+=1;
            }
            int i=0,j=0;
            String newPrev="";
            if(str2.length()==0){
                str2=prev;
            }
            while(i<str1.length() && j<str2.length()){
                if(str1.charAt(i)!=str2.charAt(j)){
                    break;
                }
                newPrev+=str1.charAt(i);
                i++;
                j++;
            }
            prev=newPrev;
        }
        return prev;
    }

    
}
