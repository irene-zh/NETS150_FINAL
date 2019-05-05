import java.util.*;

public class BFS {
	
	private BFS() {
	}
	
	public static List<Integer> getPath(PageNode start, PageNode end) {
		// check for null input
		//if(!(g.containsNode(start) && g.containsNode(end))) {
		//	throw new NullPointerException("Error: start and end nodes must be in graph.");
		//}
		if (!start.isValidPage() || !end.isValidPage()) {
			throw new IllegalArgumentException("Start and end nodes must be valid pages");
		}
		// Queue for nodes
		Queue<PageNode> q = new LinkedList<PageNode>();
		
		// keep track of discovered nodes
		ArrayList<PageNode> discovered = new ArrayList<PageNode>();
		
		// Keep track of parents: <K, V> = <NODE, PARENT>
		HashMap<PageNode, PageNode> parents = new HashMap<PageNode, PageNode>();
		
		// keep track of distance from start <K,V> = <node, distance>
		int dist = 0;
		ArrayList<Integer> distance = new ArrayList<Integer>();
		
		// default pagenode
		PageNode marker = new PageNode("https://en.wikipedia.org");
		q.add(start);
		q.add(marker);
		HashSet<PageNode> neighbors;// = g.getNeighbors(start);
		
		// Create BFS Tree
		while (!q.isEmpty()) {
			// remove the first element in the queue
			PageNode temp = q.remove();
			
			if (temp.equals(marker)) {
				if (q.isEmpty()) {
					break;
				}
				dist += 1;
				temp = q.remove();
				q.add(marker);
			}
			// add it to discovered
			discovered.add(temp);
			// get it's neighbors
			//neighbors = g.getNeighbors(temp);
			temp.findOutgoingLinks();
			neighbors = temp.getOutNodes();
			
			// discover its neighbors and put them in the queue
			for(PageNode neighbor : neighbors) {
				if (!discovered.contains(neighbor)) {
					discovered.add(neighbor);
					distance.add(dist + 1);
					parents.put(neighbor, temp);
					q.add(neighbor);
				} 					
			}
		} 
		
		// Create result list
		List<Integer> result = new LinkedList<Integer>();
		//for (int i = end; i != start; i = parents.get(i)) {
		//	result.add(i);
		//}
		//result.add(start);
		Collections.reverse(result);
		
		// print out how many nodes with a distance of 4
		int c = 0;
		for(int x = 0; x < distance.size() ; x++ ) {
			if (distance.get(x) <= 4) {
				c += 1;
			}
		}
		System.out.println("number of edges 4 away from start: " + c);
		System.out.println("max distance: " + Collections.max(distance));
		
		return result;
	}
}
