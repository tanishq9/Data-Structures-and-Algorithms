package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Client {

	static class Edge {
		// u is current node
		int u;
		// v is the neighbour node
		int v;
		int w;

		Edge(int iu, int iv, int iw) {
			this.u = iu;
			this.v = iv;
			this.w = iw;
		}
	}

	static void display(ArrayList<ArrayList<Edge>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print(i + "->");
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print("[" + graph.get(i).get(j).u + ",");
				System.out.print(graph.get(i).get(j).v + ",");
				System.out.print(graph.get(i).get(j).w + "],");
			}
			System.out.println("END");
		}
	}

	static void addEdge(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int wt) {
		// For Undirected Graph
		graph.get(v1).add(new Edge(v1, v2, wt));
		graph.get(v2).add(new Edge(v2, v1, wt));
	}

	// 1. HasPath : Can be done using DFS and BFS both
	static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		boolean[] visited = new boolean[graph.size()];
		// doing using DFS
		return hasPathHelper(graph, src, dest, visited);
	}

	static boolean hasPathHelper(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited) {
		if (src == dest) {
			return true;
		}
		visited[src] = true;
		// travering all neighbors of this current source node
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			int ngbr = e.v;
			// if we get true even once then start unwinding the stack
			if (!visited[ngbr] && hasPathHelper(graph, ngbr, dest, visited)) {
				return true;
			}
		}
		// don't mark as false again as there is no path to destination along this node
		// so we won't use it in further exploring
		return false;
	}

	// 2. Print All Paths
	static void printAllPaths(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		boolean[] visited = new boolean[graph.size()];
		// doing using DFS
		printAllPathsHelper(graph, src, dest, visited, "");
	}

	static void printAllPathsHelper(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited,
			String psf) {
		if (src == dest) {
			System.out.println(psf + dest);
			return;
		}
		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			int nbr = e.v;
			if (!visited[nbr]) {
				printAllPathsHelper(graph, nbr, dest, visited, psf + src + ",");
			}
		}
		// we will set it this node as false
		// so that other paths can be explored through it we reach the dest
		visited[src] = false;
	}

	// 3. Print Hamiltonian cycle from a given source node
	// hml cycle is a hml path with edge between last and first vertex
	// every vertex is visited in such cycle and path
	static void printHamiltonianCycle(ArrayList<ArrayList<Edge>> graph, int src) {
		boolean[] visited = new boolean[graph.size()];
		hamHelper(graph, src, 0, visited, src, "");
	}

	static void hamHelper(ArrayList<ArrayList<Edge>> graph, int src, int count, boolean[] visited, int original,
			String psf) {
		if (count == graph.size() - 1) {
			// check if this last vertex contains the original source vertex
			for (int i = 0; i < graph.get(src).size(); i++) {
				if (graph.get(src).get(i).v == original) {
					System.out.println(psf + src + "," + original + "*");
					break;
				}
			}
			return;
		}

		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			int ngr = e.v;
			// !visited[ngr] checks whether the neighbour node is already
			// present in the path being explored currently or not
			if (!visited[ngr]) {
				hamHelper(graph, ngr, count + 1, visited, original, psf + src + ",");
			}
		}
		visited[src] = false;
	}

	// 4. BFS Shortest Path for Unweighted Graph
	static class Traversal {
		int vtx;
		String psf;
		int dsf;

		Traversal(int iv, String ip, int id) {
			this.vtx = iv;
			this.psf = ip;
			this.dsf = id;
		}
	}

	public static int bfsShortestPath(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		LinkedList<Traversal> q = new LinkedList<>();
		q.add(new Traversal(src, src + "", 0));
		boolean[] visited = new boolean[graph.size()];
		while (q.size() > 0) {
			// get, remove
			Traversal fr = q.removeFirst();
			// mark
			if (visited[fr.vtx]) {
				// we won't process the already processed node again
				continue;
			} else {
				visited[fr.vtx] = true;
			}
			// work/process
			if (fr.vtx == dest) {
				System.out.println(fr.psf);
				return fr.dsf;
			}
			for (int i = 0; i < graph.get(fr.vtx).size(); i++) {
				Edge e = graph.get(fr.vtx).get(i);
				int nbr = e.v;
				if (!visited[nbr]) {
					q.add(new Traversal(nbr, fr.psf + "," + nbr, fr.dsf + 1));
				}
			}
		}
		return -1;
	}

	// 5. Get Connected Components, used DFS to find components
	static void getCC(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<ArrayList<Integer>> components = new ArrayList<>();
		boolean[] visited = new boolean[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			ArrayList<Integer> singleComponent = new ArrayList<>();
			if (visited[i] == false) {
				singleComponent = getCCHelper(graph, i, visited);
				components.add(singleComponent);
			}
		}
		System.out.println(components);
	}

	static ArrayList<Integer> getCCHelper(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited) {
		ArrayList<Integer> cmp = new ArrayList<>();
		cmp.add(src);
		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			int ngr = e.v;
			if (!visited[ngr]) {
				cmp.addAll(getCCHelper(graph, ngr, visited));
			}
		}
		return cmp;
	}

	// 6. Check if graph contains a cycle, ideally check for each component of graph
	// if any one component is cyclic then the graph is also considered cyclic
	static boolean isCyclic(ArrayList<ArrayList<Edge>> graph) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.size()];
		q.add(0); // any node of graph can be taken as source
		while (q.size() > 0) {
			int fr = q.removeFirst();
			if (visited[fr]) {
				return true;
			} else {
				visited[fr] = true;
			}
			for (int i = 0; i < graph.get(fr).size(); i++) {
				int ng = graph.get(fr).get(i).v;
				if (!visited[ng]) {
					q.addLast(ng);
				}
			}
		}
		return false;
	}

	// 7. Check for bipartite : checking existence of odd length cycle using BFS
	// Prove using a small test for even cycle of length 4 and odd cycle of length 3
	// Basically if you have been visited by your parent in the previous level then
	// you cannot be visited again by your neighbour which also has the same parent
	// in the next level
	static boolean isBipartite(ArrayList<ArrayList<Edge>> graph) {
		int[] visited = new int[graph.size()];
		int lvl = 1;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(null);
		while (q.size() > 0) {
			Integer fr = q.removeFirst();
			if (fr == null) {
				lvl++;
				if (q.size() > 0) {
					q.addLast(null);
				}
				continue;
			}
			if (visited[fr] == 0) {
				// we are visiting this node for the first time
				visited[fr] = lvl;
			} else {
				if (lvl % 2 == 0 && visited[fr] % 2 == 1) {
					return false;
				}
				if (lvl % 2 == 1 && visited[fr] % 2 == 0) {
					return false;
				}
			}
			// add neighbors
			for (int i = 0; i < graph.get(fr).size(); i++) {
				int ng = graph.get(fr).get(i).v;
				if (visited[ng] == 0) {
					q.addLast(ng);
				}
			}
		}
		return true;
	}

	// bipartite alternate method [2-COLORABLE GRAPH] using BFS
	boolean isBipartite(int G[][], int V) {

		// Color can also be called as set
		int[] color = new int[V];
		for (int i = 0; i < V; i++) {
			color[i] = -1;
		}
		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (helper(i, G, color, V) == false) {
					return false;
				}
			}
		}
		return true;
	}

	boolean helper(int src, int[][] G, int[] color, int V) {
		color[src] = 1;

		LinkedList<Integer> q = new LinkedList<>();
		q.addLast(src);

		while (q.size() > 0) {
			int front = q.getFirst();
			q.removeFirst();
			// self loop
			if (G[front][front] == 1) {
				return false;
			}
			for (int v = 0; v < V; v++) {
				if (G[front][v] == 1 && color[v] == -1) {
					q.addLast(v);
					color[v] = 1 - color[front];
				} else if (G[front][v] == 1 && color[v] == color[front]) {
					return false;
				}
			}
		}
		return true;
	}

	// 8. Djikstra : Shortest Weighted Path b/w 2 nodes, O(ElogV) time complexity
	static class dj implements Comparable<dj> {
		int vtx;
		String psf;
		int dsf;

		dj(int iv, String ip, int id) {
			this.vtx = iv;
			this.psf = ip;
			this.dsf = id;
		}

		public int compareTo(dj other) {
			return this.dsf - other.dsf;
		}
	}

	static int dijkstra(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		PriorityQueue<dj> pq = new PriorityQueue<>();
		pq.add(new dj(src, src + "", 0));
		boolean[] vis = new boolean[graph.size()];
		while (pq.size() > 0) {
			dj fr = pq.remove();
			if (vis[fr.vtx]) {
				continue;
			} else {
				vis[fr.vtx] = true;
			}
			if (fr.vtx == dest) {
				System.out.println(fr.psf);
				return fr.dsf;
			}
			for (int i = 0; i < graph.get(fr.vtx).size(); i++) {
				int nbr = graph.get(fr.vtx).get(i).v;
				int wt = graph.get(fr.vtx).get(i).w;
				if (!vis[nbr]) {
					pq.add(new dj(nbr, fr.psf + "->" + nbr, fr.dsf + wt));
				}
			}
		}
		return -1;
	}

	// 9. Topological Sort Iterative(Using BFS) : (Only works for DAG)

	// TopoRecursive(Using DFS) : Fill Stack and in the end print till empty
	static int[] topoSortRecursive(ArrayList<ArrayList<Edge>> graph) {
		int[] lo = new int[graph.size()];
		Stack<Integer> stack = new Stack<>();
		boolean[] vis = new boolean[graph.size()];
		// check for all the components
		for (int i = 0; i < graph.size(); i++) {
			if (!vis[i]) {
				fillStack(graph, i, vis, stack);
			}
		}
		int index = 0;
		while (stack.size() > 0) {
			lo[index++] = stack.pop();
		}
		return lo;
	}

	static void fillStack(ArrayList<ArrayList<Edge>> graph, int src, boolean[] vis, Stack<Integer> stack) {
		vis[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			int ngr = graph.get(src).get(i).v;
			if (!vis[ngr]) {
				fillStack(graph, ngr, vis, stack);
			}
		}
		// push node to stack after it is fully processed
		stack.push(src);
	}

	// TopoIterative : Make the indegree array and use evergreen BFS approach
	static int[] topoSortIterative(ArrayList<ArrayList<Edge>> adj, int n) {
		// lo is linear ordering
		int[] lo = new int[n];
		// in is for inorder
		int[] in = new int[n];
		// fill the inorder array
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				int ngr = adj.get(i).get(j).v;
				in[ngr] += 1;
			}
		}
		System.out.println(Arrays.toString(in));
		// find the 0 indegree node
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < adj.size(); i++) {
			if (in[i] == 0) {
				q.addLast(i);
			}
		}
		// use bfs to get linear ordering
		int index = 0;
		boolean[] vis = new boolean[adj.size()];
		while (q.size() > 0) {
			int fr = q.removeFirst();
			if (vis[fr]) {
				continue;
			} else {
				vis[fr] = true;
			}
			lo[index++] = fr;
			for (int i = 0; i < adj.get(fr).size(); i++) {
				int ngr = adj.get(fr).get(i).v;
				in[ngr] -= 1;
				if (in[ngr] == 0) {
					q.addLast(ngr);
				}
			}
		}
		return lo;
	}

	// 10. Bellman Ford : get shortest path from source to all vertices
	// even works in case of negative edges unlike djikstra
	// O(V*E) which is approx. O(V^3) in worst case i.e for complete graph
	static void bellmanFord(ArrayList<ArrayList<Edge>> graph) {
		// apply bellman ford to detect negative cycle and also
		// to get shortest path from source to all nodes in O(V*E)
		int n = graph.size();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		// taking 0 as the source node
		dist[0] = 0;
		int it = n;
		// relax for V-1 times
		while (it-- > 1) {
			relax(graph, dist);
		}
		// System.out.println(Arrays.toString(dist));
		// if still the vertexs can be relaxed then it contains negative cycle
		if (relax(graph, dist)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static boolean relax(ArrayList<ArrayList<Edge>> graph, int[] dist) {
		boolean isChange = false;
		int n = graph.size();
		for (int i = 0; i < n; i++) {
			for (Edge e : graph.get(i)) {
				int ngr = e.v;
				int wt = e.w;
				if (dist[i] != Integer.MAX_VALUE && dist[i] + wt < dist[ngr]) {
					isChange = true;
					dist[ngr] = dist[i] + wt;
				}
			}
		}
		return isChange;
	}

	// 11. Floyd Warshall (P4)
	// gets us 'all pairs shortest paths' in a graph, works for -ve edges as well
	static void floydWarshall(int[][] wts) {
		int n = wts.length;
		// select the intermediate node
		for (int in = 0; in < n; in++) {
			for (int src = 0; src < n; src++) {
				for (int dest = 0; dest < n; dest++) {
					if (in != src && in != dest && wts[src][in] != Integer.MAX_VALUE
							&& wts[in][dest] != Integer.MAX_VALUE) {
						if (wts[src][in] + wts[in][dest] < wts[src][dest]) {
							wts[src][dest] = wts[src][in] + wts[in][dest];
						}
					}
				}
			}
		}
	}

	// 12. MST - Prims and Kruksal
	// Prims
	// Use similar logic to Djikstra approach but maintain only weight of ngbhr edge

	static class MSTV implements Comparable<MSTV> {
		int vtx;
		int acquiredBy;
		int w;

		MSTV(int iv, int acq, int id) {
			this.vtx = iv;
			this.acquiredBy = acq;
			this.w = id;
		}

		@Override
		public int compareTo(MSTV o) {
			return this.w - o.w;
		}
	}

	static void prims(ArrayList<ArrayList<Edge>> graph, int src) {
		int n = graph.size() - 1;
		PriorityQueue<MSTV> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[graph.size()];
		pq.add(new MSTV(src, -1, 0));
		int total = 0;
		while (pq.size() > 0) {
			MSTV fr = pq.remove();
			if (vis[fr.vtx]) {
				continue;
			} else {
				vis[fr.vtx] = true;
			}
			System.out.println(fr.vtx + " acquired by " + fr.acquiredBy + " for " + fr.w);
			total += fr.w;
			for (int i = 0; i < graph.get(fr.vtx).size(); i++) {
				int ngr = graph.get(fr.vtx).get(i).v;
				int wt = graph.get(fr.vtx).get(i).w;
				if (!vis[ngr]) {
					pq.add(new MSTV(ngr, fr.vtx, wt));
				}
			}
		}
		System.out.println("MST Weight " + total);
	}

	// Kruksal : Union and Find approach, we only do union if parents are not same
	// Algo is to keep on taking edges until we find a cycle
	// so that we can skip that edge and continue processing
	static class KEdge implements Comparable<KEdge> {
		int u;
		int v;
		int w;

		KEdge(int iu, int iv, int iw) {
			this.u = iu;
			this.v = iv;
			this.w = iw;
		}

		@Override
		public int compareTo(KEdge o) {
			return this.w - o.w;
		}
	}

	static void kruksals(ArrayList<ArrayList<Edge>> graph) {
		PriorityQueue<KEdge> pq = new PriorityQueue<>();
		int[] dsp = new int[graph.size()]; // parent array
		int[] dsr = new int[graph.size()]; // rank/size array
		int mst_sum = 0;
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				int ngr = graph.get(i).get(j).v;
				int wt = graph.get(i).get(j).w;
				if (i < ngr) {
					pq.add(new KEdge(i, ngr, wt));
				}
			}
		}
		for (int i = 0; i < graph.size(); i++) {
			dsp[i] = i;
			dsr[i] = 1;
		}
		while (pq.size() > 0) {
			KEdge fr = pq.remove();
			// FIND
			int root1 = find(dsp, fr.u);
			int root2 = find(dsp, fr.v);
			// if both roots are different then merge the leaders
			// as it never forms a cycle when we merge nodes from 2 different trees
			// altho merging 2 nodes with same tree always forms a cycle
			if (root1 != root2) {
				System.out.println(fr.u + " " + fr.v + " " + fr.w);
				mst_sum += fr.w;
				// merge the leaders : UNION
				union(dsp, dsr, root1, root2);
			}
		}
		System.out.println("MST Weight " + mst_sum);
	}

	static void union(int[] dsp, int[] dsr, int r1, int r2) {
		int rank1 = dsr[r1];
		int rank2 = dsr[r2];
		if (rank1 > rank2) {
			dsp[r2] = r1;
		} else if (rank1 == rank2) {
			dsp[r1] += 1;
			dsr[r2] = 0;
			dsp[r1] = r2;
		} else {
			dsp[r1] = r2;
		}
	}

	static int find(int[] dsp, int v) {
		while (dsp[v] != v) {
			dsp[v] = dsp[dsp[v]]; // path compression
			v = dsp[v];
		}
		return v;
	}

	// 13. Eulerian Path and Cycle for Unidirected and Directed Graphs (P5)
	// For Unidirected
	// Euler Path : All edges are visited exactly once
	// Eular Cycle : All edges are visited exactly once but start & end vtx are same
	// Connected Graph is essential
	// or unconnected graph with every component except 1 having 0 vtxs
	// For Eular Path : All vertices have even degree except 0 or 2 (semi eulerian)
	// For Eular Cycle : All vertices have even degree
	static int isEulerian(ArrayList<ArrayList<Edge>> graph) {
		if (isConnected(graph)) {
			return 0;
		}
		// count number of odd vertices
		int odd = 0;
		for (int i = 0; i < graph.size(); i++) {
			if (graph.get(i).size() % 2 == 1) {
				odd += 1;
			}
		}
		if (odd > 2) {
			return 0; // again not eulerian
		}
		return odd == 2 ? 1 : 2; // 1 is not eulerian path and 2 is for eulerian cycle
	}

	// to check whether all non zero degree vertices are connected or not
	static boolean isConnected(ArrayList<ArrayList<Edge>> graph) {
		// algo is : start with a non zero degree vertex
		// then visit all its ngbr nodes
		// in the end check if there is any node that is not visited
		// and has degree more than 0, which would imply it is not connected
		// because that would not form a path
		boolean[] visited = new boolean[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			if (graph.get(i).size() > 0) {
				dfsUtil(graph, visited, i);
				break;
			}
		}
		for (int i = 0; i < graph.size(); i++) {
			if (visited[i] == false && graph.get(i).size() > 0) {
				return false;
			}
		}
		return true;
	}

	static void dfsUtil(ArrayList<ArrayList<Edge>> graph, boolean[] vis, int src) {
		vis[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			int nbr = e.v;
			if (!vis[nbr]) {
				dfsUtil(graph, vis, nbr);
			}
		}
	}

	// Checking it for Directed Graph
	// Indegree equal to outdegree for all vertices
	// all non zero degree vertices belong to a single SCC
	// which can checked using kosaraju

	// 14. Kosaraju for SCC (in Directed Edges) (P5)
	// do dfs like topo sort and fill in the stack
	// reverse the edges of graph and call dfs on each vertex in stack
	// it will print the all components of this directed graph

	// 15. Articulation points and Bridges (P6)

	public static void main(String[] args) {
		int n = 7;
		// Adjacency List Representation
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 1, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 3, 4, 2); // this can be unconnected to get number of cc=2
		addEdge(graph, 4, 5, 8);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);
		// addEdge(graph, 6, 0, 1); --> Added to check hamiltonian cycle
		// Display the graph build
		// display(graph);
		// hasPath
		// System.out.println(hasPath(graph, 2, 4));
		// allPaths
		// printAllPaths(graph, 0, 6);
		// hamiltonian
		// printHamiltonianCycle(graph, 0);
		// System.out.println(bfsShortestPath(graph, 0, 4));
		// getCC(graph);
		// System.out.println(isCyclic(graph));
		// System.out.println(isBipartite(graph));
		// System.out.println(dijkstra(graph, 0, 6));
		// System.out.println(Arrays.toString(topoSortIterative(graph, n)));
		// prims(graph, 0);
		kruksals(graph);
	}

}
