/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Integer> importanceMap;
    public int getImportance(List<Employee> employees, int id) {
        // Create map to store importance value of each employee
        importanceMap=new HashMap<>();
        // Create graph
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        HashMap<Integer,Boolean> visited=new HashMap<>();
        for(Employee em:employees){
            int eid=em.id;
            int eim=em.importance;
            importanceMap.put(eid,eim);
            visited.put(eid,false);
            graph.put(eid,em.subordinates);
        }
        // Use dfs to compute total importance 
        return dfs(id,graph,visited);
    }
    
    int dfs(int id,HashMap<Integer,List<Integer>> graph,HashMap<Integer,Boolean> visited){
        visited.put(id,true);
        int total=importanceMap.get(id);
        for(int ngr:graph.get(id)){
            if(visited.get(ngr)==false){
                total+=dfs(ngr,graph,visited);
            }
        }            
        return total;
    }
    
}