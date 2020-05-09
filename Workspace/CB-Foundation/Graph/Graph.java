package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs;// and integer here is the distance between a vertex and its neighbor

		Vertex() {
			this.nbrs = new HashMap<>();
		}
	}

	HashMap<String, Vertex> vertices;

	Graph() {
		vertices = new HashMap<>();
	}

	public int numVertex() {
		return this.vertices.size();
	}

	public boolean containsVertex(String v) {
		return this.vertices.containsKey(v);
	}

	public void addVertex(String vname) {
		if (this.vertices.containsKey(vname)) {
			return;
		}
		Vertex v = new Vertex();// v is a reference to an object of class Vertex
		this.vertices.put(vname, v);
	}

	public void removeVertex(String name) {
		if (!this.vertices.containsKey(name)) {
			return;
		}
		Vertex toberemoved = this.vertices.get(name);
		Set<String> set = toberemoved.nbrs.keySet();
		// pehle baaki sab nodes ke nghrs mei se hatado fir vertices vaale se hatado
		for (String s : set) {
			this.vertices.get(s).nbrs.remove(name);
		}
		this.vertices.remove(name);
	}

	public int numEdges() {
		int count = 0;
		Set<String> set = this.vertices.keySet();
		for (String s : set) {
			count += this.vertices.get(s).nbrs.size();
		}
		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {
		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);
		if (v1 == null || v2 == null || !v1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);
		if (v1 == null || v2 == null || v1.nbrs.containsKey(vname2)) {
			return;
		}
		v1.nbrs.put(vname2, cost);
		v2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {
		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);
		if (v1 == null || v2 == null || !v1.nbrs.containsKey(vname2)) {
			return;
		}
		v1.nbrs.remove(vname2);
		v2.nbrs.remove(vname1);
	}

	public void display() {
		Set<String> s = this.vertices.keySet();
		for (String v : s) {
			System.out.println(v + " : " + this.vertices.get(v).nbrs);
			// by using this.vertices.get(v),we can access a hashmap
		}
	}

	public boolean hasPath(String vname1, String vname2) {
		if (this.containsEdge(vname1, vname2)) {
			return true;
		}
		HashMap<String, Boolean> explored = new HashMap<>();
		return hasPath(vname1, vname2, explored);
	}

	private boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> explored) {
		// direct edge
		if (this.containsEdge(vname1, vname2)) {
			return true;
		}
		Vertex v = this.vertices.get(vname1);
		explored.put(vname1, true);
		Set<String> nbrs = v.nbrs.keySet();
		for (String nbr : nbrs) {
			if (!explored.containsKey(nbr) && hasPath(nbr, vname2)) {
				return true;
			}
		}
		return false;
	}

	public void BFS() {
		HashMap<String, Boolean> explored = new HashMap<>();
		LinkedList<String> queue = new LinkedList<>();
		queue.push("A");
		explored.put("A", true);
		while (!queue.isEmpty()) {
			String current = queue.peek();
			System.out.print(current + "->");
			queue.pop();
			Set<String> set = this.vertices.get(current).nbrs.keySet();
			for (String s : set) {
				if (!explored.containsKey(s)) {
					explored.put(s, true);
					queue.add(s);
				}
			}
		}
		System.out.println("END");
	}

	public void DFS() {
		HashMap<String, Boolean> explored = new HashMap<>();
		DFS(explored, "A");
	}

	private void DFS(HashMap<String, Boolean> explored, String string) {
		explored.put(string, true);
		// System.out.print(string + "->");
		Set<String> set = this.vertices.get(string).nbrs.keySet();
		for (String s : set) {
			if (!explored.get(s)) {
				DFS(explored, s);
			}
		}
	}

	public Boolean connected() {
		HashMap<String, Boolean> explored = new HashMap<>();
		Set<String> set = this.vertices.keySet();
		for (String s : set) {
			explored.put(s, false);
		}
		DFS(explored, "A");
		for (String s : set) {
			System.out.println(explored.get(s));
			if (!explored.get(s)) {
				return false;
			}
		}
		return true;
	}

	public int distance(String vname) {
		HashMap<String, Integer> distance = new HashMap<>();
		HashMap<String, Boolean> explored = new HashMap<>();
		distance.put("A", 0);
		explored.put("A", true);
		Set<String> set = this.vertices.keySet();
		LinkedList<String> queue = new LinkedList();
		queue.push("A");
		while (!queue.isEmpty()) {
			String current = queue.peek();
			queue.pop();
			for (String ngbhr : this.vertices.get(current).nbrs.keySet()) {
				if (!explored.containsKey(ngbhr)) {
					explored.put(ngbhr, true);
					distance.put(ngbhr, distance.get(current) + 1);
					queue.push(ngbhr);
				}
			}
		}
		for (String s : distance.keySet()) {
			System.out.print(s + " " + distance.get(s) + ", ");
		}
		return distance.get(vname);
	}

	public Boolean cycleDetection() {
		HashMap<String, String> parent = new HashMap<>();
		parent.put("A", "A");
		HashMap<String, Boolean> explored = new HashMap<>();
		explored.put("A", true);
		LinkedList<String> queue = new LinkedList();
		queue.push("A");
		while (!queue.isEmpty()) {
			String current = queue.peek();
			queue.pop();
			for (String ngbhr : this.vertices.get(current).nbrs.keySet()) {
				if (!explored.containsKey(ngbhr)) {
					explored.put(ngbhr, true);
					queue.push(ngbhr);
					parent.put(ngbhr, current);
				} else if (explored.containsKey(ngbhr) && !parent.get(current).equals(ngbhr)) {
					return true;
				}
			}
		}
		return false;
	}

	public void topologicalSort() {
		HashMap<String, Integer> indegree = new HashMap<>();
		HashMap<String, Boolean> explored = new HashMap<>();
		Set<String> set = this.vertices.keySet();
		for (String s : set) {
			indegree.put(s, 0);
		}
		for (String s : set) {
			for (String nbr : this.vertices.get(s).nbrs.keySet()) {
				indegree.put(nbr, indegree.get(nbr) + 1);
			}
		}
		LinkedList<String> queue = new LinkedList<>();
		for (String s : set) {
			if (indegree.get(s) == 0) {
				queue.push(s);
			}
		}
		while (!queue.isEmpty()) {
			String current = queue.peek();
			queue.pop();
			System.out.print(current + "->");
			for (String s : this.vertices.get(current).nbrs.keySet()) {
				indegree.put(s, indegree.get(s) - 1);
				if (indegree.get(s) == 0) {
					queue.push(s);
				}
			}
		}
		Set<String> s = explored.keySet();
		Set<Map.Entry<String, Boolean>> sp = explored.entrySet();
		for (Map.Entry<String, Boolean> entry : sp) {
			entry.getKey();
			entry.getValue();
		}
		System.out.println("END");
	}

	public Boolean isBipartite(String src) {
		HashMap<String, Integer> color = new HashMap<>();
		Set<String> set = this.vertices.keySet();
		for (String s : set) {
			color.put(s, -1);
		}
		color.put(src, 0);
		LinkedList<String> queue = new LinkedList<>();
		queue.push(src);
		while (!queue.isEmpty()) {
			String current = queue.peek();
			queue.pop();
			Set<String> s = this.vertices.get(current).nbrs.keySet();
			for (String nbr : s) {
				if (color.get(nbr) == -1) {
					color.put(nbr, 1 - color.get(current));
					queue.push(nbr);
				} else if (color.get(nbr) == color.get(current)) {
					return false;
				}
			}
		}
		return true;
	}
}
