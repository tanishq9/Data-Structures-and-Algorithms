class Solution {
    ArrayList<String> list;
    public int[] numsSameConsecDiff(int N, int K) {
        list=new ArrayList<>();
        if(N==1){
            for(int i=0;i<=9;i++){
                list.add(i+""); 
            }
        }else{
            // fixing the starting digit
            for(int i=1;i<=9;i++){
                helper(N,K,i,i+"");        
            }
        }
        int len=list.size();
        int[] res=new int[len];
        int index=0;
        for(String str:list){
            res[index++]=Integer.valueOf(str);
        }
        return res;
    }
    void helper(int N,int K,int digit,String str){
        if(N==1){
            list.add(str);
            return;
        }
        if(digit-K>=0){
            digit-=K;
            helper(N-1,K,digit,str+""+digit);    
            digit+=K;
        }
        if(digit+K<=9 && digit-K!=digit+K){
            digit+=K;
            helper(N-1,K,digit,str+""+digit);  
            digit-=K;
        }
    }
    
}