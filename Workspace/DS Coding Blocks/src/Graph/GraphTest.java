package Graph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class GraphTest {
	private class Vertex {
		String name;
		HashMap<Vertex, Integer> neighbors;

		Vertex(String name) {
			this.name = name;
			this.neighbors = new HashMap<>();
		}

		public boolean equals(Object other) {
			Vertex ov = (Vertex) other;
			return this.name.equals(ov.name);
		}

		public int hashCode() {
			return this.name.hashCode();
		}

		public void display() {
			String rv = "";
			rv = rv + this.name + "=>";
			Set<Vertex> nbrs = this.neighbors.keySet();
			for (Vertex nbr : nbrs) {
				rv = rv + nbr.name + "(" + this.neighbors.get(nbr) + "),";
			}
			rv = rv + "END";
			System.out.println(rv);
		}
	}

	private HashMap<String, Vertex> vertices;

	GraphTest() {
		this.vertices = new HashMap<>();
	}

	public int numVertices() {
		return this.vertices.size();
	}

	public void addVertex(String name) {
		if (this.vertices.containsKey(name)) {
			return;
		}

		Vertex vtx = new Vertex(name);
		this.vertices.put(name, vtx);
	}

	public void removeVertex(String name) {
		if (!this.vertices.containsKey(name)) {
			return;
		}

		Vertex vtx = this.vertices.get(name);
		Set<Vertex> nbrs = vtx.neighbors.keySet();
		for (Vertex nbr : nbrs) {
			nbr.neighbors.remove(vtx);
		}

		this.vertices.remove(name);

	}

	public int numEdges() {
		int rv = 0;
		Collection<Vertex> vtces = this.vertices.values();
		for (Vertex vtx : vtces) {
			rv = rv + vtx.neighbors.size();
		}
		rv = rv / 2;
		return rv;
	}

	public void addEdge(String v1, String v2, int weight) {
		Vertex vtx1 = this.vertices.get(v1);
		Vertex vtx2 = this.vertices.get(v2);

		if (vtx1 == null || vtx2 == null || vtx1.neighbors.containsKey(vtx2)) {
			return;
		}

		vtx1.neighbors.put(vtx2, weight);
		vtx2.neighbors.put(vtx1, weight);
	}

	public void removeEdge(String v1, String v2) {
		Vertex vtx1 = this.vertices.get(v1);
		Vertex vtx2 = this.vertices.get(v2);

		if (vtx1 == null || vtx2 == null || !vtx1.neighbors.containsKey(vtx2)) {
			return;
		}

		vtx1.neighbors.remove(vtx2);
		vtx2.neighbors.remove(vtx1);
	}

	public void display() {
		Set<String> vtces = this.vertices.keySet();
		for (String vtxname : vtces) {
			Vertex vtx = this.vertices.get(vtxname);
			vtx.display();
		}
		System.out.println("***************************************");
	}

	public boolean hasPath(String v1, String v2) {
		Vertex vtx1 = this.vertices.get(v1);
		Vertex vtx2 = this.vertices.get(v2);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		return DFSI(vtx1, vtx2, explored);

	}

	private boolean hasPathDFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> explored) {
		if (!explored.containsKey(vtx1)) {
			explored.put(vtx1, true);
		} else {
			return false;
		}
		if (vtx1.neighbors.containsKey(vtx2)) {
			return true;
		}

		Set<Vertex> nbrs = vtx1.neighbors.keySet();
		for (Vertex nbr : nbrs) {
			if (hasPathDFS(nbr, vtx2, explored)) {
				return true;
			}
		}

		return false;

	}

	private boolean hasPathBFSI(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> explored) {
		LinkedList<Vertex> queue = new LinkedList<>();
		queue.add(vtx1);
		while (!queue.isEmpty()) {
			Vertex rvtx = queue.removeFirst();
			if (!explored.containsKey(rvtx)) {
				explored.put(rvtx, true);
				if (rvtx.neighbors.containsKey(vtx2)) {
					return true;
				} else {
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.add(nbr);
						}
					}
				}
			}
		}

		return false;

	}

	private boolean DFSI(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> explored) {
		LinkedList<Vertex> stack = new LinkedList<>();
		stack.addFirst(vtx1);
		while (!stack.isEmpty()) {
			Vertex rvtx = stack.removeFirst();
			if (!explored.containsKey(rvtx)) {
				explored.put(rvtx, true);
				if (rvtx.neighbors.containsKey(vtx2)) {
					return true;
				} else {
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							stack.addFirst(nbr);
						}
					}
				}
			}
		}

		return false;
	}

	public void bft() {
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		Collection<Vertex> vtces = this.vertices.values();
		LinkedList<Vertex> queue = new LinkedList<>();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				queue.add(vtx);
			}
			while (!queue.isEmpty()) {
				Vertex rvtx = queue.removeFirst();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					System.out.println(rvtx.name);
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.add(nbr);
						}
					}

				}
			}
		}
	}

	public void dft() {
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		Collection<Vertex> vtces = this.vertices.values();
		LinkedList<Vertex> stack = new LinkedList<>();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				stack.addFirst(vtx);
			}
			while (!stack.isEmpty()) {
				Vertex rvtx = stack.removeFirst();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					System.out.println(rvtx.name);
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							stack.addFirst(nbr);
						}
					}

				}
			}
		}
	}

	public boolean isConnected() {
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		Collection<Vertex> vtces = this.vertices.values();
		LinkedList<Vertex> queue = new LinkedList<>();
		queue.add((Vertex) vtces.toArray()[0]);
		while (!queue.isEmpty()) {
			Vertex rvtx = queue.removeFirst();
			if (!explored.containsKey(rvtx)) {
				explored.put(rvtx, true);
				System.out.println(rvtx.name);
				Set<Vertex> nbrs = rvtx.neighbors.keySet();
				for (Vertex nbr : nbrs) {
					if (!explored.containsKey(nbr)) {
						queue.add(nbr);
					}
				}

			}
		}
		return this.vertices.size() == explored.size();
	}

	public ArrayList<ArrayList<String>> getCC() {
		ArrayList<ArrayList<String>> rv = new ArrayList<>();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		Collection<Vertex> vtces = this.vertices.values();
		LinkedList<Vertex> queue = new LinkedList<>();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				queue.add(vtx);
			}
			ArrayList<String> cc = new ArrayList<>();
			while (!queue.isEmpty()) {
				Vertex rvtx = queue.removeFirst();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					cc.add(rvtx.name);
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.add(nbr);
						}
					}

				}
			}
			if (cc.size() != 0) {
				rv.add(cc);
			}
		}
		return rv;
	}

	public boolean isBipartite() {
		HashMap<Vertex, String> explored = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Collection<Vertex> vtces = this.vertices.values();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				Pair p = new Pair();
				p.vtx = vtx;
				p.reason = null;
				p.color = "Red";
				stack.addFirst(p);
			}
			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();
				if (!explored.containsKey(rp.vtx)) {
					explored.put(rp.vtx, rp.color);
					Set<Vertex> nbrs = rp.vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							Pair p = new Pair();
							p.vtx = nbr;
							p.reason = rp.vtx;
							p.color = rp.color.equals("Red") ? "Green" : "Red";
							stack.addFirst(p);
						} else {
							String nbrcolor = explored.get(nbr);
							if (nbrcolor.equals(rp.color)) {
								return false;
							}
						}
					}
				}
			}

		}
		return true;

	}

	private class Pair {
		Vertex vtx;
		Vertex reason;
		String color;
	}

}