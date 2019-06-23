import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph<T> {

	private Set<Node<T>> nodes;
	private Set<Edge<T>> edges;

	public Graph() {
		this.nodes = new HashSet<>();
		this.edges = new HashSet<>();
	}

	public Graph(Set<Node<T>> nodes, Set<Edge<T>> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	public void addNodes(T... nodes) {
		for (T val : nodes)
			this.nodes.add(new Node<T>(val));
	}

	public void addEdge(Node<T> to, Node<T> from) {
		this.edges.add(new Edge<T>(to, from, 1)); // from -> to
		this.edges.add(new Edge<T>(from, to, 1)); // from <- to
	}

	@Override
	public String toString() {
		String graphRepresentation = "";
		Iterator<Edge<T>> itr = edges.iterator();
		while (itr.hasNext()) {
			// graphRepresentation += itr. + " -> " + ", ";

		}
		return graphRepresentation;
	}

	private class Node<T> {
		private T value;
		private Set<Edge<T>> edges;

		public Node(T value) {
			this.value = value;
		}
	}

	private class Edge<T> {
		private Node<T> to;
		private Node<T> from;
		private Number cost;

		public Edge(Node<T> to, Node<T> from, Number cost) {
			this.to = to;
			this.from = from;
			this.cost = cost;
		}

	}
}