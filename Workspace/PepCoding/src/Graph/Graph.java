package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {

	static class Edge {
		int o;
		int n;
		int wt;

		Edge(int v1, int v2, int wt) {
			this.o = v1;
			this.n = v2;
			this.wt = wt;
		}
	}

	public static void addEdge(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int edge) {
		graph.get(v1).add(new Edge(v1, v2, edge));
		graph.get(v2).add(new Edge(v2, v1, edge));
	}

	public static void display(ArrayList<ArrayList<Edge>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print(i + " -> ");
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print("[" + graph.get(i).get(j).o + ",");
				System.out.print(graph.get(i).get(j).n + ",");
				System.out.print(graph.get(i).get(j).wt + "],");
			}
			System.out.println("END");
		}
	}

	public static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		HashSet<Integer> hmap = new HashSet<>();
		return hasPathHelper(graph, src, dest, hmap);
	}

	public static boolean hasPathHelper(ArrayList<ArrayList<Edge>> graph, int src, int dest, HashSet<Integer> hmap) {
		boolean isPresent = false;
		hmap.add(src);
		if (src == dest) {
			return true;
		}
		/*
		 * for (int i = 0; i < graph.get(src).size(); i++) { if (graph.get(src).get(i).n
		 * == dest) { return true; } }
		 */
		for (int i = 0; i < graph.get(src).size(); i++) {
			if (!hmap.contains(graph.get(src).get(i).n)) {
				isPresent = hasPath(graph, graph.get(src).get(i).n, dest);
				if (isPresent) {
					return true;
				}
			}
		}
		return isPresent;
	}

	public static boolean hasPathGraph(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		ArrayList<Integer> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(0);
		}
		return hasPathGraphHelper(graph, src, dest, visited);
	}

	private static boolean hasPathGraphHelper(ArrayList<ArrayList<Edge>> graph, int src, int dest,
			ArrayList<Integer> visited) {
		if (src == dest) { // checking
			return true;
		}
		visited.set(src, 1); // marking
		for (int i = 0; i < graph.get(src).size(); i++) {
			int nghbr = graph.get(src).get(i).n;
			if (visited.get(nghbr) == 0) {
				if (hasPathGraphHelper(graph, nghbr, dest, visited)) {
					return true;
				}
			}

		}
		return false;
	}

	public static void printAllPaths(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		printHelper(graph, src, dest, visited, "");
	}

	private static void printHelper(ArrayList<ArrayList<Edge>> graph, int src, int dest, ArrayList<Boolean> visited,
			String path) {

		if (src == dest) {

			System.out.println(path + " " + dest);
			return;
		}
		visited.set(src, true);

		for (int i = 0; i < graph.get(src).size(); i++) {
			int nghbr = graph.get(src).get(i).n;
			if (visited.get(nghbr) == false) {
				printHelper(graph, nghbr, dest, visited, path + " " + src);
			}
		}
		visited.set(src, false);
	}

	static class Pair {
		String path;
		int weight;

		Pair(String ip, int iw) {
			this.path = ip;
			this.weight = iw;
		}
	}

	// _Playing with path of graph from source to destination

	static ArrayList<Pair> pathWeights = null;

	public static Pair slPath(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		pathWeights = new ArrayList<>();
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		slHelper(graph, src, dest, visited, "", 0);
		Collections.sort(pathWeights, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.weight < o2.weight) {
					return -1;
				} else if (o1.weight > o2.weight) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		for (int i = 0; i < pathWeights.size(); i++) {
			System.out.println(pathWeights.get(i).path + " : " + pathWeights.get(i).weight);
		}
		return pathWeights.get(0);
	}

	private static void slHelper(ArrayList<ArrayList<Edge>> graph, int src, int dest, ArrayList<Boolean> visited,
			String path, int sum) {

		if (src == dest) {
			Pair p = new Pair(path + " " + dest, sum);
			pathWeights.add(p);
			return;
		}
		visited.set(src, true);
		for (int i = 0; i < graph.get(src).size(); i++) {
			int n = graph.get(src).get(i).n;
			if (visited.get(n) == false) {
				slHelper(graph, n, dest, visited, path + " " + src, sum + graph.get(src).get(i).wt);
			}
		}
		visited.set(src, false);
	}

	public static int ceil(ArrayList<ArrayList<Edge>> graph, int src, int dest, int val) {
		pathWeights = new ArrayList<>();
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		slHelper(graph, src, dest, visited, "", 0);
		Collections.sort(pathWeights, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.weight < o2.weight) {
					return -1;
				} else if (o1.weight > o2.weight) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		int ans = pathWeights.get(0).weight;
		for (int i = 0; i < pathWeights.size(); i++) {
			int wt = pathWeights.get(i).weight;
			if (pathWeights.get(i).weight > val) {
				ans = wt;
				break;
			}
		}
		return ans;
	}

	public static int floor(ArrayList<ArrayList<Edge>> graph, int src, int dest, int val) {
		pathWeights = new ArrayList<>();
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		slHelper(graph, src, dest, visited, "", 0);
		Collections.sort(pathWeights, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.weight < o2.weight) {
					return -1;
				} else if (o1.weight > o2.weight) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		int ans = pathWeights.get(0).weight;
		for (int i = 0; i < pathWeights.size(); i++) {
			int wt = pathWeights.get(i).weight;
			if (pathWeights.get(i).weight < val) {
				ans = wt;
			} else {
				break;
			}
		}
		return ans;
	}

	// _Hamiltonian path and cycle
	static int v = 0;

	public static void hamiltonianPC(ArrayList<ArrayList<Edge>> graph, int src) {
		ArrayList<Boolean> visited = new ArrayList<>();
		int count = 0;
		v = src;
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		hamhelper(graph, src, visited, count, "");
	}

	private static void hamhelper(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Boolean> visited, int count,
			String path) {
		if (count == graph.size() - 1) {
			System.out.print(path + " " + src);
			for (int i = 0; i < graph.get(src).size(); i++) {
				if (graph.get(src).get(i).n == v) {
					System.out.print("*");
				}
			}
			System.out.println();
			return;
		}
		visited.set(src, true);
		for (int i = 0; i < graph.get(src).size(); i++) {
			int n = graph.get(src).get(i).n;
			if (visited.get(n) == false) {
				hamhelper(graph, graph.get(src).get(i).n, visited, count + 1, path + " " + src);
			}
		}
		visited.set(src, false);
	}

	// Pro-active because I am not going out of bounds in any case
	public static int countBurntProactive(int[][] arr, int r, int c) {
		return cbHelperProactive(arr, r, c);
	}

	private static int cbHelperProactive(int[][] arr, int r, int c) {
		int count = 0;
		if (arr[r][c] == 0) {
			arr[r][c] = 1;
			count += 1;
			// Go Top
			if ((r - 1) >= 0) {
				count += cbHelperProactive(arr, r - 1, c);
			}
			// Go Left
			if ((c - 1) >= 0) {
				count += cbHelperProactive(arr, r, c - 1);
			}
			// Go Down
			if ((r + 1) <= arr.length - 1) {
				count += cbHelperProactive(arr, r + 1, c);
			}
			// Go Right
			if ((c + 1) <= arr[0].length - 1) {
				count += cbHelperProactive(arr, r, c + 1);
			}
		}

		return count;
	}

	// Reactive because I am going out of bounds in any case
	public static int countBurntReactive(int[][] arr, int r, int c) {
		return cbHelperReactive(arr, r, c);
	}

	private static int cbHelperReactive(int[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr.length) {
			return 0;
		}
		int count = 0;
		if (arr[r][c] == 0) {
			arr[r][c] = 1;
			count += 1;
			// Go Top
			count += cbHelperReactive(arr, r - 1, c);
			// Go Left
			count += cbHelperReactive(arr, r, c - 1);
			// Go Down
			count += cbHelperReactive(arr, r + 1, c);
			// Go Right
			count += cbHelperReactive(arr, r, c + 1);
		}
		return count;
	}

	static int total = 0;

	public static int knightstour(int n) {
		total = 0;

		ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
		Integer[] arr = new Integer[n];
		Arrays.fill(arr, 0);
		for (int i = 0; i < n; i++) {
			maze.add(new ArrayList<>(Arrays.asList(arr)));
		}

		ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();
		Boolean[] isPresent = new Boolean[n];
		Arrays.fill(isPresent, false);

		for (int i = 0; i < n; i++) {
			visited.add(new ArrayList<>(Arrays.asList(isPresent)));
		}
		knightstourHelper(maze, visited, 0, 0, 1);
		return total;
	}

	private static void knightstourHelper(ArrayList<ArrayList<Integer>> maze, ArrayList<ArrayList<Boolean>> visited,
			int r, int c, int move) {
		if (r < 0 || c < 0 || r >= maze.size() || c >= maze.get(0).size() || visited.get(r).get(c) == true) {
			return;
		}
		if (move == maze.size() * maze.size()) {
			total += 1;
			maze.get(r).set(c, move);
			for (int i = 0; i < maze.size(); i++) {
				for (int j = 0; j < maze.size(); j++) {
					System.out.print(maze.get(i).get(j) + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		// Node_pre
		visited.get(r).set(c, true);
		maze.get(r).set(c, move);
		knightstourHelper(maze, visited, r + 2, c + 1, move + 1);
		knightstourHelper(maze, visited, r + 1, c + 2, move + 1);
		knightstourHelper(maze, visited, r - 2, c + 1, move + 1);
		knightstourHelper(maze, visited, r - 1, c + 2, move + 1);
		knightstourHelper(maze, visited, r + 2, c - 1, move + 1);
		knightstourHelper(maze, visited, r + 1, c - 2, move + 1);
		knightstourHelper(maze, visited, r - 2, c - 1, move + 1);
		knightstourHelper(maze, visited, r - 1, c - 2, move + 1);
		// Node_post
		visited.get(r).set(c, false);
	}

	static class Traversal {
		int vtx;
		String psf;
		int dsf;

		Traversal(int iv, String p, int id) {
			this.vtx = iv;
			this.psf = p;
			this.dsf = id;
		}

	}

	// BFS for Shortest path , better than DFS for shortest path
	// because DFS works in 0(v^v) in worst case
	public static boolean bfsShortestPath(ArrayList<ArrayList<Edge>> graph, int src, int dest) {

		LinkedList<Traversal> queue = new LinkedList<Traversal>();
		queue.add(new Traversal(src, src + "", 0));

		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		while (!queue.isEmpty()) {
			Traversal front = queue.getFirst();
			queue.removeFirst();
			// System.out.print(front.vtx + " ");
			if (visited.get(front.vtx) == true) {
				continue;
			} else {
				visited.set(front.vtx, true);
			}
			if (front.vtx == dest) {
				System.out.print(front.psf);
				return true;
			}
			for (int i = 0; i < graph.get(front.vtx).size(); i++) {
				Edge e = graph.get(front.vtx).get(i);
				int n = e.n;
				if (visited.get(n) == false) {
					queue.addLast(new Traversal(n, front.psf + " " + n, front.dsf + e.wt));
				}
			}

		}
		return false;
	}

	static class TraversalLW {
		int vtx;
		String psf;
		int dsf;
		int depth;

		TraversalLW(int iv, String p, int id, int depth) {
			this.vtx = iv;
			this.psf = p;
			this.dsf = id;
			this.depth = depth;
		}

	}

	public static void bfsLW(ArrayList<ArrayList<Edge>> graph, int src) {
		LinkedList<TraversalLW> queue = new LinkedList<>();
		queue.addLast(new TraversalLW(src, "", 0, 0));
		// queue.addLast(null);

		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}

		int currentDepth = 0;
		while (!queue.isEmpty()) {
			TraversalLW front = queue.getFirst();
			queue.removeFirst();

			if (currentDepth != front.depth) {
				System.out.println();
				currentDepth = front.depth;
			}

			if (visited.get(front.vtx) == false) {
				System.out.print(front.vtx + " ");
			}

			visited.set(front.vtx, true);

			/*
			 * if (front == null) { if (queue.size() == 0) { break; } System.out.println();
			 * queue.addLast(null); continue; }
			 */

			for (int i = 0; i < graph.get(front.vtx).size(); i++) {
				Edge e = graph.get(front.vtx).get(i);
				int n = e.n;
				if (visited.get(n) == false) {
					queue.addLast(new TraversalLW(n, front.psf + " " + n, front.dsf + e.wt, front.depth + 1));
				}
			}
		}
	}

	// Reverse Euler using Stack
	public static boolean dfsi(ArrayList<ArrayList<Edge>> graph, int src, int dest) {

		LinkedList<Traversal> stack = new LinkedList<Traversal>();
		stack.add(new Traversal(src, src + "", 0));

		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		while (!stack.isEmpty()) {
			Traversal front = stack.getFirst();
			stack.removeFirst();
			// System.out.print(front.vtx + " ");
			if (visited.get(front.vtx) == true) {
				continue;
			} else {
				visited.set(front.vtx, true);
			}
			if (front.vtx == dest) {
				System.out.print(front.psf);
				return true;
			}
			for (int i = 0; i < graph.get(front.vtx).size(); i++) {
				Edge e = graph.get(front.vtx).get(i);
				int n = e.n;
				if (visited.get(n) == false) {
					stack.addFirst(new Traversal(n, front.psf + " " + n, front.dsf + e.wt));
				}
			}

		}
		return false;
	}

	public static ArrayList<ArrayList<Integer>> getCC(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<ArrayList<Integer>> components = new ArrayList<>();
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		// Checking for all the components
		ArrayList<Integer> singleComponent = null;
		for (int i = 0; i < graph.size(); i++) {
			singleComponent = new ArrayList<>();
			if (visited.get(i) == false) {
				singleComponent = getCCHelper(graph, i, visited);
				components.add(singleComponent);
			}
		}
		System.out.println(components);
		return components;
	}

	private static ArrayList<Integer> getCCHelper(ArrayList<ArrayList<Edge>> graph, int src,
			ArrayList<Boolean> visited) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(src);
		ArrayList<Integer> component = new ArrayList<>();
		while (!queue.isEmpty()) {
			Integer front = queue.getFirst();
			queue.removeFirst();
			if (visited.get(front) == true) {
				continue;
			} else {
				visited.set(front, true);
			}
			component.add(front);
			for (int i = 0; i < graph.get(front).size(); i++) {
				int nbr = graph.get(front).get(i).n;
				if (visited.get(nbr) == false) {
					queue.addLast(nbr);
				}
			}
		}
		return component;
	}

	public static boolean isConnected(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<Integer> component = new ArrayList<>();
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		for (int i = 0; i < graph.size(); i++) {
			if (visited.get(i) == false) {
				component = getCCHelper(graph, i, visited);
				if (component.size() == graph.size()) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public static boolean isCyclic(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		Boolean isCyc = false;
		// Checking for all the components
		for (int i = 0; i < graph.size(); i++) {
			if (visited.get(i) == false) {
				isCyc = cyclicHelper(graph, i, visited);
				if (isCyc) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean cyclicHelper(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Boolean> visited) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(src);
		ArrayList<Integer> component = new ArrayList<>();
		while (!queue.isEmpty()) {
			Integer front = queue.getFirst();
			queue.removeFirst();
			if (visited.get(front) == true) {
				return true;
			} else {
				visited.set(front, true);
			}
			component.add(front);
			for (int i = 0; i < graph.get(front).size(); i++) {
				int nbr = graph.get(front).get(i).n;
				if (visited.get(nbr) == false) {
					queue.addLast(nbr);
				}
			}
		}
		return false;
	}

	public static void gccTweaked(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<ArrayList<Integer>> components = new ArrayList<>();
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		// Checking for all the components
		ArrayList<Integer> singleComponent = null;
		for (int i = 0; i < graph.size(); i++) {
			singleComponent = new ArrayList<>();
			if (visited.get(i) == false) {
				getCCTweakedHelper(graph, i, visited, singleComponent);
				components.add(singleComponent);
			}
		}
		System.out.println(components);
	}

	private static void getCCTweakedHelper(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Boolean> visited,
			ArrayList<Integer> comp) {

		visited.set(src, true);
		for (int i = graph.get(src).size() - 1; i >= 0; i--) {
			int n = graph.get(src).get(i).n;
			if (visited.get(n) == false) {
				getCCTweakedHelper(graph, n, visited, comp);
			}
		}
		comp.add(src);
	}

	public static boolean isBipartite(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<String> RBY = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			RBY.add("Y");
		}
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		for (int i = 0; i < graph.size(); i++) {
			if (visited.get(i) == false) {
				RBY.set(i, "R");
				if (bipartiteHelper(graph, visited, RBY, i) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean bipartiteHelper(ArrayList<ArrayList<Edge>> graph, ArrayList<Boolean> visited,
			ArrayList<String> RBY, int src) {
		visited.set(src, true);
		for (int i = 0; i < graph.get(src).size(); i++) {
			int n = graph.get(src).get(i).n;
			if (visited.get(n) == true) {
				if (RBY.get(src) == RBY.get(n)) {
					return false;
				}
			} else if (visited.get(n) == false) {
				if (RBY.get(src).equals("R")) {
					RBY.set(n, "B");
				} else if (RBY.get(src).equals("B")) {
					RBY.set(n, "R");
				}
				bipartiteHelper(graph, visited, RBY, n);
			}
		}
		return true;
	}

	public static boolean isBi(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<Integer> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(0);
		}
		for (int i = 0; i < graph.size(); i++) {
			if (visited.get(i) == 0) {
				if (isBiHelper(graph, visited, i) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isBiHelper(ArrayList<ArrayList<Edge>> graph, ArrayList<Integer> visited, int src) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(src);
		queue.addLast(null);
		int level = 1;
		while (!queue.isEmpty()) {
			// Get
			Integer front = queue.getFirst();
			// Remove
			queue.removeFirst();
			// Work
			if (front == null) {
				level++;
				if (queue.size() > 0) {
					queue.addLast(null);
				}
				continue; // If size becomes 0 then don't add another NULL
			}
			if (visited.get(front) == 0) {
				visited.set(front, level);
			} else {
				if (level % 2 == 0 && visited.get(front) % 2 == 1) {
					return false;
				}
				if (level % 2 == 1 && visited.get(front) % 2 == 0) {
					return false;
				}
			}
			// Add neighbors
			for (int i = 0; i < graph.get(front).size(); i++) {
				int n = graph.get(front).get(i).n;
				if (visited.get(n) == 0) {
					queue.addLast(n);
				}
			}
		}
		return true;
	}

	// SSSP : Dijkstra
	// Compares Cumulative sum
	public static class DJ implements Comparable<DJ> {
		int vertex;
		String path;
		int dsf;

		DJ(int iv, String ip, int id) {
			this.vertex = iv;
			this.path = ip;
			this.dsf = id;
		}

		@Override
		public int compareTo(DJ other) {
			if (this.dsf < other.dsf) {
				return -1;
			} else if (this.dsf > other.dsf) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void dijkstra(ArrayList<ArrayList<Edge>> graph, int src) {
		PriorityQueue<DJ> pq = new PriorityQueue<>();
		pq.add(new DJ(src, src + "", 0));
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}

		while (pq.size() > 0) {
			// Get
			DJ current = pq.peek(); // O(1)
			// Remove
			pq.remove(); // O(log(V))
			// Mark
			if (visited.get(current.vertex) == true) {
				continue;
			} else {
				visited.set(current.vertex, true);
			}
			// Work
			System.out.println(current.vertex + " via " + current.path + " @ " + current.dsf);
			// Add Neighbors
			for (int i = 0; i < graph.get(current.vertex).size(); i++) {
				int n = graph.get(current.vertex).get(i).n;
				int edgeWt = graph.get(current.vertex).get(i).wt;
				if (visited.get(n) == false) {
					pq.add(new DJ(n, current.path + n, current.dsf + edgeWt)); // O(log(V))
				}
			}
		}
	}

	// MST : Compares Local Edges
	static class MSTV implements Comparable<MSTV> {
		int vertex;
		String acquiredByEdge;
		int wt;

		MSTV(int iv, String acqedge, int id) {
			this.vertex = iv;
			this.wt = id;
			this.acquiredByEdge = acqedge;
		}

		@Override
		public int compareTo(MSTV other) {
			if (this.wt < other.wt) {
				return -1;
			} else if (this.wt > other.wt) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static int MST(ArrayList<ArrayList<Edge>> graph, int src) {
		PriorityQueue<MSTV> pq = new PriorityQueue<>();
		pq.add(new MSTV(src, "Source vertex", 0));
		boolean visited[] = new boolean[graph.size()];
		int MST_WT = 0;
		while (pq.size() > 0) {
			// Get
			MSTV current = pq.peek();
			// Remove
			pq.remove();
			// Mark
			if (visited[current.vertex] == true) {
				continue;
			} else {
				visited[current.vertex] = true;
			}
			// Work
			MST_WT += current.wt;
			System.out.println(current.vertex + " " + current.acquiredByEdge + " " + current.wt);
			// Add neighbors
			for (int i = 0; i < graph.get(current.vertex).size(); i++) {
				Edge e = graph.get(current.vertex).get(i);
				int n = e.n;
				int edgeWt = e.wt;
				if (visited[n] == false) {
					pq.add(new MSTV(n, "Edge acquired by : " + current.vertex, edgeWt));
				}
			}
		}
		return MST_WT;
	}

	// Journey to the Moon - HackerEarth
	public static int numTeams(int n, ArrayList<Integer> p1, ArrayList<Integer> p2) {
		ArrayList<ArrayList<Edge>> countries = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			countries.add(new ArrayList<>());
		}
		for (int i = 0; i < p1.size(); i++) {
			addEdge(countries, p1.get(i), p2.get(i), 0);
		}
		ArrayList<ArrayList<Integer>> gcc = getCC(countries);
		int total = 0;
		for (int i = 0; i < gcc.size(); i++) {
			for (int j = i + 1; j < gcc.size(); j++) {
				int current = gcc.get(i).size();
				current *= gcc.get(j).size();
				total += current;
				current = gcc.get(i).size();
			}
		}
		return total;
	}

	static class KEdge implements Comparable<KEdge> {
		int v1;
		int v2;
		int wt;

		KEdge(int iv1, int iv2, int iwt) {
			this.v1 = iv1;
			this.v2 = iv2;
			this.wt = iwt;
		}

		@Override
		public int compareTo(KEdge other) {
			return this.wt - other.wt;
			/*
			 * if (this.wt < other.wt) { return -1; } else if (this.wt > other.wt) { return
			 * 1; } else { return 0; }
			 */
		}
	}

	public static int kruksals(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<ArrayList<Edge>> mst = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			mst.add(new ArrayList<Edge>());
		}
		PriorityQueue<KEdge> pq = new PriorityQueue<>();
		int[] dsp = new int[graph.size()];
		int[] dsr = new int[graph.size()];
		int mst_sum = 0;
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				Edge e = graph.get(i).get(j);
				if (e.o < e.n) {
					KEdge ke = new KEdge(e.o, e.n, e.wt);
					pq.add(ke);
				}
			}
		}
		for (int i = 0; i < graph.size(); i++) {
			dsp[i] = i;
			dsr[i] = 1;
		}
		while (pq.size() > 0) {
			// Get
			KEdge ke = pq.peek();
			// Remove
			pq.remove();
			// Get leaders
			int v1sl = find(dsp, ke.v1);
			int v2sl = find(dsp, ke.v2);
			// Merge if different leaders
			if (v1sl != v2sl) {
				addEdge(mst, ke.v1, ke.v2, ke.wt);
				merge(dsp, dsr, v1sl, v2sl);
				mst_sum += ke.wt;
			}
		}
		display(mst);
		return mst_sum;
	}

	private static int find(int[] dsp, int v1) {
		if (dsp[v1] == v1) {
			return v1;
		}
		int vsl = find(dsp, dsp[v1]);
		dsp[v1] = vsl; // directly connect to the leader , reduces the complexity of n finds
		return vsl;
	}

	private static void merge(int[] dsp, int[] dsr, int v1sl, int v2sl) {
		int rankv1 = dsr[v1sl];
		int rankv2 = dsr[v2sl];
		if (rankv1 > rankv2) {
			dsp[v2sl] = v1sl;
		} else if (rankv1 == rankv2) {
			dsr[v1sl] += 1;
			dsr[v2sl] = 0;
			dsp[v2sl] = v1sl;
		} else if (rankv1 < rankv2) {
			dsp[v1sl] = v2sl;
		}
	}

	// Job Sequencing

	static class Job implements Comparable<Job> {
		char name;
		int dl;
		int profit;

		Job(char iname, int idl, int ipr) {
			this.name = iname;
			this.dl = idl;
			this.profit = ipr;
		}

		@Override
		public int compareTo(Job other) {
			if (this.profit < other.profit) {
				return 1;
			} else if (this.profit > other.profit) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public static void jobSequencing(String jobs, ArrayList<Integer> dls, ArrayList<Integer> profits) {
		PriorityQueue<Job> pq = new PriorityQueue<>();
		int maxDl = 0;
		for (int i = 0; i < dls.size(); i++) {
			pq.add(new Job(jobs.charAt(i), dls.get(i), profits.get(i)));
			maxDl = Math.max(maxDl, dls.get(i));
		}
		int[] dsp = new int[maxDl + 1]; // parent is Deadline day
		int[] dsr = new int[maxDl + 1];
		char[] ans = new char[maxDl + 1];
		for (int i = 0; i < dsp.length; i++) {
			dsp[i] = i;
			dsr[i] = 1;
		}
		while (!pq.isEmpty()) {
			// Get
			Job job = pq.peek();
			// Remove
			pq.remove();
			// Find
			int parentJobDeadline = find_parent(dsp, job.dl);
			// If both are same
			if (parentJobDeadline > 0) {
				// Do this job
				System.out.println(job.name + " : " + job.profit);
				ans[parentJobDeadline] = job.name;
				merge_parent(dsp, parentJobDeadline);
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	private static int find_parent(int[] dsp, int jdl) {
		if (dsp[jdl] == jdl) {
			return jdl;
		} else {
			int jpdl = find_parent(dsp, dsp[jdl]);
			dsp[jdl] = jpdl;
			return jpdl;
		}
	}

	private static void merge_parent(int[] dsp, int pjb) {
		int newParent = find_parent(dsp, pjb - 1);
		dsp[pjb] = newParent;
	}

	// Articulation points and Bridges in Graph
	static int mytime = 0;

	public static void apoints(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<Integer> acps = new ArrayList<>();
		ArrayList<Integer> discovery = new ArrayList<>();
		ArrayList<Integer> low = new ArrayList<>();
		boolean[] visited = new boolean[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			discovery.add(0);
		}
		for (int i = 0; i < graph.size(); i++) {
			low.add(Integer.MAX_VALUE);
		}
		int src = 0;
		int parent = -1; // Doesn't matter for the source node
		apbridge(graph, discovery, low, visited, acps, parent, src);
		System.out.println(acps);
	}

	private static void apbridge(ArrayList<ArrayList<Edge>> graph, ArrayList<Integer> discovery, ArrayList<Integer> low,
			boolean[] visited, ArrayList<Integer> acps, int parent, int src) {
		mytime++;
		discovery.set(src, mytime);
		low.set(src, mytime);
		int counter = 0;
		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			int nbr = e.n;
			if (visited[nbr] == true && nbr == parent) {
				// Do Nothing
			} else if (visited[nbr] == true && nbr != parent) {
				low.set(src, Math.min(low.get(src), discovery.get(nbr)));
			} else {
				counter++;
				apbridge(graph, discovery, low, visited, acps, src, nbr);
				low.set(src, Math.min(low.get(nbr), low.get(src)));
				if (discovery.get(src) == 1) {
					if (counter >= 2) {
						acps.add(src);
					}
				} else {
					if (low.get(nbr) >= discovery.get(src)) {
						acps.add(src);
					}
					if (low.get(nbr) > discovery.get(src)) {
						System.out.println("Bridge from " + src + " to " + nbr);
					}
				}
			}
		}
	}

	// Topological Sort
	static Stack<Integer> linearOrder = null;

	public static void topologicalSort(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			visited.add(false);
		}
		linearOrder = new Stack<>();
		// Checking for all the components
		for (int i = 0; i < graph.size(); i++) {
			if (visited.get(i) == false) {
				topologicalHelper(graph, i, visited);
			}
		}
		while (!linearOrder.isEmpty()) {
			System.out.print(linearOrder.pop() + "->");
		}
		System.out.println("END");
	}

	private static void topologicalHelper(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Boolean> visited) {
		visited.set(src, true);
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			if (visited.get(e.n) == false) {
				topologicalHelper(graph, e.n, visited);
			}
		}
		// Add in linear order in Node Post
		linearOrder.push(src);
	}

	public static void main(String[] args) {
		int n = 7;
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 1, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 0, 2, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		// addEdge(graph, 2, 5, 5);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);
		display(graph);
		apoints(graph);
		// For TS
		/*
		 * addEdge(graph, 0, 1, 10); addEdge(graph, 1, 4, 10); addEdge(graph, 4, 5, 10);
		 * addEdge(graph, 6, 5, 10); addEdge(graph, 3, 6, 10); addEdge(graph, 3, 2, 10);
		 * addEdge(graph, 0, 2, 10); display(graph); topologicalSort(graph);
		 */

		// System.out.println(hasPath(graph, 0, 6));
		// System.out.println(hasPathGraph(graph, 0, 6));
		/*
		 * printAllPaths(graph, 0, 6); System.out.println();
		 * System.out.println(hasPath(graph, 0, 0)); System.out.println();
		 * System.out.println("All Paths and their weights");
		 * System.out.println("Smallest Path's weight  is : " + slPath(graph, 0,
		 * 6).weight); System.out.println(); System.out.println(ceil(graph, 0, 6, 43));
		 * System.out.println(floor(graph, 0, 6, 43)); System.out.println();
		 * hamiltonianPC(graph, 2); System.out.println();
		 */
		int[][] arr = { { 0, 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1, 0 }, { 1, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1, 1 } };
		/*
		 * System.out.println(countBurntProactive(arr, 2, 5));
		 * System.out.println(countBurntReactive(arr, 5, 0)); System.out.println();
		 */
		// System.out.println(knightstour(5));
		System.out.println();
		/*
		 * bfsShortestPath(graph, 0, 5); System.out.println(); dfsi(graph, 0, 5);
		 * System.out.println(); System.out.println(); bfsLW(graph, 0);
		 * System.out.println();
		 */
		/*
		 * ArrayList<ArrayList<Integer>> res = getCC(graph);
		 * System.out.println(isConnected(graph)); System.out.println(isCyclic(graph));
		 * gccTweaked(graph);
		 */
		// System.out.println(isBipartite(graph)); // Coloring method : not working
		/*
		 * System.out.println(isBi(graph)); // Class Code System.out.println();
		 * dijkstra(graph, 0); System.out.println(); System.out.println(MST(graph, 0));
		 * System.out.println(); System.out.println();
		 */

		/*
		 * System.out.println("Journey to the Moon : HackerEarth"); ArrayList<Integer>
		 * p1 = new ArrayList<>(); ArrayList<Integer> p2 = new ArrayList<>(); p1.add(1);
		 * p2.add(2); p1.add(1); p2.add(4); p1.add(3); p2.add(5);
		 * System.out.println(numTeams(6, p1, p2)); System.out.println(kruksals(graph));
		 * String names = "abdecfghijklmnopqrstuv"; Integer[] deadlines = { 4, 2, 3, 1,
		 * 8, 3, 2, 1, 2, 6, 5, 7, 9, 2, 6, 5, 2, 7, 6, 9, 1, 6 }; Integer[] profitss =
		 * { 100, 67, 94, 44, 33, 77, 11, 99, 37, 76, 34, 47, 78, 44, 39, 75, 49, 33,
		 * 48, 92, 43, 90 }; ArrayList<Integer> dl = new
		 * ArrayList<>(Arrays.asList(deadlines)); ArrayList<Integer> profits = new
		 * ArrayList<>(Arrays.asList(profitss)); jobSequencing(names, dl, profits);
		 * apoints(graph);
		 */
	}

}
