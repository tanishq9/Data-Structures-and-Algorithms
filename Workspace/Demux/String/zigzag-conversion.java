class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        // P 0 A 1 Y 2 P 1 A 0 L 1 I 2
        // IF 0 THEN DIRECTION 1, IF N-1 THEN DIRECTION -1
        int i=0,index=0;
        boolean flag=true;
        StringBuilder[] arr=new StringBuilder[numRows];
        for(int j=0;j<arr.length;j++){
            arr[j]=new StringBuilder();
        }
        while(i<s.length()){
            char cc=s.charAt(i);
            if(flag==true){
                arr[index].append(cc);
                // System.out.println(index+" "+arr[index].toString());
                index++;
            }else{
                arr[index].append(cc);
                // System.out.println(index+" "+arr[index].toString());
                index--;
            }
            if(index==numRows){
                flag=false;
                index-=2;
            }else if(index==-1){
                flag=true;
                index+=2;
            }
            i++;
        }
        StringBuilder sb=new StringBuilder();
        for(StringBuilder str:arr){
            sb.append(str);
        }
        return sb.toString();
    }
}
