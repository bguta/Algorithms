public class Dijkstra{


public static Map<Vertex, Integer> Dij(Graph graph, Vertex start) {
		//List<Object> stuff = new ArrayList<>();
		

		Set<Vertex> Q = new HashSet<>();
		Map<Vertex, Integer> dis = new HashMap<>();
		Map<Vertex, List<Vertex>> path = new HashMap<>();

		for (Vertex v : graph.getVertices()) {
			dis.put(v, Integer.MAX_VALUE - 1);
			path.put(v, new ArrayList<>());
			Q.add(v);
		}
		
		dis.put(start, 0);

		while (!Q.isEmpty()) {
			
			Vertex u = new Vertex("");
			Integer min = Integer.MAX_VALUE;
			for (Vertex v : Q) {
				if (dis.get(v) < min) {
					u = v;
					min = dis.get(v);
				}
			}
			
			Q.remove(u);
			if(u.getLabel() != "") {
			for( Vertex v : graph.getDownstreamNeighbors(u)) {
				if(Q.contains(v)) {
					int alt = dis.get(u) + 1;
					if(alt < dis.get(v)) { //shorter path
						dis.put(v, alt);
						path.get(v).add(u);
					}
				}
			}
			}
			
		}
		
		return dis;
		//stuff.add(path);
		
	}
}