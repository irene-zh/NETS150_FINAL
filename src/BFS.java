
import java.util.*;
import java.util.Queue;
 
//Full Name: Irene Zhang
//Full Name: Kenneth Shinn
//NETS 150: Spring 2019
 
/*
* This class runs the BFS portion of the Wikipedia Racer. This helps find the "shortest path"
 * between two pages on Wikipedia. Note that the shortest path returned may not be the actual
* shortest path because only the first 10 links of a given page are saved as outgoing links.
*/
public class BFS {
       
        private BFS() {
        }
       
        /*
        * @param start - the PageNode of the beginning node
        * @param end - the PageNode of the target
        *
         * @return a list of the path to get to get from the start node to the end node
        * @return null if the query takes too long (>=10000 nodes considered) or if no path exists
        */
        public static List<String> getPath(PageNode start, PageNode end) {
                // check for valid input
                if (start == null || end == null) {
                       throw new IllegalArgumentException("Start and end nodes cannot be null.");
                }
               
                // Queue for nodes
                Queue<PageNode> q = new LinkedList<PageNode>();
               
                // keep track of discovered nodes
                ArrayList<String> discovered = new ArrayList<String>();
               
                // Keep track of parents: <K, V> = <NODE, PARENT>
                HashMap<String, String> parents = new HashMap<String, String>();
               
                // keep track of distance from start <K,V> = <node, distance>
                int dist = 0;
                ArrayList<Integer> distance = new ArrayList<Integer>();
               
                // default pagenode
                PageNode marker = new PageNode("https://en.wikipedia.org");
                q.add(start);
                q.add(marker);
                HashSet<PageNode> neighbors;
               
                /*
                * Create BFS Tree
                *
                 * NOTE: For the sake of making sure that the code does not take longer than a minute,
                * we are putting a hard cap of 1000 considered nodes for a single query. Any queries
                 * that require more than 1000 considered nodes will not return an answer.
                */
                int nodeCnt = 1;
                boolean hasFinished = false;
                while (!q.isEmpty() && nodeCnt <= 1000) {
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
                       discovered.add(temp.getURL());
                      
                       // get its neighbors
                       temp.findOutgoingLinks();
                       neighbors = temp.getOutNodes();
                      
                       // discover its neighbors and put them in the queue
                       for(PageNode neighbor : neighbors) {
                               if (!discovered.contains(neighbor.getURL())) {
                                       discovered.add(neighbor.getURL());
                                       distance.add(dist + 1);
                                       parents.put(neighbor.getURL(), temp.getURL());
                                       q.add(neighbor);
                                      
                                       nodeCnt++;
                               }                                     
                       }
                      
                       // if neighbors contains your end node, break.
                       if (discovered.contains(end.getURL())) {
                           hasFinished = true;
                               break;
                       }
                }
               
                if (hasFinished) {
                    // Create result list
                List<String> result = new LinkedList<String>();
                String temp = end.getURL();
                while(!temp.equals(start.getURL())) {
                    result.add(temp);
                    temp = parents.get(temp);
                }
                result.add(start.getURL());
               
                Collections.reverse(result);
               
                return result;
                } else {
                    // this means that the query took too long
                    return null;
                }
        }
}

