import java.util.ArrayList;
import java.util.List;

public class GraphMatrix {

	private class Node {
		public String value;
		public int weight;
		public boolean visited;

		public Node(int value) {
			this.weight = Integer.MAX_VALUE;
			this.visited = false;
		}

		public Node(int weight, boolean visited) {
			this.weight = weight;
			this.visited = visited;
		}

		@Override
		public String toString() {
			return "Edge: "+value+", Weight: " + weight + ", Visited: " + visited;
		}
		
		
	}

	private Node[][] graph;

	public GraphMatrix(int size) {
		this.graph = new Node[size][size];
		for (int i = 0; i < this.graph.length; i++) {
			for (int j = 0; j < this.graph[i].length; j++) {
				this.graph[i][j] = new Node(j);
			}
		}
	}

	public void addEdge(int src, int dst, int weight) {
		this.graph[src][dst] = new Node(weight, false); // There is a connection
														// between the src and
		// dst src -> dst
		this.graph[dst][src] = new Node(weight, false);
		; // dst -> src (it's an undirected graph)
	}

	public List<Node> neighbourNodes(int n) {
		List<Node> neighbours = new ArrayList<>();
		for (int i = 0; i < this.graph.length; i++) {
			if (this.graph[n][i].weight != Integer.MAX_VALUE)
				neighbours.add(this.graph[n][i]);
		}
		return neighbours;
	}

	public void findPath(Node start, Node end) {

	}

	@Override
	public String toString() {
		String graphRepresentation = "";
		for (int i = 0; i < graph.length; i++) {
			graphRepresentation += "All edges from " + i + ":  ";
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j].weight != Integer.MAX_VALUE)
					graphRepresentation += i + " --(" + graph[i][j].weight + ")-> " + j + ", ";
			}
			graphRepresentation += "\n";
		}
		return graphRepresentation;
	}

	// public void

}
