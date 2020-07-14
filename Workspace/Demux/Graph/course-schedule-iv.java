class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // topological sort gives us a linear ordering
        // it is only possible for DAG (directed and acyclic graph) 
        // use topological sort and check if size of linear order formed is equal to numCourses
        int[] indegree=new int[n];
        for(int[] link:prerequisites){
            indegree[link[1]]++;
        }
        LinkedList<Integer> q=new LinkedList<>();
        HashSet<Integer>[] setArr=new HashSet[n];
        // add all 0 indegree courses to the queue
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
            setArr[i]=new HashSet<Integer>();
        }
        while(q.size()>0){
            int fr=q.removeFirst();
            // add it to linear topological order
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][0]==fr){
                    setArr[prerequisites[i][1]].add(fr);
                    setArr[prerequisites[i][1]].addAll(setArr[fr]);
                    // then subtract 1 from its adjacent nodes
                    indegree[prerequisites[i][1]]-=1;
                    // check if its indegree is now 0
                    if(indegree[prerequisites[i][1]]==0){
                        // add it to the queue
                        q.addLast(prerequisites[i][1]);
                    }
                }
            }
        }
        ArrayList<Boolean> result=new ArrayList<>();
        for(int[] qr:queries){
            result.add(setArr[qr[1]].contains(qr[0]));
        }
        return result;
    }
}