import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
	public int value;
	public boolean visited;
	public List<Edge> connections;

	public Node(int value) {
		this.value = value;
		this.connections = new ArrayList<>();
		this.visited = false;
	}

	@Override
	public int hashCode() {
		return 10;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (this.value != other.value)
			return false;
		return true;
	}

	public Node(int value, boolean visited) {
		this.value = value;
		this.visited = visited;
		this.connections = new ArrayList<>();
	}

	public Node(int value, boolean visited, Edge... edges) {
		this.value = value;
		this.visited = visited;
		this.connections = Arrays.asList(edges);
	}

	@Override
	public String toString() {
		return "Node: " + value + ", Visited: " + visited;
	}

}