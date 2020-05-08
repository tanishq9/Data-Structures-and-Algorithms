https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> secretMap=new HashMap<>();
        int bulls=0,cows=0;
        // for bulls
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }else{
                // fill secret map for future cow matching
                char cc=secret.charAt(i);
                secretMap.put(cc,secretMap.getOrDefault(cc,0)+1);                
            }
        }
        // for cows
        for(int i=0;i<guess.length();i++){
            char cc=guess.charAt(i);
            // cows match only digits
            if(secret.charAt(i)!=cc && secretMap.containsKey(cc)){
                cows+=1;
                secretMap.put(cc,secretMap.get(cc)-1);
                if(secretMap.get(cc)==0){
                    secretMap.remove(cc);
                }
            }
        }
        return bulls+"A"+cows+"B";
    }
}