package Graph;

public class GraphClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		/*
		 * graph.addVertex("A"); graph.addVertex("B"); graph.addVertex("C");
		 * graph.addVertex("D"); graph.addVertex("E"); graph.addVertex("F");
		 * graph.addVertex("G");
		 */
		/*
		 * graph.addVertex("Y"); graph.addVertex("X");
		 */

		/*
		 * graph.addEdge("A", "B", 10); graph.addEdge("A", "D", 40); graph.addEdge("C",
		 * "B", 10); graph.addEdge("C", "D", 10); graph.addEdge("D", "E", 2);
		 * graph.addEdge("E", "F", 8); graph.addEdge("E", "G", 3); graph.addEdge("F",
		 * "G", 3);
		 */
		/* graph.addEdge("X", "Y", 6); */

		/*
		 * System.out.println(graph.numEdges());
		 * System.out.println(graph.containsEdge("A", "B"));
		 * System.out.println(graph.containsEdge("A", "P")); graph.display(); if
		 * (graph.hasPath("A", "D")) { System.out.println("Exists"); } else {
		 * System.out.println("DNE"); }
		 */

		/*
		 * graph.BFS(); graph.DFS();
		 * 
		 * System.out.println(graph.connected());
		 */
		/*
		 * System.out.println(graph.distance("F"));
		 * System.out.println(graph.cycleDetection());
		 */
		/*
		 * graph.addVertex("0"); graph.addVertex("1"); graph.addVertex("2");
		 * graph.addVertex("3"); graph.addVertex("4"); graph.addVertex("5");
		 * 
		 * graph.addEdge("0", "2", 10); graph.addEdge("1", "2", 40); graph.addEdge("2",
		 * "4", 10); graph.addEdge("2", "3", 10); graph.addEdge("4", "5", 2);
		 * graph.addEdge("3", "5", 8); graph.addEdge("1", "4", 3);
		 * 
		 * graph.topologicalSort();
		 */
		graph.addVertex("0");
		graph.addVertex("1");
		graph.addVertex("2");
		graph.addVertex("3");
		graph.addEdge("0", "1", 10);
		graph.addEdge("0", "2", 10);
		graph.addEdge("1", "3", 10);
		graph.addEdge("1", "3", 10);
		System.out.println(graph.isBipartite("0"));
	}

}
