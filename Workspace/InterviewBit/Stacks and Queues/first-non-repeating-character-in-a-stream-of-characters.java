public class Solution {
    public String solve(String A) {
        StringBuilder sb=new StringBuilder();
        LinkedList<Character> q=new LinkedList<>();
        // non-repeated element set
        HashSet<Character> nonRepeated=new HashSet<>();
        // repeated element set
        HashSet<Character> repeated=new HashSet<>();
        
        int[] freq=new int[26];
        for(int i=0;i<A.length();i++){
            // Solution using frequency array and queue approach
            char cc=A.charAt(i);
            freq[cc-'a']++;
            if(freq[cc-'a']==1){
                // add new element to the queue
                q.addLast(cc);
            }
            while(q.size()>0 && freq[q.getFirst()-'a']>1){
                q.removeFirst();
            }
            if(q.size()>0){
                sb.append(q.getFirst());
            }else{
                sb.append("#");                    
            }
            // Solution using 2 sets and queue approach
            /* 
            
            // if new element
            if(!nonRepeated.contains(cc)){
                q.addLast(cc);
                nonRepeated.add(cc);
            }else{
                repeated.add(cc);
                // if repeated element then update queue 
                while(q.size()>0 && repeated.contains(q.getFirst())){
                    q.removeFirst();
                }
            }
            if(q.size()>0){
                sb.append(q.getFirst());
            }else{
                sb.append("#");
            }
            
            */
        }
        return sb.toString();
    }
}
