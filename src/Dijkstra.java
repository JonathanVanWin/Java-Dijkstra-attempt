import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
	
	public List<List<Row>> shortest;
	
	public Dijkstra(){
		// A list of lists: the inner list represents one line of a table,
		// that contains the shortest paths found from one node, then we select
		// a node from them and we calculate paths from neighbours	
		this.shortest = new ArrayList<>();
	}
	
	// Initialize first line of paths
	private int initialize(Node start, Graph g){
		List<Node> neighbours = getNeighbours(start);
		shortest.add(new ArrayList<>(g.nodes.size()));
		
		int indexNeighbour = 0, shortestPathIndex = 0;
		for (int i = 0; i < g.nodes.size(); i++) {
			if(start.equals(g.nodes.get(i)))
				shortest.get(0).add(new Row(start, 0, start));
			else if(neighbours.indexOf(g.nodes.get(i)) !=-1)//if it's a neighbour
				shortest.get(0).add(new Row(start.connections.get(indexNeighbour).end, start.connections.get(indexNeighbour++).weight, start));
			else 
				shortest.get(0).add(new Row(g.nodes.get(i),Double.POSITIVE_INFINITY,null));
			if (i!=0&&shortest.get(0).get(i).dist < shortest.get(0).get(shortestPathIndex).dist)
				shortestPathIndex = i;
		}
		start.visited =true; // We have finished exploring all neighbours
		return shortestPathIndex;//Returns index of next node.
	}
	
	public int getSmallestCost(){
		//find shortestPathIndex 
	}
	
	public int calculateNextRow(Node start, Graph g,int row, double dist){
		List<Node> neighbours = getNeighbours(start);
		shortest.add(new ArrayList<>(g.nodes.size()));
		
		int indexNeighbour = 0, shortestPathIndex = 0;
		for (int i = 0; i < g.nodes.size(); i++) {
			if(g.nodes.get(i).visited){
				shortest.get(row).add(shortest.get(row-1).get(i));
				continue;
			}
			if(start.equals(g.nodes.get(i)))
				shortest.get(row).add(new Row(start, 0, start));
			//if it's a neighbour and the new distance is smaller then update
			else if(neighbours.indexOf(g.nodes.get(i)) !=-1 && dist + start.connections.get(indexNeighbour).weight <shortest.get(row-1).get(i).dist)
				shortest.get(row).add(new Row(start.connections.get(indexNeighbour).end, start.connections.get(indexNeighbour++).weight, start));
			//if it's not smaller then copy from before
			else if(neighbours.indexOf(g.nodes.get(i)) !=-1 )
				shortest.get(row).add(shortest.get(row-1).get(i));
			else 
				shortest.get(row).add(new Row(g.nodes.get(i),Double.POSITIVE_INFINITY,null));
			
			if (!shortest.get(row).get(i).current.equals(start)&& shortest.get(row).get(i).dist < shortest.get(0).get(shortestPathIndex).dist )
				shortestPathIndex = i;
		}
		start.visited =true; // We have finished exploring all neighbours
		return shortestPathIndex;//Returns index of next node.
	}
	
	public List<Node> getNeighbours(Node node){
		List<Node> neighbours  = new ArrayList<>(node.connections.size());
		for(int i=0; i<node.connections.size(); i++){
			neighbours.add(node.connections.get(i).end);
		}
		return neighbours;
	}
	
	public void dijkstra(Node start, Graph g){
		int temp = initialize(start, g); 
		Node newStart = shortest.get(0).get(temp).current;
		temp = calculateNextRow(newStart, g, 1, shortest.get(0).get(temp).dist);
		newStart = shortest.get(1).get(temp).current;
	}
	
	@Override
	public String toString() {
		String allPaths= "";
		for(List<Row> row: shortest){
			for(Row element: row)
				allPaths+=element+"  |  ";
			allPaths+="\n";
		}
		return allPaths;
	}
	
	/*
	
	public void dijkstra(Node start, Graph graph) {
		
		initialize(start);

		int shortestPathIndex = 0;
		Node n = start;
		double cost = 0;
		

		for (int i = 1; i < 0; i++) {
			shortest.add(new ArrayList<>());

			//Loop trough connections
			for(int j=0; j<graph.nodes.size(); j++){
				//if(graph.nodes)
				shortest.get(i).add(new Dijkstra(n.connections.get(j).end, n.connections.get(j).weight + cost, n));
				if (n.connections.get(j).weight < n.connections.get(shortestPathIndex).weight)
					shortestPathIndex = i;			
			}
			n = n.connections.get(shortestPathIndex).end;/* <- This is like start **/
			/*cost = n.connections.get(shortestPathIndex).weight + cost;
		}
	}*/





	private class Row{
		public Node current;
		public double dist;
		public Node previous;
		
		public Row(Node current, double dist, Node previous) {
			this.current = current;
			this.previous = previous;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return current + ", distance: " + dist + ", " + previous ;
		}
	}
}
