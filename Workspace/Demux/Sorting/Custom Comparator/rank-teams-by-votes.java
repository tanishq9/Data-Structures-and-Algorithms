class Solution {
    class Pair implements Comparable<Pair>{
        char cc;
        int[] freq=new int[26];
        Pair(char ic){
            this.cc=ic;
        }
        public int compareTo(Pair other){
            for(int i=0;i<26;i++){
                if(this.freq[i]>other.freq[i]){
                    return -1;
                }else if(this.freq[i]<other.freq[i]){
                    return 1;
                }
            }
            return (this.cc+"").compareTo(other.cc+"");
        }
    }
    
    public String rankTeams(String[] votes) {
        ArrayList<Pair> list=new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add(new Pair((char)('A'+i)));
        }
        for(String vote:votes){
            char[] arr=vote.toCharArray();
            for(int i=0;i<arr.length;i++){
                list.get(arr[i]-'A').freq[i]++;
            }
        }   
        Collections.sort(list);
        StringBuilder sb=new StringBuilder();
        int len=votes[0].length(),index=0;
        while(len-->0){
            sb.append(list.get(index++).cc);
        }
        return sb.toString();
    }
}
