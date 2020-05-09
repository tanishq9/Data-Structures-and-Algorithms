package Graph;

import java.util.*;

public class killCaptAmerica {

	public static ArrayList<Integer> graph[];
	public static ArrayList<Integer> graphT[];
	public static int size;

	public static void createGraph(int n) {
		graph = new ArrayList[n];
		graphT = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
			graphT[i] = new ArrayList<Integer>();
		}
		size = n;
	}

	public static void addEdge(int u, int v) {
		graph[u].add(v);
		graphT[v].add(u);
	}

	public static void DFS(int u, Stack<Integer> order, HashSet<Integer> visited) {
		visited.add(u);
		for (int v : graph[u])
			if (!visited.contains(v))
				DFS(v, order, visited);
		order.push(u);
	}

	public static void DFST(int so, HashSet<Integer> visited, HashSet<HashSet<Integer>> scc) {
		Stack<Integer> stack = new Stack<>();
		HashSet<Integer> sc = new HashSet<>();
		visited.add(so);
		stack.push(so);
		sc.add(so);
		while (!stack.isEmpty()) {
			int u = stack.pop();
			for (int v : graphT[u]) {
				if (!visited.contains(v)) {
					visited.add(v);
					sc.add(v);
					stack.push(v);
				}
			}
		}
		scc.add(sc);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			createGraph(n);
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				addEdge(u, v);
			}
			HashSet<HashSet<Integer>> scc = new HashSet<>();
			Stack<Integer> order = new Stack<>();
			HashSet<Integer> visited = new HashSet<>();
			for (int i = 0; i < n; i++)
				if (!visited.contains(i))
					DFS(i, order, visited);
			// DFS on transpose
			visited = new HashSet<>();
			System.out.println(order);
			while (!order.isEmpty()) {
				int u = order.pop();
				if (!visited.contains(u))
					DFST(u, visited, scc);
			}
			System.out.println(scc);

			HashMap<Integer, Integer> map = new HashMap<>();
			HashMap<Integer, Integer> com = new HashMap<>();
			HashMap<Integer, HashSet<Integer>> sgraph = new HashMap<>();
			for (HashSet<Integer> set : scc) {
				int rep = -1;
				for (int i : set) {
					if (rep == -1) {
						rep = i;
						com.put(rep, set.size());
						sgraph.put(rep, new HashSet<Integer>());
					}
					map.put(i, rep);
				}
			}

			// 1 5 5 1 2 2 3 3 4 4 3 5 4
			// 1 7 6 1 2 3 2 4 3 5 4 5 6 6 7
			System.out.println();
			System.out.println(map);
			System.out.println(com);
			System.out.println(sgraph);
			System.out.println();
			for (int i = 0; i < size; i++) {
				for (int j : graph[i]) {
					if (!sgraph.containsKey(map.get(i)))
						sgraph.put(map.get(i), new HashSet<Integer>());
					if (map.get(i) != map.get(j))
						sgraph.get(map.get(i)).add(map.get(j));
				}
			}

			System.out.println(sgraph);
			System.out.println();
			int cnt = 0;
			int flag = 0;
			for (int i : sgraph.keySet()) {
				System.out.println(sgraph.get(i));
				if (sgraph.get(i).size() == 0) {
					cnt += com.get(i);
					flag++;
				}
			}
			System.out.println();
			if (flag != 1)
				cnt = 0;
			System.out.println(cnt);

		}
	}
}
