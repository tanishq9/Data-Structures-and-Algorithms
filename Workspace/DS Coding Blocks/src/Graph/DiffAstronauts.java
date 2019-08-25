package Graph;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class DiffAstronauts {
	private class Vertex {

		HashMap<Integer, Integer> nbrs = new HashMap<>();

		Vertex() {
			this.nbrs = new HashMap<>();
		}
	}

	HashMap<Integer, Vertex> vertices;

	DiffAstronauts() {
		this.vertices = new HashMap<>();
	}

	public void addVertex(Integer data) {
		Vertex v = new Vertex();
		this.vertices.put(data, v);
	}

	public Boolean containsVertex(Integer i) {
		return this.vertices.containsKey(i);
	}

	public void addEdge(Integer vname1, Integer vname2) {
		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);
		if (v1.nbrs.containsKey(v2) || v1 == null || v2 == null) {
			return;// null meaning node has not been initialized
		}
		v1.nbrs.put(vname2, 1);
		v2.nbrs.put(vname1, 1);
	}

	public boolean containsEdge(Integer one, Integer two) {
		Vertex v1 = this.vertices.get(one);
		Vertex v2 = this.vertices.get(two);
		if (!v1.nbrs.containsKey(two) || v1 == null || v2 == null) {
			return false;
		} // null meaning that there is no such vertex
		return true;
	}

	public int dfs() {
		HashMap<Integer, Boolean> explored = new HashMap<>();
		for (Integer i : this.vertices.keySet()) {
			explored.put(i, false);
		}
		// Now iterate over all the elements of the vertices map
		Set<Integer> s = this.vertices.keySet();
		int total_unfav_cases = 0;
		for (Integer i : s) {
			if (explored.get(i) == false) {
				int country_contri = dfshelper(i, explored);
				System.out.println(country_contri);
				total_unfav_cases += (country_contri * (country_contri - 1)) / 2;
			}
		}
		return total_unfav_cases;
	}

	private int dfshelper(Integer i, HashMap<Integer, Boolean> explored) {
		if (this.vertices.get(i).nbrs.size() == 0) {
			return 1;
		}
		int rv = 0;
		explored.put(i, true);
		Set<Integer> s = this.vertices.get(i).nbrs.keySet();
		for (Integer nbr : s) {
			if (explored.get(nbr) == false) {
				int nbrsize = dfshelper(nbr, explored);
				rv += nbrsize;// this is the wo
			}
		}
		return rv + 1;
	}

	public void display() {
		Set<Integer> s = this.vertices.keySet();
		for (Integer v : s) {
			System.out.println(v + " : " + this.vertices.get(v).nbrs);
			// by using this.vertices.get(v),we can access a hashmap
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DiffAstronauts graph = new DiffAstronauts();
		int n = 5;
		for (int i = 0; i < n; i++) {
			graph.addVertex(i);
		}
		int n1, n2, m = 3;// no of given pairs
		for (int i = 0; i < m; i++) {
			n1 = scanner.nextInt();
			n2 = scanner.nextInt();
			graph.addEdge(n1, n2);
		}
		// graph.display();
		System.out.println(10 - graph.dfs());
	}
}
