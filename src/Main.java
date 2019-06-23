public class Main {

    public static String readTextFileFromRawResource(final Context context, final int resourceId) {
        final InputStream inputStream = context.getResources().openRawResource(resourceId);
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String nextLine;
        final StringBuilder body = new StringBuilder();

        try {
                while ((nextLine = bufferedReader.readLine()) != null) {
                    body.append(nextLine);
                    body.append('\n');
                }
        } catch (IOException e) {
            return null;
        }
        return body.toString();
    }
	
	public static void main(String[] args) {
		/*GraphMatrix graph = new GraphMatrix(4);
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 2, 8);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1,3, 4);
		graph.addEdge(2, 3, 2);
		Graph graph = new Graph();
		graph.addNodes(0,1,2,3);
		
		graph.addEdges(0,1,3,
					   0,2,8,
					   1,2,1,
					   1,3,4,
					   2,3,2);

		System.out.println(graph+"\n\n\n");
		
		Dijkstra d = new Dijkstra();
		d.dijkstra(graph.nodes.get(0), graph);
		System.out.println(d);*/
		String a="abc1";
		System.out.println(123);
		//System.out.println(a.substring());
	}
}
