package Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

class Graph {
	class Vertex {
		HashMap<String, Integer> nbrs;

		Vertex() {
			this.nbrs = new HashMap<>();
		}
	}

	// key is the name of the vertex and value is the neighbors of the key which is
	// a vertex
	HashMap<String, Vertex> vertices;

	Graph() {
		this.vertices = new HashMap<>();
	}

	public void addVertex(String vname) {
		if (vertices.containsKey(vname)) {
			return;
		}
		Vertex vertex = new Vertex();
		this.vertices.put(vname, vertex);
	}

	public void addEdge(String vname1, String vname2, int dist) {
		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);
		if (v1.nbrs.containsKey(vname2) || v2.nbrs.containsKey(vname1) || v1 == null || v2 == null) {
			return;
		}
		v1.nbrs.put(vname2, dist);
		v2.nbrs.put(vname1, dist);
	}

	public Boolean isBpite(String src) {
		LinkedList<String> queue = new LinkedList<>();
		HashMap<String, Integer> color = new HashMap<>();
		Set<String> s = this.vertices.keySet();
		for (String key : s) {
			color.put(key, -1);
		}
		queue.add(src);
		color.put(src, 0);
		while (!queue.isEmpty()) {
			String poppedNode = queue.getFirst();
			queue.removeFirst();
			Set<String> set = this.vertices.get(poppedNode).nbrs.keySet();
			for (String nghr : set) {
				if (color.get(nghr) == -1) {
					color.put(nghr, 1 - color.get(poppedNode));
					queue.push(nghr);
				} else {
					if (color.get(nghr) == color.get(poppedNode)) {
						return false;
					}
				}
			}
		}
		return true;
	}

}

public class isBipartite {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("0");
		graph.addVertex("1");
		graph.addVertex("2");
		graph.addVertex("3");
		graph.addEdge("0", "1", 10);
		graph.addEdge("0", "2", 10);
		graph.addEdge("1", "3", 10);
		graph.addEdge("1", "3", 10);
		System.out.println(graph.isBpite("0"));
	}

}
