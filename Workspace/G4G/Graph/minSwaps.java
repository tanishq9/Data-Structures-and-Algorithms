
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function*/
class GfG
{
    
    static class Pair implements Comparable<Pair>{
        int element;
        int index;
        Pair(int ie,int ii){
            this.element = ie;
            this.index = ii;
        }
        public int compareTo(Pair other){
            if(this.element>other.element){
                return 1;
            }else if(this.element<other.element){
                return -1;
            }else{
                return 0;
            }
        }
    }
    
	public static int minSwaps(int[] A, int N)
	{
	    Pair[] graph = new Pair[N];
	    for(int i=0;i<N;i++){
	        graph[i]=new Pair(A[i],i);
	    }
	    Arrays.sort(graph);
	    boolean[] visited = new boolean[N];
	    int result = 0;
	    for(int i=0;i<N;i++){
	        if(visited[i]==true||graph[i].index==i){
	            continue;
	        }else if(visited[i]==false){
	            int j = i;
	            int cycle_size = 0;
	            while(visited[j]!=true){
	                visited[j]=true;
	                // Go to the next vertex
                    cycle_size++;
                    j = graph[j].index;
	            }
	            if(cycle_size > 0){
                    result += (cycle_size-1);
	            }
	        }
	    }
	    return result;
	}
}
