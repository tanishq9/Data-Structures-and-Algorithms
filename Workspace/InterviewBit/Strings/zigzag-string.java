public class Solution {
    public String convert(String A, int B) {
        if(B==1){
            return A;
        }
        StringBuilder[] arr=new StringBuilder[B];
        int i=0,index=0;
        for(i=0;i<B;i++){
            arr[i]=new StringBuilder();
        }
        i=0;
        boolean flag=true;
        while(i<A.length()){
            char cc=A.charAt(i);
            if(flag){
                arr[index++].append(cc);
            }else{
                arr[index--].append(cc);
            }
            if(index==B){
                // switch direction upwards
                flag=false;
                index-=2;
            }else if(index==-1){
                // switch direction downwards
                flag=true;
                index+=2;
            }
            i++;
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder sb:arr){
            res.append(sb.toString());
        }
        return res.toString();
    }
}
