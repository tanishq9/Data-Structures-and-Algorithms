class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topological sort gives us a linear ordering
        // it is only possible for DAG (directed and acyclic graph) 
        // use topological sort and check if size of linear order formed is equal to numCourses
        int[] indegree=new int[numCourses];
        for(int[] link:prerequisites){
            indegree[link[0]]++;
        }
        LinkedList<Integer> q=new LinkedList<>();
        // add all 0 inorder courses to the queue
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> linearOrder=new ArrayList<>();
        while(q.size()>0){
            int fr=q.removeFirst();
            // add it to linear topological order
            linearOrder.add(fr);
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==fr){
                    // then subtract 1 from its adjacent nodes
                    indegree[prerequisites[i][0]]-=1;
                    // check if its indegree is now 0
                    if(indegree[prerequisites[i][0]]==0){
                        // add it to the queue
                        q.addLast(prerequisites[i][0]);
                    }
                }
            }
        }
        
        
        return linearOrder.size()==numCourses;
    }
}