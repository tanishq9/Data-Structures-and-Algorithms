public class Solution {
    
    class Node{
        char cc;
        HashMap<Character,Node> cmap;
        boolean eow;
        Node(char ic){
            this.cc=ic;
            this.cmap=new HashMap<>();
            this.eow=false;
        }
    }
    
    Node root;
    
    void insertInTrie(String str){
        Node current=root;
        for(char cc:str.toCharArray()){
            if(current.cmap.containsKey(cc)){
                current=current.cmap.get(cc);
            }else{
                current.cmap.put(cc,new Node(cc));
                current=current.cmap.get(cc);
            }
        }
        current.eow=true;
    }
    
    boolean isPresent(String str){
        Node current=root;
        for(char cc:str.toCharArray()){
            if(current.cmap.containsKey(cc)){
                current=current.cmap.get(cc);
            }else{
                return false;
            }
        }
        if(current.eow){
            return true;
        }
        return false;
    }
    
    public int[] solve(String A, String[] B) {
        int j=0;
        root=new Node('$');
        while(j<A.length()){
            StringBuilder sb=new StringBuilder();
            while(j<A.length() && A.charAt(j)!='_'){
                sb.append(A.charAt(j++));
            }    
            insertInTrie(sb.toString());
            // to get the next good word
            j++;
        }
        // result array will tell how many times a good word has occurred in a particular rating
        int[][] result=new int[B.length][2];
        for(int i=0;i<B.length;i++){
            String rating=B[i];
            int count=0;
            j=0;
            while(j<rating.length()){
                StringBuilder sb=new StringBuilder();
                while(j<rating.length() && rating.charAt(j)!='_'){
                    sb.append(rating.charAt(j++));
                }    
                if(isPresent(sb.toString())){
                    count++;
                }
                // to get the next rating word
                j++;
            }
            result[i][0]=i;
            result[i][1]=count;
        }
        // Sorting on basis of occurrence and index
        Arrays.sort(result,new Comparator<int[]>(){
           public int compare(int[] e1,int[] e2){
                if(e1[1]>e2[1]){
                    return -1;
                }else if(e1[1]<e2[1]){
                    return 1;
                }else{
                    return e1[0]-e2[0];
                }
           } 
        });
        int[] sorted=new int[result.length];
        for(int i=0;i<sorted.length;i++){
            // System.out.println(Arrays.toString(result[i]));
            sorted[i]=result[i][0];
        }
        return sorted;
    }
}
