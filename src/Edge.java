public class Edge {
	public Node start;
	public Node end;
	public double weight;

	public Edge(Node start, Node end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public Edge reverseEdge(Edge edge){
		return new Edge(this.end, this.start, this.weight);
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
		Edge other = (Edge) obj;
		if (this.start.value == other.start.value && this.end.value == other.end.value && this.weight != other.weight)
			return true;//Don't let to be more than one edge with different weight, be between two nodes with same values
		if (this.start.value != other.start.value || this.end.value != other.end.value)
			return false;
		return true;
	}

	/*
	 * public Edge(int start, int end, double weight) { this.start = start;
	 * this.end = end; this.weight = weight; }
	 */

	@Override
	public String toString() {
		return start.value + " --(" + weight + ")-> " + this.end.value;
	}

}
