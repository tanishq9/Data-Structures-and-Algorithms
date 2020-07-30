public class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> res=new ArrayList<>();
        int i=1;
        while(i<=A){
            if(i%3==0 && i%5==0){
                res.add("FizzBuzz");
            }else if(i%3==0){
                res.add("Fizz");
            }else if(i%5==0){
                res.add("Buzz");
            }else{
                res.add(i+"");
            }
            i++;
        }
        return res;
    }
}
