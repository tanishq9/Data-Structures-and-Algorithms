public class Solution {
    class Node{
        String value;
        int modN=-1;
        Node(String x,int y){
            this.value=x;
            this.modN=y;
        }
    }
    public String multiple(int N) {
        LinkedList<Node> q=new LinkedList<>();
        q.addLast(new Node("1",1%N));
        boolean[] visited=new boolean[N];
        // HashSet<Integer> set=new HashSet<>();
        while(q.size()>0){
            Node node=q.removeFirst();
            if(node.modN==0){
                return node.value;
            }
            // storing the remainders in the Node object
            // helps to avoid the check function which
            // takes up O(str.length()) time and causes TLE
            int r1=(node.modN*10)%N;
            int r2=(node.modN*10+1)%N;


            // to optimize, we only consider each remainder just once
            // as repetion of remainder would also lead to the same set of remainders 
            if(!visited[r1]){
                visited[r1]=true;
                q.addLast(new Node(node.value+"0",r1));
            }
            
            if(!visited[r2]){
                visited[r1]=true;
                q.addLast(new Node(node.value+"1",r2));
            }
        }
        // code will never reach here
        return "";
    }
    
    // Some conclusions :
    // 1. Prefer boolean Array over hashset for checking visited in Graph ques as we save on time
    // 2. We stored remainder on the go and didn't have to compute remainder in every iteration
    // 3. Followed 1 and 2 to avoid TLE
    
    // never invoked and as a result, we save on time and avoid TLE!
    int check(String fr,int A){
        int res=0;
        for(int i=0;i<fr.length();i++){
            res=(res*10+fr.charAt(i)-'0')%A;
        }
        return res;
    }
}
