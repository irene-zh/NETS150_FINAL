import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

//Full Name: Kenneth Shinn
//Full Name: Irene Zhang
//NETS 150: Spring 2019
public class BFSTest {
	@Test
	public void testShortDistance() {
		long startTime = System.currentTimeMillis();
		
		PageNode start = new PageNode("https://en.wikipedia.org/wiki/Technology_High_School_"+
                "(Rohnert_Park,_California)");
		PageNode end = new PageNode("https://en.wikipedia.org/wiki/Foreign_language");	
		List<String> result = BFS.getPath(start, end);
		System.out.println(result.toString());
		
		long endTime = System.currentTimeMillis();
	    System.out.println("Took " + (endTime-startTime)/1000 + "s to run");
	}
}
