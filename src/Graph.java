import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	public List<Node> nodes;
	public List<Edge> edges;

	public Graph() {
		this.nodes = new ArrayList<>();
		this.edges = new ArrayList<>();
	}

	public void addNodes(int... nodes) {
		Set<Node> noRepet = new HashSet<>(this.nodes);

		for (int node : nodes)
			noRepet.add(new Node(node));
		this.nodes = new ArrayList<>(noRepet);
	}

	// Usage: put three numbers for one edge: 1st is start, 2nd end, 3th weight
	public void addEdges(double... edges) {
		Set<Edge> noRepet = new HashSet<>(this.edges);
		for (int i = 0; i < edges.length; i += 3) {
			Edge edge = new Edge(new Node((int) edges[i]), new Node((int) edges[i + 1]), edges[i + 2]);
			Edge reverseEdge = edge.reverseEdge(edge); // Change between start
														// and end node.
			noRepet.add(edge);
			noRepet.add(reverseEdge); // Not sure if i have to add also the
										// reverse edge

			// Get node from nodes and change the connections to be an edge from
			// start to end
			Node n1 = nodes.get(nodes.indexOf(new Node((int) edges[i])));
			Set<Edge> neighbours1 = new HashSet<>(n1.connections);
			neighbours1.add(edge);
			n1.connections = new ArrayList<>(neighbours1);

			Node n2 = nodes.get(nodes.indexOf(new Node((int) edges[i + 1])));
			Set<Edge> neighbours2 = new HashSet<>(n2.connections);
			neighbours2.add(reverseEdge);
			n2.connections = new ArrayList<>(neighbours2);
		}
		this.edges = new ArrayList<>(noRepet);
	}



	@Override
	public String toString() {
		String graphRepresentation = "";
		for (int i = 0; i < nodes.size(); i++) {
			graphRepresentation += "All edges from " + nodes.get(i).value + ":  ";
			for (Edge edge : nodes.get(i).connections) {
				if (edge.weight != Integer.MAX_VALUE)
					graphRepresentation += edge + ", ";
			}
			graphRepresentation += "\n";
		}
		return graphRepresentation;
	}

}
